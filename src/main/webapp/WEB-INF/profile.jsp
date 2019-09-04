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
    <a href="/profile/edit">Edit Profile</a>


    <c:forEach var="ad" items="${ads}">
        <form action="/profile" method="POST">
        <div class="col-md-6">
            <h2><a href="http://localhost:8080/individualad?id=${ad.id}">${ad.title}</a></h2>
            <p>${ad.description}</p>
<%--            <p>${ad.price}</p>--%>
<%--            <p>${ad.picture}</p>--%>
        </div>
        </c:forEach>

</div>

</body>


</html>
