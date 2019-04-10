package com.yention.tcm.api.configurations.security;

import com.yention.tcm.api.domains.ResultResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import com.google.gson.Gson;


@Component
public class EntryPointUnauthorizedHandler implements AuthenticationEntryPoint {

    @Autowired
    private Gson gson;

    @Override
    public void commence(HttpServletRequest request,
                         HttpServletResponse response,
                         AuthenticationException authException) throws IOException {
        //验证为未登陆状态会进入此方法，认证错误
        System.out.println("认证失败：" + authException.getMessage());
        response.setStatus(401);
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        PrintWriter printWriter = response.getWriter();
        ResultResponse result = new ResultResponse(false, authException.getMessage());
        String body = gson.toJson(result);
        printWriter.write(body);
        printWriter.flush();
    }
}
