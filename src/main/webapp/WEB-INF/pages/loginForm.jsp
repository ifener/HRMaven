<%--
  Created by IntelliJ IDEA.
  User: it
  Date: 07/04/2017
  Time: 3:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="${ctx}/static/js/jquery-3.2.0.min.js"></script>
    <script type="text/javascript">
        $(function () {
            $("#loginBtn").click(function () {
                $.ajax({
                    type:"post",
                    data:$("form").serialize(),
                    dataType:"json",
                    url:"${ctx}/ajaxLogin",
                    success:function (data) {
                        if(data && data.id && data.id>0){
                            window.location.href="${ctx}/main";
                        } else {
                            alert("用户名或者密码不正确")
                        }
                    }
                })
            });
        });
    </script>
</head>
<body>
   <form action="${pageContext.request.contextPath}/login" method="post">
       <table>
           <tr>
               <td>用户名：</td>
               <td>
                   <input type="text" name="loginName" />
               </td>
           </tr>
           <tr>
               <td>密码：</td>
               <td>
                   <input type="password" name="password" />
               </td>
           </tr>
           <tr>
               <td colspan="2">
                   <input type="submit" value="Login" />
                   <c:if test="${msg!=null}">
                       ${msg}
                   </c:if>
               </td>
           </tr>
       </table>
   </form>
</body>
</html>
