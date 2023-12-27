<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <title>登录页面</title>
</head>
<body>

<form action="LoginServlet" method="post">
  <label for="username">用户名:</label>
  <input type="text" id="username" name="username" required><br>

  <label for="password">密码:</label>
  <input type="password" id="password" name="password" required><br>

  <label for="remember">记住我:</label>
  <input type="checkbox" id="remember" name="remember"><br>

  <input type="submit" value="登录">
</form>

</body>
</html>
