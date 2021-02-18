<%--
  Created by IntelliJ IDEA.
  User: paulina
  Date: 15/02/2021
  Time: 11:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<div class="row">
    <div class="col-md-8 offset-2">
        <div class="card">
            <div class="card-header">
                <h4>Add a ingredient:</h4>
            </div>
            <div class="card-body">
                <form:form method="post" modelAttribute="ingredient" class="input-form">
                    <div class="errors">
                        <form:errors path="name"/>
                    </div>
                    <div class="input-group">
                        <form:input type="text" path="name" class="form-control" id="formIngredientInput" placeholder="Name"></form:input>
                    </div>
                    <div class="errors">
                        <form:errors path="calories"/>
                    </div>
                    <div class="input-group">
                        <form:input type="text" path="calories" class="form-control" id="formCaloriesInput" placeholder="calories"></form:input>
                    </div>
                    <div class="errors">
                        <form:errors path="gi"/>
                    </div>
                    <div class="input-group">
                        <form:input type="text" path="gi" class="form-control" id="formGiInput" placeholder="Glycemic Index"></form:input>
                    </div>
                    <input type="submit" value="Add Ingredient"/>
                </form:form>
            </div>
        </div>
    </div>
</div>