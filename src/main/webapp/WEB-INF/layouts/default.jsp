<%--
  Created by IntelliJ IDEA.
  User: paulina
  Date: 11/02/2021
  Time: 12:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title><tiles:insertAttribute name="title" /></title>

    <c:set var="contextRoot" value="${pageContext.request.contextPath}" />
    <link href="${contextRoot}/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
    <link href="${contextRoot}/css/main.css" rel="stylesheet">

</head>
<body>
<nav class="navbar navbar-expand-md navbar-light mb-4">
    <div class="container-fluid">
        <a class="navbar-brand" href="${contextRoot}/">Logo</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="${contextRoot}/">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="${contextRoot}/about">About</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="${contextRoot}/addIngredients">Add ingredients</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link disabled" href="${contextRoot}/countCalories" aria-disabled="true">Count calories</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="${contextRoot}/addNote">Add Note</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="${contextRoot}/viewNotes">View Notes</a>
                </li>
            </ul>
        </div>
    </div>
</nav>

<div class="container">
<tiles:insertAttribute name="content" />
</div>

<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.6.0/dist/umd/popper.min.js" integrity="sha384-KsvD1yqQ1/1+IA7gi3P0tyJcT3vR+NdBTt13hSJ2lnve8agRGXTTyNaBYmCR/Nwi" crossorigin="anonymous"></script>
<script src="${contextRoot}/js/bootstrap.min.js" integrity="sha384-nsg8ua9HAw1y0W1btsyWgBklPnCUAFLuTMS2G72MMONqmOymq585AcH49TLBQObG" crossorigin="anonymous"></script>
</body>
</html>