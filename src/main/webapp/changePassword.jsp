<%@ page import="util.constants.Parameter" %>
<%@ page import="util.constants.Massage" %>
<%@ page import="util.constants.Path" %><%--
  Created by IntelliJ IDEA.
  User: Owner
  Date: 09.01.2024
  Time: 10:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Chang password</title>
</head>
<body>

<h3><%= request.getAttribute("message") != null ? request.getAttribute("message") : "" %>


<%
    if (request.getSession().getAttribute(Parameter.ID) == null) {
        request.setAttribute(Parameter.MESSAGE, Massage.LOGIN_FIRST);
        request.getRequestDispatcher(Path.WELCOME).forward(request, response);
    }
%>

<form action="http://localhost:8080/changePassword" method="post">
    Last Password:  <input type="password" name="lastPassword"/><br/>
    New Password: <input type="password" name="newPassword"/><br/>
    Repeat Password: <input type="password" name="repeatPassword"/><br/>


    <button type="submit">Change Password</button>
</form>

</body>
</html>
