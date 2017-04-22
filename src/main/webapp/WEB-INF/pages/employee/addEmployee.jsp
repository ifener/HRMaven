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
    <s:form modelAttribute="employee" action="${ctx}/employee/addEmployee?flag=2" method="post">
        <table>
            <tr>
                <td>部门:</td>
                <td>
                    <!--<select name="department.id">
                        <c:forEach items="${departments}" var="dept">
                            <option value="${dept.id}">${dept.departmentName}</option>
                        </c:forEach>
                    </select>-->

                    <s:select path="department.id">
                        <s:option value="0">请选择</s:option>
                        <s:options items="${departments}" itemLabel="departmentName" itemValue="id"></s:options>
                    </s:select>
                </td>
            </tr>
            <tr>
                <td>职位:</td>
                <td>
                    <select name="position.id">
                        <c:forEach items="${positions}" var="p">
                            <option value="${p.id}">${p.positionName}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <td>姓名:</td>
                <td>
                    <s:input path="employeeName"></s:input>
                    <s:errors path="employeeName"></s:errors>
                </td>
            </tr>
            <tr>
                <td>性别:</td>
                <td>
                    <select name="sex">
                        <option value="1">男</option>
                        <option value="2">女</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td>生日:</td>
                <td>
                    <s:input path="birthday"></s:input>
                    <s:errors path="birthday"></s:errors>
                </td>
            </tr>
            <tr>
                <td>卡号:</td>
                <td>
                    <s:input path="cardId"></s:input>
                    <s:errors path="cardId"></s:errors>
                </td>
            </tr>
            <tr>
                <td>地址:</td>
                <td>
                    <s:input path="address"></s:input>
                    <s:errors path="address"></s:errors>
                </td>
            </tr>
            <tr>
                <td>邮编:</td>
                <td>
                    <input type="text" name="postCode" />
                </td>
            </tr>
            <tr>
                <td>电话:</td>
                <td>
                    <input type="text" name="tel" />
                </td>
            </tr>
            <tr>
                <td>手机:</td>
                <td>
                    <s:input path="phone"></s:input>
                    <s:errors path="phone"></s:errors>
                </td>
            </tr>
            <tr>
                <td>QQ:</td>
                <td>
                    <input type="text" name="qq" />
                </td>
            </tr>
            <tr>
                <td>Email:</td>
                <td>
                    <s:input path="email"></s:input>
                    <s:errors path="email"></s:errors>
                </td>
            </tr>
            <tr>
                <td>党派:</td>
                <td>
                    <input type="text" name="party" />
                </td>
            </tr>
            <tr>
                <td>民族:</td>
                <td>
                    <input type="text" name="race" />
                </td>
            </tr>
            <tr>
                <td>学历:</td>
                <td>
                    <input type="text" name="education" />
                </td>
            </tr>
            <tr>
                <td>专业:</td>
                <td>
                    <input type="text" name="specialty" />
                </td>
            </tr>
            <tr>
                <td>爱好:</td>
                <td>
                    <input type="checkbox" value="FootBall" name="hobby" />FootBall
                    <input type="checkbox" value="BasketBall" name="hobby"/>BasketBall
                    <input type="checkbox" value="VolleyBall" name="hobby" />VolleyBall
                    <input type="checkbox" value="Tennis" name="hobby" />Tennis
                </td>
            </tr>
            <tr>
                <td>备注:</td>
                <td>
                    <input type="text" name="remark" />
                </td>
            </tr>
            <tr>
                <td colspan="2" class="center">
                    <input type="submit" value="Add" />
                </td>
            </tr>
        </table>
    </s:form>
</body>
</html>
