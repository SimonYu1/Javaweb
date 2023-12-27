package servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String remember = request.getParameter("remember");
        PrintWriter out = response.getWriter();
        //由于未连接数据库，内置的账号为：yuxinbao 密码为：123456
        if("yuxinbao".equals(username)&&("123456").equals(password)){

            // 假设用户验证通过
            if ("on".equals(remember)) {
                // 如果用户选择记住用户名和密码，则创建Cookie并设置有效期
                Cookie usernameCookie = new Cookie("username", username);
                usernameCookie.setMaxAge(30 * 24 * 60 * 60); // 设置为30天
                response.addCookie(usernameCookie);

                Cookie passwordCookie = new Cookie("password", password);
                passwordCookie.setMaxAge(30 * 24 * 60 * 60);
                response.addCookie(passwordCookie);
            } else {
                // 如果用户没有选择记住，则删除之前保存的Cookie
                Cookie[] cookies = request.getCookies();
                if (cookies != null) {
                    for (Cookie cookie : cookies) {
                        if ("username".equals(cookie.getName()) || "password".equals(cookie.getName())) {
                            cookie.setMaxAge(0);
                            response.addCookie(cookie);
                        }
                    }
                }
            }
            out.write("欢迎你，"+username);
        }else {
            out.write("用户或密码错误，登录失败");
            out.write(
                    "<a href='/web05/login.jsp'>重新登陆</a>");
        }

    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
