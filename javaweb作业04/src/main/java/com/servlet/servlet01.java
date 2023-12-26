package com.servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

/*
* 实现servlet
*/
@WebServlet("/ser01")
public class servlet01 extends HttpServlet {


    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        System.out.println("servlet被调用了...");
        PrintWriter out =resp.getWriter();
        out.println("调用servlet的服务方法");
    }

    @Override
    public void destroy() {
        System.out.println("servlet被销毁了");
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("servlet被创建了");

    }
}