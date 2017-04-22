<%--
  Created by IntelliJ IDEA.
  User: it
  Date: 11/04/2017
  Time: 10:03 PM
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
<s:form modelAttribute="document" action="${ctx}/document/updateDocument?flag=2" method="post" enctype="multipart/form-data">
    <table>
        <tr>
            <td>标题:</td>
            <td>
                <s:input path="title"></s:input>
            </td>
        </tr>
        <tr>
            <td>备注:</td>
            <td>
                <s:textarea path="remark" rows="10" cols="50"></s:textarea>
            </td>
        </tr>
        <tr>
            <td>文件:</td>
            <td>
                <input type="file" name="file" />
                <s:hidden path="fileName"></s:hidden>
                <s:hidden path="id"></s:hidden>
                <a href="${ctx}/document/download?id=${document.id}">下载</a>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="Add" />
            </td>
        </tr>
    </table>
</s:form>
</body>
</html>
