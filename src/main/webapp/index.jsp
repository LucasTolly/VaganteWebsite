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
            <h1 id="websiteHeader" class="centeredTextAlign">Vagante Scholars</h1>
            <h2 class="centeredTextAlign">Beastiary and Road Map</h2>
            <p>
                Vagante Scholars is a fan-made information web site for the game Vagante, developed by Nuke Nine.
                All content on this web site belongs to Nuke Nine, and was built for educational purposes with no
                monetary incentive.
            </p>
            <p>
                Signup <a href="signup">here.</a>
            </p>
            <p>Profile page can be found <a href="profile.jsp">here</a> (requires login).</p>
        </div>
    </div>
    <div class="row">
        <div class="col-sm-6 centeredTextAlign">
            <button class="btn btn-primary"><a href="monsters" class="buttonLink"><h1>Beastiary</h1></a></button>
            <br/>
        </div>
        <div class="col-sm-6 centeredTextAlign">
            <button class="btn btn-primary"><a href="areas" class="buttonLink"><h1>Road Map</h1></a></button>
            <br/>
        </div>
    </div>
</div>
</body>
</html>
