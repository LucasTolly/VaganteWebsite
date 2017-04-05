<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>${monster.name}</title>
        <%@include file='templates/script_css.jsp'%>
    </head>
    <body>
        <%@include file='templates/navigation.html'%>
        <div class="container">
            <div class="row">
                <div class="col-sm-12">
                    <h1 class="centeredTextAlign">${monster.name}</h1>
                </div>
            </div>
            <div class="row">
                <div class="col-sm-2">
                    <div class="monsterDescription centeredTextAlign">
                        <h4>Hitpoints</h4>
                        <p>${monster.hp}</p>
                    </div>
                </div>
                <div class="col-sm-10">
                    <div class="monsterDescription centeredTextAlign">
                        <h4>Description</h4>
                        <p>${monster.description}</p>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-sm-12">
                    <div class="centeredTextAlign imageContainer">
                        <img src="images/${monster.name}.png"/>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
