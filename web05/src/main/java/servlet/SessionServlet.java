package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/ser01")
public class SessionServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        session.setAttribute("name","yuxinbao");

        // 获取 Session ID
        String sessionId = session.getId();

        // 获取 Session 创建时间
        long creationTime = session.getCreationTime();

        // 判断是否为新的 Session
        boolean isNew = session.isNew();

        // 获取 Session 失效时间
        long maxInactiveInterval = session.getMaxInactiveInterval();

        // 设置 Session 失效时间（以秒为单位，例如设置为 60 秒）
        session.setMaxInactiveInterval(60);

        // 输出响应
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        ((PrintWriter) out).println("<html><body>");
        out.println("<h2>会话 ID: " + sessionId + "</h2>");
        out.println("<h2>创建时间: " + creationTime + "</h2>");
        out.println("<h2>是否为新session: " + isNew + "</h2>");
        out.println("<h2>失效时间: " + maxInactiveInterval + " seconds</h2>");
        out.println("<h2>自定义属性: " + session.getAttribute("name") + "</h2>");
        out.println("</body></html>");

        session.setMaxInactiveInterval(60);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}