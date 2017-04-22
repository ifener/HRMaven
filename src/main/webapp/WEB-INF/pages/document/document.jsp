<%--
  Created by IntelliJ IDEA.
  User: it
  Date: 11/04/2017
  Time: 9:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Title</title>
    <jsp:include page="../inc.jsp"></jsp:include>
</head>
<body>
<form action="${ctx}/document/document" method="post">
    <table>
        <tr>
            <td>标题:</td>
            <td>
                <s:input path="document.title"></s:input>
            </td>
        </tr>
        <tr>
            <td colspan="2" class="center">
                <input type="submit" value="Search">
            </td>
        </tr>
    </table>
</form>
<div>
    <c:if test="${requestScope.documents!=null}">
        <table>
            <tr>
                <th>标题</th>
                <th>创建时间</th>
                <th>创建者</th>
                <th>描述</th>
                <th>操作</th>
                <th>下载</th>
            </tr>
            <c:forEach items="${requestScope.documents}" var="e">
                <tr>
                    <td>${e.title}</td>
                    <td>
                        <f:formatDate value="${e.createDate}" pattern="yyyy年MM月dd日"></f:formatDate>
                    </td>
                    <td>${e.user.userName}</td>
                    <td>${e.remark}</td>
                    <td>
                        <a href="${ctx}/document/updateDocument?flag=1&id=${e.id}">修改</a>
                    </td>
                    <td>
                        <a href="${ctx}/document/download?id=${e.id}">下载</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <p:pager currentPageIndex="${requestScope.pageModel.currentPageIndex}"
                 pageSize="${requestScope.pageModel.pageSize}" recordCount="${requestScope.pageModel.recordCount}"
                 submitUrl="${ctx}/notice/notice?currentPageIndex={0}" style="page"></p:pager>
    </c:if>
</div>
</body>
</html>
