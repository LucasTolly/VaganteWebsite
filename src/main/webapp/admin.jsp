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
            <h1 id="websiteHeader" class="centeredTextAlign">Admin Page</h1>
        </div>
    </div>
    <div class="row">
        <div class="col-sm-6 centeredTextAlign">
            <a href="monsters"><h1>Beastiary</h1></a>
        </div>
        <div class="col-sm-6 centeredTextAlign">
            <a href="areas"><h1>Road Map</h1></a>
        </div>
    </div>
    <div class="row">
        <div class="col-sm-12">
            <p>To logout, click <a href="logout">here.</a></p>
        </div>
    </div>
</div>
</body>
</html>
