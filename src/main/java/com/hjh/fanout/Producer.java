package com.hjh.fanout;

import com.hjh.util.MyRabbitMQUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @Description:消息生成者
 * @Author: HJH
 * @Date: 2019-07-03 21:38
 */
public class Producer {
    public static final String EXCHANGE_NAME = "fanout_exchange";
    public static final String HOSTNAME = "47.106.130.59";
    public static final int PORT = 15672;

    public static void main(String[] args) throws IOException, TimeoutException {
//        检测服务是否启动
        MyRabbitMQUtil.checkServer(HOSTNAME, PORT);
//        创建连接工厂
        ConnectionFactory factory = new ConnectionFactory();
//        设置RMQ相关信息
        factory.setHost(HOSTNAME);
//        创建一个新的连接
        Connection connection = factory.newConnection();
//        创建一个通道
        Channel channel = connection.createChannel();

        channel.exchangeDeclare(EXCHANGE_NAME,"fanout");

        String message = "fanout消息...";
        //发送消息到队列中
        channel.basicPublish(EXCHANGE_NAME, "", null, message.getBytes("UTF-8"));
        System.out.println("发送消息： " + message);

//        关闭通道和连接
        channel.close();
        connection.close();
    }
}
