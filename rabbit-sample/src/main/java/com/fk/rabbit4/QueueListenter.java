package com.fk.rabbit4;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.stereotype.Component;

//QueueListenter.java

/**
 * 异步接收消息Consumer
 */
@Component
public class QueueListenter implements MessageListener {

    public void onMessage(Message msg) {
        try{
            System.out.print(msg.toString());
        }catch(Exception e){
            e.printStackTrace();
        }
    }

}