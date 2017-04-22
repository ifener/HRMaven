<%--
  Created by IntelliJ IDEA.
  User: it
  Date: 10/04/2017
  Time: 11:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Title</title>
    <jsp:include page="../inc.jsp"></jsp:include>
</head>
<body>
    <form action="${ctx}/employee/employee" method="post">
        <table>
            <tr>
                <td>职位:</td>
                <td>
                    <s:select path="employee.position.id">
                        <option value="0">--请选择职位--</option>
                        <s:options items="${requestScope.positions}" itemLabel="positionName" itemValue="id"></s:options>
                    </s:select>
                </td>
                <td>姓名:</td>
                <td>
                    <!--<input type="text" name="employeeName" />-->
                    <s:input path="employee.employeeName" />
                </td>
                <td>身份证号码:</td>
                <td>
                    <input type="text" name="cardId" />
                </td>
            </tr>
            <tr>
            <td>部门:</td>
            <td>
                <s:select path="employee.department.id">
                    <option value="0">--请选择部门--</option>
                    <s:options items="${requestScope.departments}" itemLabel="departmentName" itemValue="id"></s:options>
                </s:select>
                <!--<c:forEach items="${requestScope.departments}" var="dept">
                        <option value="${dept.id}">${dept.departmentName}</option>
                    </c:forEach>-->
            </td>
            <td>手机:</td>
            <td>
                <input type="text" name="phone" />
            </td>
            <td>性别:</td>
            <td>
                <!--<select name="sex" style="width:143px;">
                    <option value="0">--请选择性别--</option>
                    <option value="1">男</option>
                    <option value="2">女</option>
                </select>-->
                <s:select path="employee.sex">
                    <s:option value="0">--请选择性别--</s:option>
                    <s:option value="1">男</s:option>
                    <s:option value="2">女</s:option>
                </s:select>
            </td>
            </tr>
            <tr>
                <td colspan="6">
                    <input type="submit" value="Search" />
                </td>
            </tr>
        </table>
    </form>
    <div>
        <c:if test="${requestScope.employees!=null}">
            <table>
                <tr>
                    <th>姓名</th>
                    <th>性别</th>
                    <th>手机</th>
                    <th>邮箱</th>
                    <th>学历</th>
                    <th>身份证</th>
                    <th>职位</th>
                    <th>部门</th>
                    <th>地址</th>
                    <th>建档日期</th>
                    <th>操作</th>
                </tr>
                <c:forEach items="${requestScope.employees}" var="e">
                    <tr>
                        <td>${e.employeeName}</td>
                        <td>
                            <c:choose>
                                <c:when test="${e.sex==1}">男</c:when>
                                <c:otherwise>女</c:otherwise>
                            </c:choose>

                        </td>
                        <td>${e.phone}</td>
                        <td>${e.email}</td>
                        <td>${e.education}</td>
                        <td>${e.cardId}</td>
                        <td>${e.position.positionName}</td>
                        <td>${e.department.departmentName}</td>
                        <td>${e.address}</td>
                        <td>
                            <fmt:formatDate value="${e.createDate}" pattern="yyyy年MM月dd日"></fmt:formatDate>
                        </td>
                        <td>
                            <a href="${ctx}/employee/updateEmployee?flag=1&id=${e.id}">修改</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
            <p:pager currentPageIndex="${requestScope.pageModel.currentPageIndex}"
                     pageSize="${requestScope.pageModel.pageSize}" recordCount="${requestScope.pageModel.recordCount}"
                     submitUrl="${ctx}/employee/employee?currentPageIndex={0}" style="page"></p:pager>
        </c:if>
    </div>
</body>
</html>
