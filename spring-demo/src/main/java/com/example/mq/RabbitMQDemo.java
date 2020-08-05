package com.example.mq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.junit.Test;

import java.io.IOException;
import java.lang.invoke.LambdaMetafactory;
import java.util.concurrent.TimeoutException;

/**
 * @author huangbiaof
 * @data 创建时间：2019/7/18 12:50
 */

public class RabbitMQDemo {


    @Test
    public void mqTest() {

    }

    public void messageSend() throws IOException, TimeoutException {
        ConnectionFactory connectionFactory = new ConnectionFactory();

        connectionFactory.setHost("192.168.5.101");

        connectionFactory.setPort(15672);

        Connection connection = connectionFactory.newConnection();

        Channel channel = connection.createChannel();

        channel.queueDeclare("hello", false, false, false, null);

        String message = "some";

        channel.basicPublish("some", "hello", null, message.getBytes("UTF-8"));

        System.out.println("send end");

        channel.close();

        connection.close();
    }
}
