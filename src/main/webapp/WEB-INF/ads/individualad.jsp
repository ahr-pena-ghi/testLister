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
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="${ad.title} - Adlister" />
    </jsp:include>
    <style><%@include file="/WEB-INF/partials/style.css"%></style>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp" />

<h3><a href="/"> Back to ads list</a></h3>
<p><c:out value="${sessionScope.user.username}"/></p>
<h1><c:out value= "${ad.title}"/> - $${ad.price}</h1>
<div class="container ad-img-view">
    <img src="${ad.picture}" alt="Ad image"/>
</div>
<br>
<h4><c:out value= "${ad.description}"/></h4>

<c:if test="${sessionScope.user != null && sessionScope.user.id == ad.userId}">

<form action="/individualad" method="POST">
    <div class="col-md-6">
        <h2><a href="http://localhost:8080/individualad?id=${ad.id}">${ad.title}</a></h2>

        <div class="form-group">
            <label for="title">Title</label>
            <input id="title" name="title" class="form-control" type="text" value="${ad.title}">
        </div>
        <div class="form-group">
            <label for="description">Description</label>
            <textarea id="description" name="description" class="form-control">${ad.description}</textarea>
        </div>
        <div class="form-group">
            <label for="price">Price</label>
            <textarea id="price" name="price" class="form-control">${ad.price}</textarea>
        </div>
        <div class="form-group">
            <label for="picture">Picture</label>
            <textarea id="picture" name="picture" class="form-control">${ad.picture}</textarea>
        </div>
        <div class="form-group">
            <input name="category_id" class="form-control" type="checkbox" value="1"
            <c:if test="${cats}.indexOf(1) > -1"> checked </c:if>
            >Games</input>
            <input name="category_id" class="form-control" type="checkbox" value="2"
            <c:if test="${cats}.indexOf(2) > -1"> checked </c:if>
            >Automotive</input>
            <input name="category_id" class="form-control" type="checkbox" value="3"
            <c:if test="${cats}.indexOf(3) > -1"> checked </c:if>
            >Furniture</input>
            <input name="category_id" class="form-control" type="checkbox" value="4">
            <c:if test="${cats}.indexOf(4) > -1"> checked </c:if>
            Electronics</input>
            <input name="category_id" class="form-control" type="checkbox" value="5">
            <c:if test="${cats}.indexOf(5) > -1"> checked </c:if>
            Jobs</input>
            <input name="category_id" class="form-control" type="checkbox" value="6">
            <c:if test="${cats}.indexOf(6) > -1"> checked </c:if>
            Tools</input>
            <input name="category_id" class="form-control" type="checkbox" value="7">
            <c:if test="${cats}.indexOf(7) > -1"> checked </c:if>
            Sports</input>
            <input name="category_id" class="form-control" type="checkbox" value="8">
            <c:if test="${cats}.indexOf(8) > -1"> checked </c:if>
            Arts & Crafts</input>
            <input name="category_id" class="form-control" type="checkbox" value="9">
            <c:if test="${cats}.indexOf(9) > -1"> checked </c:if>
            Animals</input>
            <input name="category_id" class="form-control" type="checkbox" value="10">
            <c:if test="${cats}.indexOf(10) > -1"> checked </c:if>
            Other</input>
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
