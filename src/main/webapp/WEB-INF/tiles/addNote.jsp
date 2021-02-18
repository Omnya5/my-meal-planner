<%--
  Created by IntelliJ IDEA.
  User: paulina
  Date: 15/02/2021
  Time: 11:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div class="row">
    <div class="col-md-8 offset-2">
        note: <%= request.getAttribute("note") %> <br/>
        jsp object: <%= this %> -- <%= this.getClass()%> <br/>
        latest note: <%= request.getAttribute("latestNote")%> <br/>

        <div class="card">
            <div class="card-header">
                <h4>Add a note</h4>
            </div>
            <div class="card-body">
                <form:form modelAttribute="note">
                    <div class="errors">
                        <form:errors path="text"/>
                    </div>
                    <div class="form-group">
                        <form:textarea path="text" name="text" rows="10" cols="50"></form:textarea>
                    </div>
                    <input type="submit" value="Add Note" />
                </form:form>
            </div>
        </div>
        <div class="card">
            <div class="card-header">
                <h4>Last note added on <fmt:formatDate pattern="E d MMMM y 'at' H:mm:ss" value="${latestNote.added}" /></h4>
            </div>
            <div class="card-body">
                <c:out value="${latestNote.text}" />
            </div>

        </div>
    </div>
</div>

