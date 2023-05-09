<%@ page import="java.util.ArrayList" %>
<%@ page import="kz.bitlab.techorda.db.Item" %>
<%@ page import="kz.bitlab.techorda.db.User" %><%--
  Created by IntelliJ IDEA.
  User: Aza
  Date: 13.04.2023
  Time: 15:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel = "stylesheet" type = "text/css" href = "/css/bootstrap.css">
    <link rel = "stylesheet" type = "text/css" href = "/css/style.css">
    <script defer src="/js/bootstrap.js"></script>
</head>
<body>

<%
    User user = (User)session.getAttribute("currentUser");
%>

<div class = "container">

    <nav class="navbar navbar-expand-lg bg-light">
        <div class="container-fluid">
            <a class="navbar-brand" href="/" ><strong>BITLAB SHOP</strong></a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse position-absolute top-0 end-0" id="navbarNav">
                <ul class="navbar-nav">
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="#">Top Sales</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link active" href="#">New Sales</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link active" href="#">By Category</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link active" href = "/login"><%=user.getFullName()%></a>

                    </li>
                </ul>
            </div>
        </div>
    </nav>


    <div class = "welcome">
        <div class = "position-absolute start-50 translate-middle mt-5">
            <h1><strong><%=user.getFullName()%></strong></h1>
        </div>
        <div class = "position-absolute start-50 translate-middle-x mt-5">
            <h4 class = "text-secondary mt-5">This is your profile edge</h4>
        </div>

    </div>
</div>
</body>
</html>