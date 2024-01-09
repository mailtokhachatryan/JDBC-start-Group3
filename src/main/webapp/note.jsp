<%@ page import="repository.note.NoteRepository" %>
<%@ page import="service.note.NoteService" %>
<%@ page import="service.note.impl.NoteServiceJDBCImpl" %>
<%@ page import="util.DataSource" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="repository.note.impl.NoteRepositoryJDBCImpl" %>
<%@ page import="model.Note" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Home</title>
</head>
<style>
    table, th, td {
        border: 1px solid;
    }
</style>
<body>
<form action="http://localhost:8080/login" method="post">
    <h1>Notes</h1>

    <%
        if (request.getSession().getAttribute("id") == null) {
            request.setAttribute("message", "Login first!!!");
            request.getRequestDispatcher("welcome.jsp").forward(request, response);
        }
    %>

    <%
        Connection connection = DataSource.getConnection();
        NoteService noteService = new NoteServiceJDBCImpl(new NoteRepositoryJDBCImpl(connection), connection);

        List<Note> notes = noteService.getAll((Integer) request.getSession().getAttribute("id"));

    %>

    <table>
        <tr>
            <td>
                Title
            </td>

            <td>
                Description
            </td>
        </tr>

        <% for (Note note : notes) { %>
        <tr>
            <td>
                <%= note.getTitle()%>
            </td>

            <td>
                <%= note.getDescription()%>
            </td>
        </tr>

        <% } %>


    </table>

</form>

<form action="http://localhost:8080/createNote" method="post">
    Title: <input name ="title" ><br>
    Description: <input name ="description" ><br>
    <button type="submit">Creat Note</button>
</form>

</body>
</html>