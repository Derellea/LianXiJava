package com.derellea.socket;
 
 import com.derellea.domain.OnlineUser;
 import com.derellea.utils.json.JsonConfigUtils;
 import net.sf.json.JSONArray;
 import net.sf.json.JSONObject;
 import org.apache.commons.collections.CollectionUtils;
 import org.apache.log4j.Logger;
 
 import javax.websocket.Session;
 import java.io.IOException;
 import java.util.ArrayList;
 import java.util.Collection;
 import java.util.List;
 
 /**
  * @author ccq
  * @Description 消息类
  * @date 2017/12/16 19:08
  */
 public class Chat {
 
     private static Logger logger = Logger.getLogger(Chat.class);
 
     /**
      * 消息类型
      */
     public static String MESSAGE = "message";    //消息
 
     /**
      * 组装信息返回给前台
      * @param message  交互信息
      * @param type     信息类型
      * @param userList 在线列表
      * @return
      *
      * "massage" : {
      *              "from" : "xxx",
      *              "to" : "xxx",
      *              "content" : "xxx",
      *              "time" : "xxxx.xx.xx"
      *          },
      * "type" : {notice|message},
      * "list" : {[xx],[xx],[xx]}
      */
     public static String getMessage(String message,String type,Collection<OnlineUser> userList){
         JSONObject msg = new JSONObject();
         msg.put("message",message);
         msg.put("type", type);
 
         if(CollectionUtils.isNotEmpty(userList)){
             List<String> propertys = new ArrayList<String>();
             propertys.add("session");
             JSONArray userListArray = JSONArray.fromObject(userList,JsonConfigUtils.getJsonConfig(propertys));
             msg.put("list", userListArray);
         }
         return msg.toString();
     }
 
     /**
      * 消息内容
      * @param fromUser
      * @param to
      * @param content
      * @param time
      * @return
      *          {
      *              "from" : "xxx",
      *              "to" : "xxx",
      *              "content" : "xxx",
      *              "time" : "xxxx.xx.xx"
      *          }
      */
     public static String getContent(OnlineUser fromUser,String to,String content,String time){
         JSONObject contentJson = new JSONObject();
 
           //转化为json串时去掉session，用户session不能被序列化
         List<String> propertys = new ArrayList<String>();
         propertys.add("session");
         contentJson.put("from",JSONObject.fromObject(fromUser, JsonConfigUtils.getJsonConfig(propertys)));
 
         contentJson.put("to",to);
         contentJson.put("content",content);
         contentJson.put("time",time);
         return contentJson.toString();
     }
 
 
     /**
      * 对特定用户发送消息
      * @param message
      * @param onlineUser
      */
     public static void singleSend(String message, OnlineUser onlineUser){
         logger.info("[singleSend] message = " + message + ", toUser = " + onlineUser.getNickname());
         try {
             onlineUser.getSession().getBasicRemote().sendText(message);
         } catch (IOException e) {
             e.printStackTrace();
             logger.info("消息发送失败！" + e.getMessage());
         }
     }
 }
