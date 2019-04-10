package com.yention.tcm.api.configurations.security;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import org.springframework.beans.factory.annotation.Autowired;
import com.google.gson.Gson;
import com.yention.tcm.api.domains.ResultResponse;

@Component
public class RestAccessDeniedHandler implements AccessDeniedHandler {
    @Autowired
    private Gson gson;

    @Override
    public void handle(HttpServletRequest httpServletRequest, 
                        HttpServletResponse response, 
                        AccessDeniedException e) throws IOException, ServletException {
        //登陆状态下，权限不足执行该方法
        System.out.println("权限不足：" + e.getMessage());
        response.setStatus(403);
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        PrintWriter printWriter = response.getWriter();
        ResultResponse result = new ResultResponse(false, e.getMessage());
        String body = gson.toJson(result);
        printWriter.write(body);
        printWriter.flush();
    }
}
