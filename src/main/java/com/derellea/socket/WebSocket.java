package com.derellea.socket;

import com.derellea.domain.Message;
import com.derellea.service.MessageService;
import com.derellea.thread.MyThread;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@ServerEndpoint(value = "/webSocket/{id}")
public class WebSocket {


        private int id;
        private Session session;
        private static Map<Integer, WebSocket> clients = new ConcurrentHashMap<Integer, WebSocket>();
        MyThread thread=new MyThread();
        MessageService messageService;

        @OnOpen
        public void onOpen(Session session,@PathParam(value="id") int id) throws Exception {
                this.id = id;
                this.session = session;

                clients.put(id, this);
                //连接开始时数据库的值传到前端
                //想调用springmvc的service层方法操作数据库并不能采用注解的方式，故只好这样实现了
                ApplicationContext act =
                        new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
                messageService=act.getBean(MessageService.class);
                int count = messageService.countNoreadByAcceptId(id);

                sendMessageTo(Integer.toString(count), id);
                //开启一个线程对数据库中的数据进行轮询
                thread.queryContainer(id);
        }

        @OnClose
        public void onClose() {
                /* thread1.stopMe();*/
                clients.remove(id);
                thread.destroy();
        }

        @OnError
        public void onError(Throwable error) {
                thread.destroy();
                error.printStackTrace();
        }

        public void sendMessageTo(String message, int To) throws IOException {
                // session.getBasicRemote().sendText(message);
                //session.getAsyncRemote().sendText(message);
                for (WebSocket item : clients.values()) {
                        if (item.id==To)
                                item.session.getAsyncRemote().sendText(message);
                }
        }


}
