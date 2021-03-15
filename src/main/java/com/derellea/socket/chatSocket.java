package com.derellea.socket;


import com.derellea.domain.Message;
import com.derellea.service.MessageService;
import com.derellea.thread.ChatThread;
import com.derellea.thread.MyThread;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mysql.cj.xdevapi.JsonArray;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@ServerEndpoint("/chat/{sendId&acceptId}")
public class chatSocket {
    private int sendId;
    private int acceptId;
    private Session session;
    private static Map<Integer, chatSocket> clients = new ConcurrentHashMap<Integer, chatSocket>();
    ChatThread thread=new ChatThread();
    MessageService messageService;
    //聊天记录存储
    private List<Message>messages;

    @OnOpen
    public void onOpen(Session session,@PathParam(value="sendId&acceptId") String sendAndaccept) throws Exception {
        //数据格式  sendId-acceptId
        String[]s =sendAndaccept.split("-");
        this.sendId = Integer.parseInt(s[0]);
        this.acceptId= Integer.parseInt(s[1]);

        this.session = session;

        clients.put(sendId, this);
        //连接开始时数据库的值传到前端
        //想调用springmvc的service层方法操作数据库并不能采用注解的方式，故只好这样实现了
        ApplicationContext act = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        messageService=act.getBean(MessageService.class);

        messages=messageService.findBySendIdAndAcceptId(sendId,acceptId);

        //打开的时候
        sendMessageToSend(messages, sendId);

        //开启线程
        thread.sendMessage(sendId,acceptId);

    }


    @OnMessage
    public void onMessage(String data){
        try {
            Map<String,String> result = new ObjectMapper().readValue(data, new TypeReference<Map<String,String>>() { });
            int sendId = Integer.parseInt(result.get("sendId"));
            int acceptId = Integer.parseInt(result.get("acceptId"));
            boolean ifRead = (result.get("ifRead")).equals("1")? true:false;
            String mDesc = result.get("mDesc");
            long mTime = Long.parseLong(result.get("mTime"));
            messageService.insert(sendId,acceptId,ifRead,mDesc,mTime);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @OnClose
    public void onClose() {
        clients.remove(sendId);
        thread.destroy();
    }

    @OnError
    public void onError(Throwable error) {
        thread.destroy();
        error.printStackTrace();
    }

    public void sendMessageToSend(List<Message> messages, int sendId) throws IOException {

        for (chatSocket item : clients.values()) {
            if (item.sendId== sendId) {
                item.session.getAsyncRemote().sendText(new ObjectMapper().writeValueAsString(messages));
            }
        }
    }

    public void sendMessageToAccept(List<Message> messages, int acceptId) throws IOException {

        for (chatSocket item : clients.values()) {
            if (item.acceptId== acceptId) {
                item.session.getAsyncRemote().sendText(new ObjectMapper().writeValueAsString(messages));
            }
        }
    }

}
