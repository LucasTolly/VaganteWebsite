<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Vagante Scholars</title>
    <%@include file='templates/script_css.jsp'%>
</head>
<body>
<%@include file='templates/navigation.html'%>
<div class="container">
    <div class="row">
        <div class="col-sm-12">
            <h2 id="websiteHeader" class="centeredTextAlign">Signup</h2>
        </div>
    </div>
    <br/>
    <form action="login" method="post">
        <div class="row">
            <div class="col-sm-3"></div>
            <div class="col-sm-3">
                <label for="username">Username</label>
            </div>
            <div class="col-sm-3">
                <input id="username" name="username" class="form-control" type="text"/>
            </div>
            <div class="col-sm-3"></div>
        </div>
        <br/>
        <div class="row">
            <div class="col-sm-3"></div>
            <div class="col-sm-3">
                <label for="password">Password</label>
            </div>
            <div class="col-sm-3">
                <input id="password" name="password" class="form-control" type="password"/>
            </div>
            <div class="col-sm-3"></div>
        </div>
        <br/>
        <div class="row">
            <div class="col-sm-12 centeredTextAlign">
                <div class="g-recaptcha" data-sitekey="6Le3nB0UAAAAACZUf8BgjV7xL7A0AW1wMxTVOYgu"></div>
            </div>
        </div>
        <br/>
        <div class="row">
            <div class="col-sm-12 centeredTextAlign">
                <button type="submit" class="btn btn-default">Submit</button>
            </div>
        </div>

    </form>

</div>
</body>
</html>
