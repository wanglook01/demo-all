package org.example.simpleconnect;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServer {

    private static int port = 1122;

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(port, 3);//显式设置连接请求队列的长度为3
        System.out.println("服务器启动!");
        Thread.sleep(3000);
        while (true) {
            Socket socket = null;
            try {
                socket = serverSocket.accept();
                System.out.println("New connection accepted " + socket.getInetAddress() + ":" + socket.getPort());
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (socket != null) {
                    try {
                        socket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
