<%--
  Created by IntelliJ IDEA.
  User: it
  Date: 11/04/2017
  Time: 3:02 PM
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
<s:form modelAttribute="employee" action="${ctx}/employee/updateEmployee?flag=2" method="post">
    <s:hidden path="id"></s:hidden>
    <table>
        <tr>
            <td>部门:</td>
            <td>
                <s:select path="department.id" items="${departments}" itemLabel="departmentName" itemValue="id"></s:select>
            </td>
        </tr>
        <tr>
            <td>职位:</td>
            <td>
                <s:select path="position.id" items="${positions}" itemLabel="positionName" itemValue="id"></s:select>
            </td>
        </tr>
        <tr>
            <td>姓名:</td>
            <td>
                <s:input path="employeeName"></s:input>
            </td>
        </tr>
        <tr>
            <td>性别:</td>
            <td>
                <select name="sex">
                    <option value="1" <c:if test="${employee.sex==1}">selected</c:if>>男</option>
                    <option value="2" <c:if test="${employee.sex==2}">selected</c:if>>女</option>
                </select>
            </td>
        </tr>
        <tr>
            <td>生日:</td>
            <td>
                <s:input path="birthday"></s:input>
            </td>
        </tr>
        <tr>
            <td>卡号:</td>
            <td>
                <s:input path="cardId"></s:input>
            </td>
        </tr>
        <tr>
            <td>地址:</td>
            <td>
                <s:input path="address"></s:input>
            </td>
        </tr>
        <tr>
            <td>邮编:</td>
            <td>
                <s:input path="postCode"></s:input>
            </td>
        </tr>
        <tr>
            <td>电话:</td>
            <td>
                <s:input path="tel"></s:input>
            </td>
        </tr>
        <tr>
            <td>手机:</td>
            <td>
                <s:input path="phone"></s:input>
            </td>
        </tr>
        <tr>
            <td>QQ:</td>
            <td>
                <s:input path="qq"></s:input>
            </td>
        </tr>
        <tr>
            <td>Email:</td>
            <td>
                <s:input path="email"></s:input>
            </td>
        </tr>
        <tr>
            <td>党派:</td>
            <td>
                <s:input path="party"></s:input>
            </td>
        </tr>
        <tr>
            <td>民族:</td>
            <td>
                <s:input path="race"></s:input>
            </td>
        </tr>
        <tr>
            <td>学历:</td>
            <td>
                <s:input path="education"></s:input>
            </td>
        </tr>
        <tr>
            <td>专业:</td>
            <td>
                <s:input path="specialty"></s:input>
            </td>
        </tr>
        <tr>
            <td>爱好:</td>
            <td>
                <input type="checkbox" value="FootBall" name="hobby"

                />
                FootBall
                <input type="checkbox" value="BasketBall" name="hobby"/>BasketBall
                <input type="checkbox" value="VolleyBall" name="hobby" />VolleyBall
                <input type="checkbox" value="Tennis" name="hobby" />Tennis
            </td>
        </tr>
        <tr>
            <td>备注:</td>
            <td>
                <s:input path="remark"></s:input>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="Update" />
            </td>
        </tr>
    </table>
</s:form>
</body>
</html>
