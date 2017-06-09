package com.fk.rabbit3;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.ShutdownSignalException;

import java.io.IOException;

/**
 * 连接管理
 */
public class ConnectionManage {

    private volatile Connection connection;

    public ConnectionManage(String rmqServerIP, int rmqServerPort)
            throws IOException {
        ConnectionFactory cf = new ConnectionFactory();
        cf.setHost(rmqServerIP);
        cf.setPort(rmqServerPort);
        connection = cf.newConnection();
    }

    @SuppressWarnings("finally")
    public Channel createChannel() {
        Channel channel = null;
        try {
            channel = connection.createChannel();
        } catch (ShutdownSignalException e1) {
        } catch (IOException e) {
        }
        return channel;
    }

    public void shutdown() throws IOException {
        if (connection != null)
            connection.close();
    }
}