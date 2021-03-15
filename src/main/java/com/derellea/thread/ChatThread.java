package com.derellea.thread;

import com.derellea.domain.Message;
import com.derellea.service.MessageService;
import com.derellea.socket.WebSocket;
import com.derellea.socket.chatSocket;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ChatThread {
    MessageService messageService;

    private ScheduledExecutorService pool;//循环任务线程池

    private boolean stopMe = true;
    private List<Message> messages;
    private List<Message> new_messages;

    public void stopMe() {
        stopMe = false;
    }

    public ChatThread() {
        pool = Executors.newScheduledThreadPool(10);
    }

    public void sendMessage(final int sendId,final int acceptId) {
        ApplicationContext act = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        messageService = act.getBean(MessageService.class);
        pool.scheduleAtFixedRate(new Runnable() {
            chatSocket cs=new chatSocket();

            @Override
            public void run() {

                try {
                    messages = messageService.findBySendIdAndAcceptId(sendId,acceptId);
                    while (stopMe) {
                        //查数据库里的聊天记录
                        new_messages = messageService.findBySendIdAndAcceptId(sendId,acceptId);

                        if (messages.size() != new_messages.size()) {

                            messages = new_messages;
                            cs.sendMessageToSend(messages,sendId);
                            cs.sendMessageToAccept(messages,acceptId);
                        }
                    }
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }, 2000, 2000, TimeUnit.MILLISECONDS);
    }

    public void destroy() {// 线程池停止后的方法
        System.out.println("end *******************************************************************");
        pool.shutdownNow();
    }

}
