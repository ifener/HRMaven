<%--
  Created by IntelliJ IDEA.
  User: it
  Date: 09/04/2017
  Time: 4:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <jsp:include page="inc.jsp"></jsp:include>
    <style type="text/css">
        .left{
            width:199px;
            height: 100%;
            float:left;
            border-right:1px solid #ccc;
            position: absolute;
            left: 0;
            top: 0;
            z-index: 2;
        }
        .left .title{
            background: #ececec;
            text-align: center;
        }
        .right{
            width: 100%;
            height:100%;
            float: right;
            position: absolute;
            right: 0;
            top:0;
        }
        .container{
            margin-left: 200px;
            height:100%;
        }
        iframe{
            width: 100%;
            height:100%;
        }
    </style>
</head>
<body>
    <div class="left">
        <dl>
            <dt class="title">用户管理</dt>
            <dd>
                <p><a href="${ctx}/user/user" target="content">用户查询</a></p>
                <p><a href="${ctx}/user/addUser?flag=1" target="content">用户添加</a></p>
            </dd>
        </dl>
        <dl>
            <dt class="title">部门管理</dt>
            <dd>
                <p><a href="${ctx}/department/department" target="content">部门查询</a></p>
                <p><a href="${ctx}/department/addDepartment?flag=1" target="content">部门添加</a></p>
            </dd>
        </dl>
        <dl>
            <dt class="title">职位管理</dt>
            <dd>
                <p><a href="${ctx}/position/position" target="content">职位查询</a></p>
                <p><a href="${ctx}/position/addPosition?flag=1" target="content">职位添加</a></p>
            </dd>
        </dl>
        <dl>
            <dt class="title">员工管理</dt>
            <dd>
                <p><a href="${ctx}/employee/employee" target="content">员工查询</a></p>
                <p><a href="${ctx}/employee/toAddEmployee" target="content">员工添加</a></p>
            </dd>
        </dl>
        <dl>
            <dt class="title">公告管理</dt>
            <dd>
                <p><a href="${ctx}/notice/notice" target="content">公告查询</a></p>
                <p><a href="${ctx}/notice/toAddNotice" target="content">公告添加</a></p>
            </dd>
        </dl>
        <dl>
            <dt class="title">文档管理</dt>
            <dd>
                <p><a href="${ctx}/document/document" target="content">文档查询</a></p>
                <p><a href="${ctx}/document/addDocument?flag=1" target="content">文档添加</a></p>
            </dd>
        </dl>
    </div>
    <div class="right">
        <div class="container">
            <iframe name="content" id="content" frameborder="none"></iframe>
        </div>
    </div>
</body>
</html>
