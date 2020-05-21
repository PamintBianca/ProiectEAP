<%@ page import="models.User" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: sebas
  Date: 13/05/2020
  Time: 15:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Log in</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
</head>
<body>
<h3 align="center">Salut! Introdu username-ul pentru a te loga</h3>
<form align="center" method="post" action="/login" class="form">
    <input type="text" name="email"><br>
    <input type="password" name="password"><br>
    <input type="submit" class="btn btn-success" value="Log in!">
</form>

<p align="center">
    <%
        if (request.getAttribute("loginError") != null)
            out.print(request.getAttribute("loginError"));
        else if (request.getAttribute("nume") != null && request.getAttribute("prenume") != null) {
            out.print("Salut " + request.getAttribute("nume") + " " + request.getAttribute("prenume"));

            out.print("<br>");
            out.print("<br>");

//
//            String form = "<form align='center' method='post' action='/relatie'>\n" +
//                    "    <input type='hidden' name='username' value='" + request.getAttribute("email") + "'><br>\n" +
//                    "    <input type='submit' value=''>\n" +
//                    "</form>";
//
//            out.print(form);
        }
    %>
</p>

<p align="center">
    <%
        //        if (request.getAttribute("proiecteAngajat") != null) {
//            List<Proiect> proiects = (List<Proiect>) request.getAttribute("proiecteAngajat");
//
//            out.print("<br>");
//
//            for (Proiect proiect : proiects) {
//                out.print(proiect);
//                out.print("<br>");
//            }
//
//            out.print("<br>");
//            out.print("Username-ul este " + request.getAttribute("username"));
//        }
    %>
</p>

</body>
</html>
