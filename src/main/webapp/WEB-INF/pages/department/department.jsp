<%--
  Created by IntelliJ IDEA.
  User: it
  Date: 10/04/2017
  Time: 4:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <jsp:include page="../inc.jsp"></jsp:include>
</head>
<body>
<body>
<form name="myform" method="post" action="${ctx}/department/department">
    <table>
        <tr>
            <td>名称：</td>
            <td>
                <input type="text" name="departmentName" value="${department.departmentName}" />
            </td>
            <td>描述：</td>
            <td>
                <input type="text" name="remark" value="${department.remark}" />
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
    <c:if test="${requestScope.departments!=null}">
        <table>
            <tr>
                <th>名称</th>
                <th>备注</th>
                <th>操作</th>
            </tr>
            <c:forEach items="${requestScope.departments}" var="dept">
                <tr>
                    <td>${dept.departmentName}</td>
                    <td>${dept.remark}</td>
                    <td>
                        <a href="${ctx}/department/updateDepartment?flag=1&id=${dept.id}">修改</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <p:pager currentPageIndex="${requestScope.pageModel.currentPageIndex}"
                 pageSize="${requestScope.pageModel.pageSize}" recordCount="${requestScope.pageModel.recordCount}"
                 submitUrl="${ctx}/department/department?currentPageIndex={0}&departmentName=${department.departmentName}&remark=${department.remark}" style="page"></p:pager>
    </c:if>
</div>
</body>
</body>
</html>
