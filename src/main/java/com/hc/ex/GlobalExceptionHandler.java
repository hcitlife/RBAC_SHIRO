package com.hc.ex;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(UnauthorizedException.class)
    public void unauthorizedExceptionHandler(UnauthorizedException e) {
        PrintWriter out = null;
        try {
            ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
            HttpServletRequest request = requestAttributes.getRequest();
            HttpServletResponse response = requestAttributes.getResponse();
            String header = request.getHeader("X-Requested-With");
            if (StringUtils.isNoneBlank(header) && "XMLHttpRequest".equalsIgnoreCase(header)) {//AJAX请求
                response.setCharacterEncoding("UTF-8");
                response.setContentType("application/json; charset=utf-8");
                out = response.getWriter();
                out.write("{\"status\":401,\"message\":\"无权访问\"}");
            } else {
                String contextPath = request.getContextPath();
                if ("/".equals(contextPath)) {
                    contextPath = "";
                }
                response.sendRedirect(contextPath + "/unauth");
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }
}
