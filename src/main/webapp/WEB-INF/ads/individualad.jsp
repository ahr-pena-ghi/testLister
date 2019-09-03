<%--
  Created by IntelliJ IDEA.
  User: victorpena
  Date: 2019-08-29
  Time: 14:45
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>ad details</h1>
<p><c:out value="${sessionScope.user.username}"/></p>
<p><c:out value="${ad.title}"/></p>
<p><c:out value="${ad.price}"/></p>


<img src="${ad.picture}"/>


<c:if test="${sessionScope.user != null && sessionScope.user.id == ad.userId}">

<form action="/individualad" method="POST">
    <div class="col-md-6">
        <h2><a href="http://localhost:8080/individualad?id=${ad.id}">${ad.title}</a></h2>

        <div class="form-group">
            <label for="title">Title</label>
            <input id="title" name="title" class="form-control" type="text">
        </div>
        <div class="form-group">
            <label for="description">Description</label>
            <textarea id="description" name="description" class="form-control" type="text"></textarea>
        </div>
        <div class="form-group">
            <label for="price">Price</label>
            <textarea id="price" name="price" class="form-control" type="text"></textarea>
        </div>
        <div class="form-group">
            <label for="picture">Picture</label>
            <textarea id="picture" name="picture" class="form-control" type="text"></textarea>
        </div>
        <div class="form-group">
            <input name="category_id" class="form-control" type="checkbox" value="1">Games</input>
            <input name="category_id" class="form-control" type="checkbox" value="2">Automotive</input>
            <input name="category_id" class="form-control" type="checkbox" value="3">Furniture</input>
            <input name="category_id" class="form-control" type="checkbox" value="4">Electronics</input>
            <input name="category_id" class="form-control" type="checkbox" value="5">Jobs</input>
            <input name="category_id" class="form-control" type="checkbox" value="6">Tools</input>
            <input name="category_id" class="form-control" type="checkbox" value="7">Sports</input>
            <input name="category_id" class="form-control" type="checkbox" value="8">Arts & Crafts</input>
            <input name="category_id" class="form-control" type="checkbox" value="9">Animals</input>
            <input name="category_id" class="form-control" type="checkbox" value="10">Other</input>
        </div>
        <button id="delete" name="delete"  type="submit" value="${ad.id}">Delete</button>
        <button id="edit" name="edit"  type="submit" value="${ad.id}">Edit</button>
        <%--            <a href="/ads/edit" value="${ad.id}">Edit</a>--%>
        <%--            <button class="form-group" id="edit" name="edit"  type="submit" value="${ad.id}">submit</button>--%>

    </div>
    </c:if>
<%--<p><c:out value="${ad.price}"/></p>--%>




</body>
</html>
