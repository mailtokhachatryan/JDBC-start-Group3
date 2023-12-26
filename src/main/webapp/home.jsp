<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Home</title>
</head>
<body>

<%
    if (request.getSession().getAttribute("id") == null) {
        request.setAttribute("message", "Login first!!!");
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
%>


<h1>Welcome to home page dear <%=request.getSession().getAttribute("name")%>
</h1>


</body>
</html>