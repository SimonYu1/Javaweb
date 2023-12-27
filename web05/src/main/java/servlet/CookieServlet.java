package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/ser02")
public class CookieServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设置响应内容类型
        response.setContentType("text/html;charset=UTF-8");
        // 读取客户端的 Cookie
        Cookie[] cookies = request.getCookies();

        PrintWriter out = response.getWriter();
        out.println("<html><body>");

        if (cookies != null) {
            out.println("<h2>已有的 Cookie：</h2>");
            for (Cookie cookie : cookies) {
                out.println("<p>" + cookie.getName() + ": " + cookie.getValue() + "</p>");
            }
        } else {
            out.println("<h2>没有 Cookie。</h2>");
        }

        // 创建自定义的 Cookie 对象
        Cookie customCookie = new Cookie("name", "yuxinbao");

        // 设置 Cookie 的持久性，单位为秒
        customCookie.setMaxAge(60 * 60 * 24 * 7); // 一周

        // 在响应中写入自定义的 Cookie
        response.addCookie(customCookie);

        out.println("<h2>已设置的 Cookie：</h2>");
        out.println("<p>" + customCookie.getName() + ": " + customCookie.getValue() + "</p>");

        out.println("</body></html>");

        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       this.doGet(req,resp);
    }
}
