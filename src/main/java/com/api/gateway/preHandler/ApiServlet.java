package com.api.gateway.preHandler;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "apiServlet", urlPatterns = "/*")
public class ApiServlet extends HttpServlet {



    /**
     * 先获取当前请求的地址，然后再进行解析匹配,再经过过滤器处理
     * @param req
     * @param res
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        //1. 获取当前请求的地址
        String requestUrl = String.valueOf(req.getRequestURL());

        //2.进行解析匹配
        boolean next = URLParseMapping.deal(requestUrl);

        if (!next){
            return;
        }
        //3.经过过滤器处理

    }
}
