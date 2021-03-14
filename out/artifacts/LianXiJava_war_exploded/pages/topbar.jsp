<%--
  Created by IntelliJ IDEA.
  User: 14408
  Date: 2021/3/12
  Time: 23:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light">
    <div class="full">
        <button type="button" id="sidebarCollapse" class="sidebar_toggle"><i class="fa fa-bars"></i></button>
        <div class="logo_section">
            <a href="index.html"><img class="img-responsive" src="${pageContext.request.contextPath}/images/logo/logo.png" alt="#" /></a>
        </div>
        <div class="right_topbar">
            <div class="icon_info">
                <ul>
                    <!--                                 <li><a href="#"><i class="fa fa-bell-o"></i><span class="badge">2</span></a></li>-->
                    <li><a href="#"><i class="fa fa-envelope-o"></i><span class="badge" id="count"></span></a></li>
                    <li><a href="#"><i class="fa fa-question-circle"></i></a></li>

                </ul>
                <ul class="user_profile_dd">
                    <li>
                        <a class="dropdown-toggle" data-toggle="dropdown" id="user"></a>
                        <div class="dropdown-menu">
                            <!--                                       <a class="dropdown-item" href="profile.html">My Profile</a>-->
                            <!--                                       <a class="dropdown-item" href="settings.html">Settings</a>-->
                            <a class="dropdown-item" href="help.html">Help</a>
                            <a class="dropdown-item" href="javascript:logOut()"><span>Log Out</span> <i class="fa fa-sign-out"></i></a>
                        </div>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</nav>


<!-- custom js -->
<script src="${pageContext.request.contextPath}/js/custom.js"></script>
<script src="${pageContext.request.contextPath}/js/chart_custom_style.js"></script>

<script src="${pageContext.request.contextPath}//jQuery/jquery-2.2.3.min.js"></script>
<script></script>

<!--加载头像和用户名-->
<script>
    $.getJSON("/user/info", function (user) {

        var uImage='';
        if(user.uImage==null){
            uImage='<img class="img-responsive" src="${pageContext.request.contextPath}/images/layout_img/user_img.jpg" alt="#" />';
        }else{
            uImage='<img class="img-responsive" src="'+'/images/head/'+user.uImage+'" alt="#" />';
        }

        var html =uImage+'<span class="name_user">'+user.username+'</span>';

        $("#user").html(html);

    });
</script>

<script>
    function logOut(){
        location.href="${pageContext.request.contextPath}/user/logOut";
    }
</script>
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
        $("#count").text(event.data);
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
</body>
</html>
