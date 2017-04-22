<%--
  Created by IntelliJ IDEA.
  User: it
  Date: 11/04/2017
  Time: 10:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <jsp:include page="../inc.jsp"></jsp:include>
</head>
<body>

    <table>
        <tr>
            <td>标题:</td>
            <td>
                ${notice.title}
            </td>
        </tr>
        <tr>
            <td>内容:</td>
            <td>
                ${notice.content}
            </td>
        </tr>
    </table>
</body>
</html>
