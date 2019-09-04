<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Viewing All The Ads" />
    </jsp:include>
    <style><%@include file="/WEB-INF/partials/style.css"%></style>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp" />

<div class="container">
    <h1>Here Are all the ads!</h1>

    <form>
        <label for="search">search</label>
        <input id="search" class="form-control" type="text" onkeyup="searchAds()" placeholder="Enter Ad title">
        <button type="submit" class="submit">Search</button>
    </form>

    <div class="adList"></div>

</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script>

    function searchAds() {
        var input, filter;
        input = document.getElementById("search");
        filter = input.value.toUpperCase();
        var filteredAds = [];
        var html = '';

        <c:forEach var="ad" items="${ads}">
        td = "${ad.title}";
        if (td.toUpperCase().indexOf(filter) > -1){
            filteredAds.push("${ad.title}");
            html += "<div class='col-md-6 ad-div'><h2>${ad.title}dxfgh</h2><p>${ad.description}</p></div>";
        }

        </c:forEach>

        $('.adList').html(html);

    }
    var searchBar = document.querySelector('#search');
    $('#search').on( "click", searchAds());


</script>

</body>
</html>
