package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import entity.Product;
import java.util.List;

@WebServlet("/AddProductServlet")
public class AddProductServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String productName = request.getParameter("productName");
        double productPrice = Double.parseDouble(request.getParameter("productPrice"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));

        // 创建 Product 对象
        Product product = new Product(productName, productPrice, quantity);

        // 获取或创建 session
        HttpSession session = request.getSession(true);

        // 获取购物车列表
        List<Product> cart = (List<Product>) session.getAttribute("cart");

        if (cart == null) {
            // 如果购物车为空，创建一个新的购物车列表
            cart = new ArrayList<>();
        }

        // 添加产品到购物车
        cart.add(product);

        // 更新 session 中的购物车列表
        session.setAttribute("cart", cart);

        // 返回 addProduct.html 页面
        response.sendRedirect("addProduct.html");
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    this.doPost(request,response);
    }
}
