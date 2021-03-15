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
    <title>WebChat | 聊天</title>
    <jsp:include page="include/commonfile.jsp"/>
    <%-- <script src="${ctx}/static/plugins/sockjs/sockjs.js"></script>--%>
</head>
<body>
<div class="am-cf admin-main">
    <!-- content start -->
    <div class="admin-content">
        <div class="" style="width: 80%;float:left;">
            <!-- 聊天区 -->
            <div class="am-scrollable-vertical" id="chat-view" style="height: 450px;">
                <ul class="am-comments-list am-comments-list-flip" id="chat">
                </ul>
            </div>
            <!-- 输入区 -->
            <div class="am-form-group am-form">
                <textarea class="" id="message" name="message" rows="5" placeholder="这里输入你想发送的信息..."></textarea>
            </div>
            <!-- 接收者 -->
            <div class="" style="float: left">
                <span id="sendToVal" hidden></span>
            </div>
            <!-- 按钮区 -->
            <div class="am-btn-group am-btn-group-xs" style="float:right;">
                <button class="am-btn am-btn-default" type="button" onclick="sendMessage()"><span
                        class="am-icon-commenting"></span> 发送
                </button>
            </div>
        </div>
        <!-- 列表区 -->
        <div class="am-panel am-panel-default" style="float:right;width: 20%;">
            <div class="am-panel-hd">
                <h3 class="am-panel-title">在线列表 [<span id="onlinenum"></span>]</h3>
            </div>
            <ul class="am-list am-list-static am-list-striped" id="list">
            </ul>
        </div>
    </div>
    <!-- content end -->
</div>
<script src="${pageContext.request.contextPath}/jQuery/jquery-2.2.3.min.js"/>
<script></script>
<script type="text/javascript">

    var webSocket = null;
    var url = window.location.host;
    if ('WebSocket' in window) {

        webSocket = new WebSocket("ws://" + url + "/chat/" + "1-2");
    } else {
        alert('当前浏览器 Not support websocket');
    }

    webSocket.onerror = function () {
        console.log("WebSocket连接发生错误");
    }
    webSocket.onopen = function () {
        console.log("WebSocket连接发生成功");
    }

    webSocket.onmessage = function (event) {
        $("#chat").html("");
        $(JSON.parse(event.data)).each(function (index,message) {
            showChat(message);
        })
    }

    webSocket.onclose = function () {
        console.log("WebSocket连接关闭");
    }

    webSocket.onbeforeunload = function () {
        closeWebSocket();
    }

    function closeWebSocket() {
        webSocket.close();
    }


    /**
     * 展示会话信息
     */
    function showChat(message) {

        //Message{
        // mId=1,
        // sendId=User{id=2, username='zhangsan', password='zhangsan123', uImage='zhangsan.jpg', loginNum=10, averageTime=2.0, vedioNum=4, commentNum=3, lastVedio='null', active=1, code=0},
        // acceptId=User{id=1, username='admin', password='admin123', uImage='admin.jpg', loginNum=15, averageTime=3.5, vedioNum=8, commentNum=11, lastVedio='null', active=1, code=0},
        // ifread=true,
        // mDesc='你好呀',
        // mTime=2021-03-13 22:02:08.0}

        var to = message.accept.id;   //获取接收人的id

        //var isSef = '${user.id}' == to ? "am-comment-flip" : "";   //如果是自己则显示在右边,他人信息显示在左边
        var isSef = '1' == to ?   "" : "am-comment-flip";   //如果是自己则显示在右边,他人信息显示在左边

        var sendHead="/images/head/" + message.send.uImage;
        var acceptHead="/images/head/" + message.accept.uImage;


        var html = "<li class=\"am-comment " + isSef + " am-comment-primary\"><a href=\"#link-to-user-home\"><img width=\"48\" height=\"48\" class=\"am-comment-avatar\" alt=\"\" src=\"" + sendHead + "\"></a><div class=\"am-comment-main\">\n" +
            "<header class=\"am-comment-hd\"><div class=\"am-comment-meta\">   <a class=\"am-comment-author\" href=\"#link-to-user\">" + message.send.username + "</a> 发表于<time> " + new Date(message.mTime).toLocaleString() + "</time> 发送给: " + message.accept.username + " </div></header><div class=\"am-comment-bd\"> <p>" + message.mDesc + "</p></div></div></li>";

        $("#chat").append(html);
        $("#message").val("");  //清空输入区
        var chat = $("#chat-view");
        chat.scrollTop(chat[0].scrollHeight);   //让聊天区始终滚动到最下面


    }

    /**
     * 发送信息给后台
     */
    function sendMessage(){
        var message = $("#message").val();

        if(message == null || message == ""){
            layer.msg("请不要惜字如金!", { offset: 0, shift: 6 });
            return;
        }

        webSocket.send(JSON.stringify({
            sendId : '${user.id}',
            acceptId: '2',
            ifRead: '1',
            mDesc:message,
            mTime: new Date().getTime()
        }));
    }

</script>

</body>
</html>
