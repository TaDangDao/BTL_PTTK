<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page isELIgnored="false" %>
<html><body>
  <h2>Đăng nhập</h2>
  <form action="LoginController" method="post">
    User: <input name="username"/><br/>
    Pass: <input type="password" name="password"/><br/>
    <input type="submit" value="Login"/>
  </form>
</body></html>
