<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <body>
        <h2>Monsters</h2>

        <table>
            <tr>
                <th>Name</th>
                <th>Hitpoints</th>
                <th>Description</th>
            </tr>
            <c:forEach var="monster" items="${monsters}">
                <tr>
                    <td>${monster.name}</td>
                    <td>${monster.hp}</td>
                    <td>${monster.description}</td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
