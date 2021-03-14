package com.derellea.socket;

import com.derellea.domain.OnlineUser;
import com.derellea.domain.User;
import net.sf.json.JSONObject;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpSession;
import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


@ServerEndpoint(value = "/chatServer/{userid}")
public class ChatSever {

    private static Logger logger = Logger.getLogger(ChatSever.class);

    //Map<用户id，用户信息>
    private static Map<String, OnlineUser> onlineUserMap = new ConcurrentHashMap<String, OnlineUser>();//在线用户

    /**
     * 连接成功调用的方法
     */
    @OnOpen

    public void onOpen(@PathParam("userid") String userid, Session session, EndpointConfig config) {

        logger.info("[ChatServer] connection : userid = " + userid + " , sessionId = " + session.getId());

        //获取当前用户的session
        HttpSession httpSession = (HttpSession) config.getUserProperties().get(HttpSession.class.getName());
        User user = (User) httpSession.getAttribute("user");
        //获得当前用户信息

                //将当前用户存到在线用户列表中
        OnlineUser onlineUser = new OnlineUser(Integer.toString(user.getId()), user.getUsername(), session);
        onlineUserMap.put(Integer.toString(user.getId()), onlineUser);

    }

    /**
     * 连接关闭方法
     */
    @OnClose
    public void onClose(@PathParam("userid") String userid, Session session, CloseReason closeReason) {

        logger.info("[ChatServer] close : userid = " + userid + " , sessionId = " + session.getId() +
                " , closeCode = " + closeReason.getCloseCode().getCode() + " , closeReason = " + closeReason.getReasonPhrase());


        //移除用户信息
        onlineUserMap.remove(userid);


    }

    /**
     * 接收客户端的message，指定接收人发送
     *
     * @param data 客户端发来的消息
     */
    @OnMessage
    public void onMessage(@PathParam("userid") String userid, String data) {
        logger.info("[ChatServer] onMessage : userid = " + userid + " , data = " + data);

        JSONObject messageJson = JSONObject.fromObject(data);
        JSONObject message = messageJson.optJSONObject("message");
        String to = message.optString("to");
        String from = message.optString("from");
        //将用户id转换为名称
                to = this.userIdCastNickName(to);

        OnlineUser fromUser = onlineUserMap.get(from);
//        String sendMessage = Chat.getContent(fromUser, to, message.optString("content"), message.optString("time"));
//        String returnData = Chat.getMessage(sendMessage, messageJson.optString("type"), null);


//        Chat.singleSend(returnData.toString(), onlineUserMap.get(from));
        //发送给自己
        String[] useridList = message.optString("to").split(",");
        for (String id : useridList) {
            if (!id.equals(from)) {
//                Chat.singleSend(returnData.toString(), onlineUserMap.get(id));
                //分别发送给指定的用户
            }
        }

    }

    /**
     * 发生错误
     *
     * @param throwable
     */
    @OnError
    public void onError(@PathParam("userid") String userid, Session session, Throwable throwable) {
        logger.info("[ChatServer] close : userid = " + userid + " , sessionId = " + session.getId() + " , throwable = " + throwable.getMessage());
    }


    /**
     * 将用户id转换为名称
     *
     * @param userIds
     * @return
     */
    private String userIdCastNickName(String userIds) {
        String niceNames = "";
        if (userIds != null && !userIds.equals("")) {
            String[] useridList = userIds.split(",");
            String toName = "";
            for (String id : useridList) {
                toName = toName + onlineUserMap.get(id).getNickname() + ",";
            }
            niceNames = toName.substring(0, toName.length() - 1);
        }
        return niceNames;
    }
}
