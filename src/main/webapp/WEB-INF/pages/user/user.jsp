<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: it
  Date: 09/04/2017
  Time: 2:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <jsp:include page="../inc.jsp"></jsp:include>
</head>
<body>
<form name="myform" method="post" action="${ctx}/user/user">
    <table>
        <tr>
            <td>用户名：</td>
            <td>
                <input type="text" name="userName" value="${user.userName}" />
            </td>
            <td>用户状态：</td>
            <td>
                <input type="text" name="userStatus" value="${user.userStatus}" />
            </td>
        </tr>
        <tr>
            <td colspan="4" style="text-align: center">
                <input type="submit" value="Search" />
            </td>
        </tr>
    </table>
</form>
<div>
    <c:if test="${requestScope.users!=null}">
        <table>
            <tr>
                <th>登录名</th>
                <th>密码</th>
                <th>用户名</th>
                <th>状态</th>
                <th>注册时间</th>
                <th>操作</th>
            </tr>
            <c:forEach items="${requestScope.users}" var="user">
                <tr>
                    <td>${user.loginName}</td>
                    <td>${user.password}</td>
                    <td>${user.userName}</td>
                    <td>${user.userStatus}</td>
                    <td>
                        <f:formatDate value="${user.createDate}" pattern="yyyy-MM-dd"/>
                    </td>
                    <td>
                        <a href="${ctx}/user/updateUser?flag=1&id=${user.id}">修改</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <p:pager currentPageIndex="${requestScope.pageModel.currentPageIndex}"
                 pageSize="${requestScope.pageModel.pageSize}" recordCount="${requestScope.pageModel.recordCount}"
                 submitUrl="${ctx}/user/user?currentPageIndex={0}&userName=${user.userName}&userStatus=${user.userStatus}" style="page"></p:pager>
    </c:if>
</div>
</body>
</html>
