package com.qjf.shiro;

import org.apache.shiro.authc.AuthenticationException;

/**
 * @Author:Tin
 * @Date: create in 2018/1/10 15:22
 * @Description: 自定義驗證碼異常類，向用戶報告精確的異常信息
 */
public class VerificationCodeException extends AuthenticationException {

    public VerificationCodeException() {
    }

    public VerificationCodeException(String message) {
        super(message);
    }

    public VerificationCodeException(Throwable cause) {
        super(cause);
    }

    public VerificationCodeException(String message, Throwable cause) {
        super(message, cause);
    }

}
