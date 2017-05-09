<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>${area.name}</title>
        <%@include file='templates/script_css.jsp'%>
    </head>
    <body>
        <%@include file='templates/navigation.html'%>
        <div class="container">
            <div class="row">
                <div class="col-sm-12">
                    <h1>${area.name}</h1>
                    <p>${area.description}</p>
                    <p>The following monsters can be found in this area:</p>
                </div>
            </div>

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
                    <c:forEach var="monster" items="${area.monsters}">
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
