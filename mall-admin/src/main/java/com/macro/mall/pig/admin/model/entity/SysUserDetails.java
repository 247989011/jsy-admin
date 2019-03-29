package com.macro.mall.pig.admin.model.entity;

import com.macro.mall.pig.common.vo.MenuVO;
import org.apache.commons.lang.StringUtils;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * SpringSecurity需要的用户详情
 * @author panqq
 * @date 2019-01-18 21:38:39
 */
public class SysUserDetails implements UserDetails {
    private SysUser sysUser;
    private List<MenuVO> menuList;
    public SysUserDetails(SysUser sysUser, List<MenuVO> menuList) {
        this.sysUser = sysUser;
        this.menuList = menuList;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        //返回当前用户的api权限
        return menuList.stream()
                .filter(menuVO -> StringUtils.isNotEmpty(menuVO.getUrl()))
                .map(menuVO ->new SimpleGrantedAuthority(menuVO.getUrl()))
                .collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return sysUser.getPassword();
    }

    @Override
    public String getUsername() {
        return sysUser.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        //0-正常，1-删除
        return sysUser.getDelFlag().equals("0");
    }
}
