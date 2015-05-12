<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home Page</title>
</head>
<body>

<p>
    Here is the list of users:
</p>
<table border="1">
    <th>Name</th>
    <th>Email</th>
    <c:forEach var="user" items="${userList}">
        <tr>
            <td><c:out value="${user.name}"/></td>
            <td><c:out value="${user.email}"/></td>
        </tr>

    </c:forEach>
</table>

</body>
</html>
