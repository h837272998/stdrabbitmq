package com.hjh.util;

import cn.hutool.core.net.NetUtil;

import javax.swing.*;

/**
 * @Description:
 * @Author: HJH
 * @Date: 2019-07-03 19:50
 */
public class RabbitMQUtil {
    public static void main(String[] args) {
        checkServer();
    }

    public static void checkServer() {
        if (NetUtil.isUsableLocalPort(15672)) {
            JOptionPane.showMessageDialog(null, "RabbitMQ 服务器未启动 ");
            System.exit(1);
        }
    }
}
