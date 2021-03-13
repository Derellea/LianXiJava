package com.derellea.thread;

import com.derellea.domain.Message;
import com.derellea.service.MessageService;
import com.derellea.socket.WebSocket;
import jdk.management.resource.internal.inst.SocketOutputStreamRMHooks;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class MyThread {
    MessageService messageService;

    private ScheduledExecutorService pool;//循环任务线程池

    private boolean stopMe = true;
    private int count;
    private int new_count;

    public void stopMe() {
        stopMe = false;
    }

    public MyThread() {
        pool = Executors.newScheduledThreadPool(10);
    }

    public void queryContainer(final int id) {
        ApplicationContext act = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        messageService = act.getBean(MessageService.class);
        pool.scheduleAtFixedRate(new Runnable() {
            WebSocket wbs = new WebSocket();

            @Override
            public void run() {

                try {
                    count = messageService.countNoreadByAcceptId(id);
                    while (stopMe) {
                        new_count = messageService.countNoreadByAcceptId(id);

                        if (count != new_count) {

                            count = new_count;
                            wbs.sendMessageTo(Integer.toString(count), id);
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



