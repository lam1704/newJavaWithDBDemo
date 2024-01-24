<%@ page import="java.util.ArrayList" %>
<%@ page import="model.Human" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>List Humans</title>
    </head>
    <body>
        <h1>List of Humans</h1>

        <table border="1">
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Date of Birth</th>
                <th>Gender</th>
                <th>Type</th>
            </tr>

            <%
ArrayList<Human> humans = (ArrayList<Human>)request.getAttribute("humans");
out.println("Number of humans: " + (humans != null ? humans.size() : 0)); // Debug information

if (humans != null && !humans.isEmpty()) {
    for (Human human : humans) {
        out.println("ID: " + human.getID()); // Debug information
        out.println("Name: " + human.getName()); // Debug information
        out.println("Date of Birth: " + human.getDob()); // Debug information
        out.println("Gender: " + (human.isGender() ? "Male" : "Female")); // Debug information
        out.println("Type: " + human.getType().getName()); // Debug information
    }
} else {
    out.println("Humans list is null or empty.");  
}
%>
        </table>

    </body>
</html>
