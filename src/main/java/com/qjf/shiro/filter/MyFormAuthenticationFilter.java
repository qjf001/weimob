package com.qjf.shiro.filter;

import com.qjf.demo.service.impl.AdminUserServiceImpl;
import com.qjf.shiro.UsernamePasswordCodeToken;
import com.qjf.shiro.VerificationCodeException;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.util.WebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @Author:Tin
 * @Date: create in 2018/1/10 15:51
 * @Description: 登录验证过滤器
 */
public class MyFormAuthenticationFilter extends FormAuthenticationFilter {

    private static final Logger log = LoggerFactory.getLogger(MyFormAuthenticationFilter.class);

    public static final String DEFAULT_ERRORMSG_KEY_ATTRIBUTE = "errorMsg";

    private String errorMsgKeyAttribute = "errorMsg";
    private String codeParam = "captcha";

    @Resource
    private AdminUserServiceImpl adminUserServiceImpl;

    public MyFormAuthenticationFilter(){

    }

    public String getCodeParam() {
        return this.codeParam;
    }

    public void setCodeParam(String codeParam) {
        this.codeParam = codeParam;
    }

    protected boolean executeLogin(ServletRequest request, ServletResponse response) throws Exception {
        AuthenticationToken token = this.createToken(request, response);
        // 获取session中的captcha
        HttpServletRequest req = (HttpServletRequest) request;
        HttpSession session = req.getSession();
        Object sessionCap = session.getAttribute("captcha");
        session.removeAttribute("captcha");

        String reqCap = getCode(request);

        if(StringUtils.isBlank(reqCap))
            return this.onLoginFailure(token, new VerificationCodeException("驗證碼不能為空"), request, response);
        if(null == sessionCap || !reqCap.toLowerCase().equals(sessionCap.toString()))
            return this.onLoginFailure(token, new VerificationCodeException("驗證碼不正確"), request, response);

        if(token == null) {
            String e1 = "createToken method implementation returned null. A valid non-null AuthenticationToken must be created in order to execute a login attempt.";
            throw new IllegalStateException(e1);
        } else {
            try {
                Subject e = this.getSubject(request, response);
                e.login(token);
                return this.onLoginSuccess(token, e, request, response);
            } catch (AuthenticationException var5) {
                System.out.println(var5.getMessage());
                return this.onLoginFailure(token, var5, request, response);
            }
        }
    }

    protected void setFailureAttribute(ServletRequest request, AuthenticationException ae) {
        String className = ae.getClass().getName();
        request.setAttribute(this.getFailureKeyAttribute(), className);
        request.setAttribute(this.getErrorMsgKeyAttribute(), ae.getMessage());
    }

    protected AuthenticationToken createToken(ServletRequest request, ServletResponse response) {
        String username = this.getUsername(request);
        String password = this.getPassword(request);
        String code = this.getCode(request);
        boolean rememberMe = isRememberMe(request);
        String host = getHost(request);
        return new UsernamePasswordCodeToken(username, password, rememberMe, host,code);
    }

    /**
     * @Author:QJF
     * @Date: 2018/1/29 14:59
     * @Description: 登錄成功后更新登錄用戶信息，并將用戶信息保存到session中
     */
    protected boolean onLoginSuccess(AuthenticationToken token, Subject subject, ServletRequest request, ServletResponse response) throws Exception {

        try {
            UsernamePasswordCodeToken token2 = (UsernamePasswordCodeToken) token;
            HttpServletRequest req = (HttpServletRequest) request;
//            AdminUser au = adminUserServiceImpl.updateIPandUserAgent(token2.getUsername(), IPHelper.getIpAddr(req),req.getHeader("User-Agent"));
            req.getSession().setAttribute("user",adminUserServiceImpl.findByName(token2.getUsername()));
        } catch (Exception e) {
            log.error(e.getMessage());
        }

        this.issueSuccessRedirect(request, response);
        return false;
    }

    protected String getCode(ServletRequest request) {
        return WebUtils.getCleanParam(request, this.getCodeParam());
    }

    public String getErrorMsgKeyAttribute() {
        return errorMsgKeyAttribute;
    }

    public void setErrorMsgKeyAttribute(String errorMsgKeyAttribute) {
        this.errorMsgKeyAttribute = errorMsgKeyAttribute;
    }

}
