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
    <title>Register</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
</head>
<body>
<h3 align="center">Salut! Aici iti poti face un cont.</h3>
<form align="center" method="post" action="/register" class="form">
    Email: <input type="text" name="email"><br>
    Parola: <input type="password" name="password"><br>
    Nume: <input type="text" name="nume"><br>
    Prenume: <input type="text" name="prenume"><br>
    <input type="submit" class="btn btn-warning" value="Register!!!">
</form>

<p align="center">
    <%
        if (request.getAttribute("loginError") != null)
            out.print(request.getAttribute("loginError"));
        else if (request.getAttribute("succes") != null) {
            //out.print("Salut " + request.getAttribute("nume") + " " + request.getAttribute("prenume"));

            //out.print("<br>");
            //out.print("<br>");


            String form = "<h1>Contul tau a fost creat cu succes! Te poti <a href='/login'>conecta</a>!</h1>";

            out.print(form);
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
