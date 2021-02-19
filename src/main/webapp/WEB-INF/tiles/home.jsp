<%--
  Created by IntelliJ IDEA.
  User: paulina
  Date: 11/02/2021
  Time: 12:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<div class="row">
    <div class="col-md-10 offset-1">
        <div class="card">
            <div class="card-header">
                <h4>List of ingredients:</h4>
            </div>
            <div class="card-body">
                <table class="table table-hover">
                    <thead>
                    <tr>
                        <th scope="col">Ingredient</th>
                        <th scope="col">Calories (kcal)</th>
                        <th scope="col">Glycemic Index</th>
                    </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="ingredient" items="${ingredientsList}">
                            <tr>
                                <th scope="row"><c:out value="${ingredient.name}"/></th>
                                <td><c:out value="${ingredient.calories}"/></td>
                                <td><c:out value="${ingredient.gi}"/></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>




