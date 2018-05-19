package com.qjf.shiro;

import org.apache.shiro.authc.UsernamePasswordToken;

/**
 * @Author:Tin
 * @Date: create in 2018/1/10 15:41
 * @Description: 自定義token類添加驗證碼
 */
public class UsernamePasswordCodeToken extends UsernamePasswordToken {

    //验证码字符串
    private String captcha;

    public UsernamePasswordCodeToken(String username, String password,
                                        boolean rememberMe, String host, String captcha) {
        super(username, password, rememberMe, host);
        this.captcha = captcha;
    }

    public String getCaptcha() {
        return captcha;
    }

    public void setCaptcha(String captcha) {
        this.captcha = captcha;
    }
}
