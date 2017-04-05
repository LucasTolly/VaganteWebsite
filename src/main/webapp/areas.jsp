<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Areas</title>
    <%@include file='templates/script_css.jsp'%>
</head>
<body>
    <%@include file='templates/navigation.html'%>
    <div class="container">
        <h1>Areas</h1>
        <h4>Discover the environments of Vagante.</h4>
        <div class="row">
            <table id="datatable" class="display" cellspacing="0" width="100%">
                <thead>
                <tr>
                    <th>
                        <div class="tableCell">
                            Name
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
                <c:forEach var="area" items="${areas}">
                    <tr>
                        <td>
                            <div class="tableCell">
                                <a href="/area&id=${area.areaId}" target="_blank">${area.name}</a>
                            </div>
                        </td>
                        <td title="${area.description}">
                            <div class="tableCell">
                                    ${area.shortDescription}
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
