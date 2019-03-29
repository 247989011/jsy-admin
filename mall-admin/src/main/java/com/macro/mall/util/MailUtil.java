package com.macro.mall.util;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MailUtil {
    /**
     *检查Email 格式（正则表达式）
     * @param content
     * @return
     */
    public static boolean checkEmailFormat(String content){
        if(content.contains("@")&&content.contains(".")) {
            if(content.lastIndexOf(".")>content.lastIndexOf("@")) {
                log.debug("邮箱格式合法");
                return true;
            }
        }else {
            log.error("邮箱格式不合合法..");
           return false;
        }
        log.error("邮箱格式不合法...");
        return false;
    }
}
