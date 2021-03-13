<%--
  Created by IntelliJ IDEA.
  User: 14408
  Date: 2021/3/12
  Time: 16:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    Object error = request.getAttribute("error_info");
%>
</body>
<script>
    var error = '<%=error%>'
    if(confirm(error)){
        location.href="/login.html";
    }
</script>
</html>
