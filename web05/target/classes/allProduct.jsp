<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="entity.Product" %>

<html>
<head>
    <title>购物车</title>
</head>
<body>

<h2>购物车</h2>

<%
    // 获取 session
     session = request.getSession(false);

    if (session != null) {
        // 获取购物车列表
        List<Product> cart = (List<Product>) session.getAttribute("cart");

        if (cart != null && !cart.isEmpty()) {
%>
<table border="1">
    <tr>
        <th>产品名称</th>
        <th>价格</th>
        <th>数量</th>
    </tr>
    <%
        // 遍历购物车列表并显示
        for (Product product : cart) {
    %>
    <tr>
        <td><%= product.getProductName() %></td>
        <td><%= product.getProductPrice() %></td>
        <td><%= product.getQuantity() %></td>
    </tr>
    <%
        }
    %>
</table>
<br/>
<a href="addProduct.html">继续购买</a>
<%
} else {
%>
<p>购物车中还没产品，请去购买<a href="addProduct.html">购买</a></p>

<%
    }
} else {
%>
<p>Session not found.</p>
<%
    }
%>

</body>
</html>
