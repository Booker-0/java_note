<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/3/29
  Time: 23:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE HTML>
<html>
<head>
  <title>首页</title>
  <style type="text/css">
    a{
      text-decoration: none;
      color: black;
      font-size: 18px;
    } h3 {
      width: 180px;
      height: 38px;
      margin: 100px auto;
      text-align: center;
      line-height: 38px;
      background: deepskyblue;
      border-radius: 4px;
    }
  </style>
</head>
<body>
<h3>
  <a href="${pageContext.request.contextPath}/book/allBooks">点击进入列表页</a>
</h3>
</body>
</html>
