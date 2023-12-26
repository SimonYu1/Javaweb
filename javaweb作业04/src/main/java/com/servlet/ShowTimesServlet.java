package com.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/ser04")
public class ShowTimesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=GB2312");
        //设置编码，不然中文会变成乱码
        ServletContext context = this.getServletContext();
        PrintWriter out = response.getWriter();
        Integer times =(Integer)context.getAttribute("times");
        if(times==null) {
            times = new Integer(1);
        }else {
            times = new Integer(times.intValue()+1);
        }
        out.println("<html><head><title>");
        out.println("页面访问统计");
        out.println("</title></head><body>");
        out.println("当前页面被访问过了");
        out.println("<font color=yellow size=20>"+times+"</font>次");
        //设置属性，将times保存到当前的上下文中
        context.setAttribute("times", times);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
