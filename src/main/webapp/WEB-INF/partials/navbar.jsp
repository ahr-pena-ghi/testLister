<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <a class="navbar-brand" href="/">Adlister</a>
            <input id="search" class="" type="text" onkeyup="searchAds()" placeholder="Enter Ad title">
        </div>
        <ul class="nav navbar-nav navbar-right">
    <c:choose>

    <c:when test="${sessionScope.user != null}">
        <li><a href="/profile">Profile</a></li>
        <li><a href="/ads/create">Create Ad</a></li>
        <li><a href="/logout">Logout</a></li>

    </c:when>
    <c:when test="${sessionScope.user == null}">
        <li><a href="/ads/create">Create Ad</a></li>
        <li><a href="/register">Register</a></li>
        <li><a href="/login">Login</a></li>

        </ul>
    </c:when>
    </c:choose>
    </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>
