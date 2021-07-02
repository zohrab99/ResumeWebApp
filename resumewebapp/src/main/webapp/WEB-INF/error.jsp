<%--
  Created by IntelliJ IDEA.
  User: Zohrab
  Date: 1/22/2021
  Time: 7:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Title</title>
  </head>
  <body>
      <%
        String msg=request.getParameter("msg");
      %>

  <%=msg %>
  </body>
</html>
