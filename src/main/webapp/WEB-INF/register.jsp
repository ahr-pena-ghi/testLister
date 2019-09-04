<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="partials/head.jsp">
        <jsp:param name="title" value="Register For Our Site!" />
    </jsp:include>
    <style><%@include file="/WEB-INF/partials/style.css"%></style>
</head>
<body>
    <jsp:include page="partials/navbar.jsp" />
    <div class="container">
        <h1>Please fill in your information.</h1>
        <h5 class="error-hint" style="${hintVisible}">Be sure to fill out all forms, and that your password matches your password confirmation.</h5>
        <form action="/register" method="post">
            <div class="form-group">
                <label for="username" class="${usernameEmptyHeader}">Username</label>
                <input id="username" name="username" class="form-control ${usernameEmpty}" type="text" value="${usernameValue}">
            </div>
            <div class="form-group">
                <label for="phone_number" class="${phoneNumberEmptyHeader}">Phone Number</label>
                <input id="phone_number" name="phone_number" class="form-control ${phoneNumberEmpty}" type="text" value="${phoneNumberValue}">
            </div>
            <div class="form-group">
                <label for="email" class="${emailEmptyHeader}">Email</label>
                <input id="email" name="email" class="form-control ${emailEmpty}" type="text" value="${emailValue}">
            </div>
            <div class="form-group">
                <label for="password" class="${passwordEmptyHeader}">Password</label>
                <input id="password" name="password" class="form-control ${passwordEmpty}" type="password">
            </div>
            <div class="form-group">
                <label for="confirm_password" class="${conPasswordEmptyHeader}">Confirm Password</label>
                <input id="confirm_password" name="confirm_password" class="form-control ${conPasswordEmpty}" type="password">
            </div>
            <div class="form-group">
                <label for="city" class="${cityEmptyHeader}">City</label>
                <input id="city" name="city" class="form-control ${cityEmpty}" type="text" value="${cityValue}">
            </div>
            <div class="form-group">
                <label for="state" class="${stateEmptyHeader}">State</label>
                <input id="state" name="state" class="form-control ${stateEmpty}" type="text" value="${stateValue}">
            </div>
            <input type="submit" class="btn btn-primary btn-block">
        </form>
    </div>
</body>
</html>
