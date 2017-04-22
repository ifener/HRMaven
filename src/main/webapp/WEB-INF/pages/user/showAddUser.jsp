<%--
  Created by IntelliJ IDEA.
  User: it
  Date: 09/04/2017
  Time: 2:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Add User</title>
    <jsp:include page="../inc.jsp"></jsp:include>
</head>
<body>
<s:form modelAttribute="user" method="post" action="${ctx}/user/addUser?flag=2">
    <table>
        <tr>
            <td>用户名:</td>
            <td>
                <s:input path="loginName" />
            </td>
        </tr>
        <tr>
            <td>密码:</td>
            <td>
                <s:input path="password" />
            </td>
        </tr>
        <tr>
            <td>状态:</td>
            <td>
                <s:input path="userStatus" />
            </td>
        </tr>
        <tr>
            <td>姓名:</td>
            <td>
                <s:input path="userName" />
            </td>
        </tr>
        <tr>
            <td></td>
            <td>
                <input type="submit" value="Add" />
            </td>
        </tr>
    </table>
</s:form>
</body>
</html>
