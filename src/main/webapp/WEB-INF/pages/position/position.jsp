<%--
  Created by IntelliJ IDEA.
  User: it
  Date: 10/04/2017
  Time: 9:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <jsp:include page="../inc.jsp"></jsp:include>
</head>
<body>
<form name="myform" method="post" action="${ctx}/position/position">
    <table>
        <tr>
            <td>名称：</td>
            <td>
                <input type="text" name="positionName" value="${position.positionName}" />
            </td>
            <td>描述：</td>
            <td>
                <input type="text" name="remark" value="${position.remark}" />
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
    <c:if test="${requestScope.positions!=null}">
        <table>
            <tr>
                <th>名称</th>
                <th>备注</th>
                <th>操作</th>
            </tr>
            <c:forEach items="${requestScope.positions}" var="pos">
                <tr>
                    <td>${pos.positionName}</td>
                    <td>${pos.remark}</td>
                    <td>
                        <a href="${ctx}/position/updatePosition?flag=1&id=${pos.id}">修改</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <p:pager currentPageIndex="${requestScope.pageModel.currentPageIndex}"
                 pageSize="${requestScope.pageModel.pageSize}" recordCount="${requestScope.pageModel.recordCount}"
                 submitUrl="${ctx}/position/position?currentPageIndex={0}&positionName=${position.positionName}&remark=${position.remark}" style="page"></p:pager>
    </c:if>
</div>
</body>
</html>
