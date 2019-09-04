<%--
  Created by IntelliJ IDEA.
  User: victorpena
  Date: 2019-09-04
  Time: 09:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Profile</title>
</head>
<body>
<h1>Edit Profile</h1>
<form action="/profile/edit" method="POST">

<div class="form-group">
    <label for="username">Username</label>
    <input id="username" name="username" class="form-control" type="text" value="${user.username}">
</div>
<div class="form-group">
    <label for="email">Description</label>
    <textarea id="email" name="email" class="form-control">${user.email}</textarea>
</div>
<div class="form-group">
    <label for="phone_number">Phone Number</label>
    <textarea id="phone_number" name="phone_number" class="form-control"></textarea>
</div>
<div class="form-group">
    <label for="old_password">Confirm Old password </label>
    <textarea id="old_password" name="old_password" class="form-control" type="password"></textarea>
</div>
<div class="form-group">
    <label for="password">New Password</label>
    <input id="password" name="password" class="form-control" type="password">
</div>
<div class="form-group">
    <label for="confirm_password">Confirm Password</label>
    <input id="confirm_password" name="confirm_password" class="form-control" type="password">
</div>
    <div class="form-group">
        <label for="city">City</label>
        <input id="city" name="city" class="form-control" type="text">
    </div>
    <div class="form-group">
        <label for="state">State</label>
        <input id="state" name="state" class="form-control" type="text">
    </div>
<button id="edit" name="edit"  type="submit" value="${user.id}">Edit</button>
</form>





</body>
</html>
