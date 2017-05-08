<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>Monsters</title>
        <%@include file='templates/script_css.jsp'%>
    </head>
    <body>
    <%@include file='templates/navigation.html'%>

    <div class="container monstersContainer">
        <h1>Monsters</h1>
        <h4>These are the monster that prowl the dungeons of Vagante. Click on one to discover its nature!</h4>
        <p>
            ${errorLog}
        </p>
        <div class="row">
            <table id="datatable" class="display" cellspacing="0" width="100%">
                <thead>
                    <tr>
                        <th>
                            <div class="tableCell">
                                Name
                            </div>
                        </th>
                        <th>
                            <div class="tableCell">
                                HP
                            </div>
                        </th>
                        <th id="descriptionColumn">
                            <div class="tableCell">
                                Description
                            </div>
                        </th>
                    </tr>
                </thead>
                <tbody>
                <c:forEach var="monster" items="${monsters}">
                    <tr>
                        <td>
                            <div class="tableCell">
                                <a href="monster?id=${monster.monsterId}" target="_blank">${monster.name}</a>
                            </div>
                        </td>
                        <td>
                            <div class="tableCell">
                                ${monster.hp}
                            </div>
                        </td>
                        <td class="descriptionCell" title="${monster.description}">
                            <div class="tableCell">
                                ${monster.shortDescription}
                            </div>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
    </body>
</html>
