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
                <div class="col-sm-8">
                    <h1>${monster.name}</h1>
                    <h2>Description</h2>
                    <p>
                        ${monster.description}
                    </p>
                    <h2>Area(s)</h2>
                    <p>
                        This monster appears in the following area(s):
                        <ul>
                            <c:forEach var="area" items="${monster.areas}">
                                <li><a href="area?id=${area.areaId}">${area.name}</a></li>
                            </c:forEach>
                        </ul>
                    </p>
                    <c:if test="${monster.hasParentMonster}">
                        <h2>Summoners</h2>
                        <p>
                            This monster is summoned by
                            <a href="monster?id=${monster.parentMonster.monsterId}">${monster.parentMonster.name}</a>.
                        </p>
                    </c:if>
                </div>
                <div class="col-sm-4 centeredTextAlign">
                    <img src="images/${monster.name}.png"/>
                    <p>Hitpoints: ${monster.hp}</p>
                </div>
            </div>
            <c:if test="${monster.hasChildMonsters}">
                <div class="row">
                    <div class="col-sm-12">
                        <h2>Summons</h2>
                        <p>
                            This monster summons the following monster(s):
                        </p>
                        <ul>
                            <c:forEach var="childMonster" items="${monster.childMonsters}">
                                <li><a href="monster?id=${childMonster.monsterId}">${childMonster.name}</a></li>
                            </c:forEach>
                        </table>
                        </ul>
                    </div>
                </div>
            </c:if>
        </div>
    </body>
</html>
