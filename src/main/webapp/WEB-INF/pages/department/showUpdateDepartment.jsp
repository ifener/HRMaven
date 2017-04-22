<%--
  Created by IntelliJ IDEA.
  User: it
  Date: 10/04/2017
  Time: 5:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
    <jsp:include page="../inc.jsp"></jsp:include>
</head>
<body>
<s:form modelAttribute="department" method="post" action="${ctx}/department/updateDepartment?flag=2">
    <input type="hidden" name="id" value="${department.id}">
    <table>
        <tr>
            <td>部门名称：</td>
            <td>
                <s:input path="departmentName"></s:input>
            </td>
            <td>备注：</td>
            <td>
                <s:input path="remark"></s:input>
            </td>
        </tr>
        <tr>
            <td colspan="2" class="center">
                <input type="submit" value="Update" />
            </td>
        </tr>
    </table>
</s:form>
</body>
</html>
