<%--
  Created by IntelliJ IDEA.
  User: Shenshuxin
  Date: 2021/4/29
  Time: 16:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  未注册的用户，请<a href="${pageContext.request.contextPath }/register"> 注册</a>！
  <br/>
  已注册的用户，去<a href="${pageContext.request.contextPath }/login"> 登录</a>！
  </body>
</html>
