package com.example.mq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author huangbiaof
 * @data 创建时间：2019/7/18 13:02
 */

public class MessageSender {

    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory connectionFactory = new ConnectionFactory();

        connectionFactory.setHost("192.168.5.101");

        connectionFactory.setPort(5672);
        connectionFactory.setUsername("mall");
        connectionFactory.setPassword("mall");
        Connection connection = connectionFactory.newConnection();

        Channel channel = connection.createChannel();

        channel.queueDeclare("hello", false, false, false, null);

        String message = "some";

        channel.basicPublish("mall", "hello", null, message.getBytes("UTF-8"));

        System.out.println("send end");

        channel.close();

        connection.close();
    }
}
