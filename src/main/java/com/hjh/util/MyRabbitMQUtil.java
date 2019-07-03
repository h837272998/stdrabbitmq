package com.hjh.util;

import javax.swing.*;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * @Description:
 * @Author: HJH
 * @Date: 2019-07-03 21:50
 */
public class MyRabbitMQUtil {

    public static void main(String[] args) {

    }

    public static void checkServer(String hostname,int port){
        Socket socket = new Socket();
        InetSocketAddress inetSocketAddress = new InetSocketAddress(hostname,port);
        try {
            socket.connect(inetSocketAddress,5000);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "无法连接到 "+hostname+"的RabbitMq服务...");
            System.exit(1);
        }
    }

}
