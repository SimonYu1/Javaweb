package com.servlet;
import com.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/*
* 实现servlet
*/
@WebServlet("/ser05")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        PrintWriter out =resp.getWriter();

        if("admin".equals(username)&&"123456".equals(password)){
            resp.getWriter().print("欢迎您，"+username);
            resp.getWriter().print("<a href='login.html'>退出</a>");
        }else {
            out.print("用户或密码错误，登录失败 ");
            resp.getWriter().print("<a href='login.html'>重新登录</a>");
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}