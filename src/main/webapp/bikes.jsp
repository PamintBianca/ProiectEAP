<%@ page import="models.Bike" %>
<%@ page import="java.util.List" %><%--
<%--
  Created by IntelliJ IDEA.
  User: Bianca
  Date: 5/21/2020
  Time: 3:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Biciclete</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
</head>
<body>
<%
    if(request.getAttribute("bikes")!=null)
    {
        List<Bike> lista= (List<Bike>) request.getAttribute("bikes");
        out.print("<table class='table'><tr><th>ID BIKE</th><th>COMPANY</th><th>IS AVAILABLE</th></tr>");
        for(Bike b: lista)
        {
            out.print("<tr><td>"+b.getIdbike()+"</td><td>"+b.getCompanyName()+"</td><td>"+ b.isAvailable()+"</td></tr>");

        }
        out.print("</table>");
    }
%>
<h3 align="center">Add bike.</h3>
<form align="center" method="post" action="/companybikes" class="form">
    ID COMPANIE: <input type="text" name="idcompany"><br>
    <input type="submit" class="btn btn-warning" value="Save!!!">
</form>
</body>
</html>
