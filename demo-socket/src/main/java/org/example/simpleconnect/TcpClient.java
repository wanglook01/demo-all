package org.example.simpleconnect;

import javax.net.SocketFactory;
import java.net.Socket;

/**
 * Created by meishan on 16/12/1.
 */
public class TcpClient {

    public static void main(String[] args) throws Exception {
        boolean isConnected;
        String host = "127.0.0.1";
        int port = 1122;
        Socket socket = null;
        try {
            socket = SocketFactory.getDefault().createSocket(host, port);
            isConnected = true;
            System.out.println("连接成功！");
        } catch (Exception e) {
            isConnected = false;
            System.out.println("连接失败！" + e.getMessage());
        }

        if (!isConnected) {
            return;
        }

        Thread.sleep(5000);

        socket.close();
        System.out.println("断开连接！");
    }
}
