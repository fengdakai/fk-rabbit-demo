package com.fk.rabbit.message;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MessageHandler {
  
    private Logger log = LoggerFactory.getLogger(MessageHandler.class);
      
    public void handleMessage(CommonMessage message) {
        try{  
            System.out.println("...." + message);
            System.out.println(".."+ message.getSource());
        }catch(Exception e){  
            e.printStackTrace();  
        }  
    }  
      
}