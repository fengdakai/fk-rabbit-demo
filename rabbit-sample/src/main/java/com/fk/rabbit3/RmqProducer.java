package com.fk.rabbit3;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.MessageProperties;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import java.io.IOException;

/**
 * 生产着 
 * 
 */  
public class RmqProducer implements InitializingBean,DisposableBean {
      
    private String rmqServerIP;//ip地址  
    private int rmqServerPort;//端口    
    private int threadPoolNum;//线程数  
    private String exchangeType;//类型  
    private String exchange;//交换器     
    private ConnectionManage connectManage;  
    private Channel channel;                  

    /** 
     * 初始化 
     */  
    public void afterPropertiesSet() throws Exception {
        //创建连接管理器  
        connectManage=new ConnectionManage(rmqServerIP,rmqServerPort);  
        boolean durable=true;//是否持久化  
        boolean autoDelete=false;//是否自动删除  
        Channel channel=connectManage.createChannel();
        channel.exchangeDeclare(exchange, exchangeType, durable,autoDelete,null);  
    }

    /** 
     * 发送信息 
     * @param msg 
     */  
    public void sendMessage(final RabbitMessage  msg) throws IOException {
        channel.basicPublish(msg.getExchange(),msg.getRouteKey(), MessageProperties.PERSISTENT_TEXT_PLAIN,msg.getSerialBytes());
    }
  
    /** 
     *  
     * @throws Exception 
     */  
    public void destroy() throws Exception {
        connectManage.shutdown();  
    }  
  
    public String getRmqServerIP() {  
        return rmqServerIP;  
    }  
  
    public void setRmqServerIP(String rmqServerIP) {  
        this.rmqServerIP = rmqServerIP;  
    }  

    public String getExchangeType() {  
        return exchangeType;  
    }  
  
    public void setExchangeType(String exchangeType) {  
        this.exchangeType = exchangeType;  
    }  
  
    public int getRmqServerPort() {  
        return rmqServerPort;  
    }  
  
    public void setRmqServerPort(int rmqServerPort) {  
        this.rmqServerPort = rmqServerPort;  
    }  

    public String getExchange() {
        return exchange;  
    }  

    public void setExchange(String exchange) {  
        this.exchange = exchange;  
    }  
  
      
}