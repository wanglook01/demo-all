package org.example.simplesend;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;

public class SimpleSendTcpServer {

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
                read(socket);
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
    //读取数据
    private static void read(Socket clientSocket) {
        try (DataInputStream dis = new DataInputStream(clientSocket.getInputStream())) {
            byte[] buffer = new byte[10]; // 缓冲区大小可以根据需要调整,比如1024，这里测试设置小一些
            int bytesRead;
            while ((bytesRead = dis.read(buffer)) != -1) { // 当没有更多数据可读时，read方法返回-1
                // 处理接收到的数据，这里是简单打印出来
                // 实际应用中，你可能需要根据数据包结构进行解析
                System.out.println("Received " + bytesRead + " bytes of data.");
                // 根据需要处理buffer中的数据，这里省略具体处理逻辑
                System.out.println("data: " + Arrays.toString(buffer));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
