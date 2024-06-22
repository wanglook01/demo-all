package org.example.simplesend;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Arrays;

/**
 * Created by meishan on 16/12/1.
 */
public class SimpleSendTcpClient {

    static String host = "127.0.0.1";
    static int port = 1122;

    public static void main(String[] args) throws Exception {
        try (Socket socket = new Socket(host, port);
             DataOutputStream dos = new DataOutputStream(socket.getOutputStream())) {
            Thread.sleep(1000);
            System.out.println("连接成功！");

            // 示例：发送一个简单的二进制数据包，这里发送一个字节1
            byte[] bytes = "abcdefghijklmn0123456789".getBytes();
            System.out.println("bytes数组长度:" + bytes.length + ";内容:" + Arrays.toString(bytes));

            dos.write(bytes);

            // 实际应用中，你可以使用dos.write()或dos.writeBytes()等方法发送更多二进制数据
            System.out.println("Data sent to server.");
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("断开连接！");
    }

}
