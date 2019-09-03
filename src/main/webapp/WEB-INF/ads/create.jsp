<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Create a new Ad" />
    </jsp:include>
</head>
<body>
    <div class="container">
        <h1>Create a new Ad</h1>
        <form action="/ads/create" method="post">
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

            id="category_id" name="category_id" class="form-control"
            <input type="submit" class="btn btn-block btn-primary">
        </form>
    </div>
</body>
</html>
