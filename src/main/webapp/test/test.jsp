<%--
  Created by IntelliJ IDEA.
  User: 14408
  Date: 2021/3/12
  Time: 21:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--<a onClick="x_admin_show('公告','<%=basePath%>announce/turnToNewAnnounce')">--%>
<%--    <span id="count">公告</span><span id="num" style="color:#ff0000"></span>--%>
<%--</a>--%>
<span id="num"></span>
</body>
<script src="/jQuery/jquery-2.2.3.min.js"/>
<script></script>
<script type="text/javascript">

    var webSocket=null;
    var url=window.location.host;
    if('WebSocket' in window){

        webSocket=new WebSocket("ws://"+url+"/webSocket/"+${user.id});
    }else{
        alert('当前浏览器 Not support websocket');
    }

    webSocket.onerror=function (){
        console.log("WebSocket连接发生错误");
    }
    webSocket.onopen=function () {
        console.log("WebSocket连接发生成功");
    }

    webSocket.onmessage=function (event){
        $("#num").text(event.data);
    }

    webSocket.onclose=function () {
        console.log("WebSocket连接关闭");
    }

    webSocket.onbeforeunload=function () {
        closeWebSocket();
    }
    function closeWebSocket(){
        webSocket.close();
    }

</script>
</html>
