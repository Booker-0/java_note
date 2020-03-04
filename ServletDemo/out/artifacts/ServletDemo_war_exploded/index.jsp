<%--
  Created by IntelliJ IDEA.
  User: lyy
  Date: 20-3-2
  Time: 下午11:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
<h1>这是首页，只有登录后才能查看</h1>
  <form action="/web-test/replaceServlet" method="post">
    <table>
      <tr>
        <td><input type="text" name="words"></td>
      </tr>
      <tr>
        <td><input type="submit" value="敏感字检测"></td>
      </tr>
    </table>
  </form>
  </body>
</html>
