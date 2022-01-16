<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>展示账户数据列表</h1>
    <table border="1">
        <tr>
            <th>姓名</th>
            <th>邮箱</th>
            <th>性别</th>
        </tr>
        <c:forEach items="${employeeList}" var="employee">
            <tr>
                <td>${employee.lastName}</td>
                <td>${employee.email}</td>
                <td>${employee.gender}</td>
            </tr>
        </c:forEach>

    </table>
</body>
</html>
