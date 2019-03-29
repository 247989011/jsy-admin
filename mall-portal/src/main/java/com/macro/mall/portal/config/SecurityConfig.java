package com.macro.mall.portal.config;

import com.macro.mall.model.UmsMember;
import com.macro.mall.portal.component.*;
import com.macro.mall.portal.domain.MemberDetails;
import com.macro.mall.portal.service.UmsMemberRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.util.Arrays;

/**
 * TODO 上线前需要修改此文件配置
 * SpringSecurity的配置
 * Created by macro on 2018/8/3.
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UmsMemberRegisterService memberService;
    @Autowired
    private RestfulAccessDeniedHandler restfulAccessDeniedHandler;
    @Autowired
    private RestAuthenticationEntryPoint restAuthenticationEntryPoint;


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers(HttpMethod.GET, // 允许对于网站静态资源的无授权访问
                        "/",
                        "/*.html",
                        "/favicon.ico",
                        "/**/*.html",
                        "/**/*.css",
                        "/**/*.js",
                        "/portal/swagger-resources/**",
                        "/portal/v2/api-docs/**"
                )
                .permitAll()


                .antMatchers(HttpMethod.OPTIONS)//跨域请求会先进行一次options请求
                .permitAll()
                .antMatchers("/portal/sso/*")// 对登录注册要允许匿名访问
                .permitAll()
                //.antMatchers("/member/**","/returnApply/**")// 测试时开启
                .antMatchers("/**")//测试时全部运行访问
                .permitAll()
                .anyRequest()// 除上面外的所有请求全部需要鉴权认证
                .authenticated()
//                .and()
//                .exceptionHandling()
//                .accessDeniedHandler(new GoAccessDeniedHandler())
//                .authenticationEntryPoint(new GoAuthenticationEntryPoint())
//                .and()
//                .formLogin()
//                .loginPage("/portal/sso/login")
//                .successHandler(new GoAuthenticationSuccessHandler())
//                .failureHandler(new GoAuthenticationFailureHandler())
//                .and()
//                .logout()
//                .logoutUrl("/portal/sso/logout")
//                .logoutSuccessHandler(new GoLogoutSuccessHandler())
//                .invalidateHttpSession(true)
//                .deleteCookies("JSESSIONID")
//                .and()
//                .requiresChannel()
//                .antMatchers("/sso/*")
//                .requiresSecure()
//                .anyRequest()
//                .requiresInsecure()
//                .and()
//                .rememberMe()
//                .tokenValiditySeconds(1800)
//                .key("token_key")
                .and()
                .csrf()
                .disable();//开启basic认证登录后可以调用需要认证的接口
        // 禁用缓存
        http.headers().cacheControl();
        // 添加JWT filter
        http.addFilterBefore(jwtAuthenticationTokenFilter(), UsernamePasswordAuthenticationFilter.class);
        //添加自定义未授权和未登录结果返回
        http.exceptionHandling()
                .accessDeniedHandler(restfulAccessDeniedHandler)
                .authenticationEntryPoint(restAuthenticationEntryPoint);

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(userDetailsService())
//                .passwordEncoder(passwordEncoder());
        auth.authenticationProvider(loginAuthenticationProvider());
        auth.userDetailsService(userDetailsService()).passwordEncoder(passwordEncoder());

    }
    @Bean
    protected LoginAuthenticationProvider loginAuthenticationProvider() {
        LoginAuthenticationProvider loginAuthenticationProvider = new LoginAuthenticationProvider(userDetailsService(), passwordEncoder());
        return loginAuthenticationProvider;
    }
    @Override
    protected AuthenticationManager authenticationManager() throws Exception {
        ProviderManager authenticationManager = new ProviderManager(
                Arrays.asList(loginAuthenticationProvider()));
        //不擦除认证密码，擦除会导致TokenBasedRememberMeServices因为找不到Credentials再调用UserDetailsService而抛出UsernameNotFoundException
        authenticationManager.setEraseCredentialsAfterAuthentication(false);
        return authenticationManager;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        //获取登录用户信息
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String mail) throws UsernameNotFoundException {
                UmsMember member = memberService.getByEmail(mail);
                if (member != null) {
                    return new MemberDetails(member);
                }
                throw new UsernameNotFoundException("邮箱或密码错误");
            }
        };
    }

    @Bean
    public JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter(){
        return new JwtAuthenticationTokenFilter();
    }



}
