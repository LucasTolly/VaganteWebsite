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
            <h2 id="websiteHeader" class="centeredTextAlign">Login</h2>
        </div>
    </div>
    <br/>
    <div class="row">
        <div class="col-sm-12 centeredTextAlign">
            ${captchaResult}
        </div>
    </div>
    <br/>
    <form action="j_security_check" method="POST">
        <div class="row">
            <div class="col-sm-3"></div>
            <div class="col-sm-3">
                <label for="username">Username</label>
            </div>
            <div class="col-sm-3">
                <input id="username" class="form-control" type="TEXT" name="j_username"/>
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
                <input id="password" class="form-control" type="PASSWORD" name="j_password"/>
            </div>
            <div class="col-sm-3"></div>
        </div>
        <br/>
        <div class="row">
            <div class="col-sm-12 centeredTextAlign">
                <button type="submit" class="btn btn-default">Login</button>
            </div>
        </div>
    </form>

</div>
</body>
</html>
