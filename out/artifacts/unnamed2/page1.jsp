<%--
  Created by IntelliJ IDEA.
  User: sebas
  Date: 01/05/2020
  Time: 14:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h3 align="center">Bun venit pe pagina asta alba si goala!</h3>

<p>Salut si tie!</p>
<p>Pagina returnata prin intermediu servletului</p>

<%
    out.print("Text in java");
%>

<form align="center" method="post" action="/laborator">
    <label for="name">Name: </label> <br>
    <input type="text" id="name" name="name"><br>
    <input type="submit" value="Buton">
</form>

<p align="center">
    <%
        if (request.getAttribute("mesaj") != null) {
            String line = (String) request.getAttribute("mesaj");
            out.print(line);
        }
    %>
</p>


</body>
</html>
