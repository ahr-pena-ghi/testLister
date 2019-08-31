<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Your Profile"/>
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp"/>

<div class="container">

    <h1>Welcome, ${sessionScope.user.username}!</h1>

    <c:forEach var="ad" items="${ads}">
        <form action="/profile" method="POST">
        <div class="col-md-6">
            <h2><a href="http://localhost:8080/individualad?id=${ad.id}">${ad.title}</a></h2>
<%--            <p>${ad.description}</p>--%>
<%--            <p>${ad.price}</p>--%>
<%--            <p>${ad.picture}</p>--%>

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
            <button id="delete" name="delete"  type="submit" value="${ad.id}">Delete</button>
            <button id="edit" name="edit"  type="submit" value="${ad.id}">Edit</button>
<%--            <a href="/ads/edit" value="${ad.id}">Edit</a>--%>
<%--            <button class="form-group" id="edit" name="edit"  type="submit" value="${ad.id}">submit</button>--%>

        </div>

    </c:forEach>

</div>
</div>

</body>


</html>
