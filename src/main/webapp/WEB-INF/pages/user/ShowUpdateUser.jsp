<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: it
  Date: 09/04/2017
  Time: 2:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<s:form modelAttribute="user" method="post" action="${ctx}/user/updateUser?flag=2">
    <s:hidden path="id"></s:hidden>
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
                <input type="submit" value="Modify" />
            </td>
        </tr>
    </table>
</s:form>
</body>
</html>
