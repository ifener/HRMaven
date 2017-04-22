<%--
  Created by IntelliJ IDEA.
  User: it
  Date: 10/04/2017
  Time: 10:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <jsp:include page="../inc.jsp"></jsp:include>
</head>
<body>
<form name="myform" action="${ctx}/position/addPosition?flag=2" method="post">
    <table>
        <tr>
            <td>职位名称：</td>
            <td>
                <input type="text" name="positionName" />
            </td>
            <td>备注：</td>
            <td>
                <input type="text" name="remark" />
            </td>
        </tr>
        <tr>
            <td colspan="4" class="center">
                <input type="submit" value="Add"/>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
