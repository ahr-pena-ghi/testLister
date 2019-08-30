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
<p><c:out value="${sessionScope.username}"/></p>
<p><c:out value="${ad.title}"/></p>
<p><c:out value="${ad.description}"/></p>

</body>
</html>
