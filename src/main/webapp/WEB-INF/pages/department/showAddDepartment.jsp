<%--
  Created by IntelliJ IDEA.
  User: it
  Date: 10/04/2017
  Time: 5:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <jsp:include page="../inc.jsp"></jsp:include>
</head>
<body>
  <form action="${ctx}/department/addDepartment?flag=2" method="post">
      <table>
          <tr>
              <td>部门名称：</td>
              <td>
                  <input type="text" name="departmentName"/>
              </td>
              <td>备注：</td>
              <td>
                  <input type="text" name="remark"/>
              </td>
          </tr>
          <tr>
              <td class="center" colspan="2">
                  <input type="submit" value="Add" />
              </td>
          </tr>
      </table>
  </form>
</body>
</html>
