<%@ page import="java.util.ArrayList" %>
<%@ page import="model.HumanType" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Insert Human</title>
</head>
<body>
    <h1>Insert Human</h1>
    
    <form action="InsertController" method="post">
        <label for="name">Name:</label>
        <input type="text" name="name" required><br>
        
        <label for="dob">Date of Birth:</label>
        <input type="date" name="dob" required><br>
        
        <label for="gender">Gender:</label>
        <input type="radio" name="gender" value="1" required>Male
        <input type="radio" name="gender" value="0" required>Female<br>
        
        <label for="type">Type:</label>
        <select name="type" required>
            <%
    ArrayList<HumanType> types = (ArrayList<HumanType>)request.getAttribute("types");
    if (types != null) {
        for (HumanType type : types) {
%>
            <option value="<%= type.getTypeID() %>"><%= type.getName() %></option>
<%
        }
    }
%>
        </select><br>
        
        <input type="submit" value="Submit">
    </form>
    
</body>
</html>
