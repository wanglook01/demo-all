package org.example.protocol;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class CustomProtocol {

    public byte[] encodeMessage(int messageType, byte[] messageBody) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);

        // Write message type (1 byte)
        dataOutputStream.writeByte(messageType);

        // Write message body length (4 bytes)
        dataOutputStream.writeInt(messageBody.length);

        // Write message body
        dataOutputStream.write(messageBody);

        // Flush and return encoded message
        dataOutputStream.flush();
        return byteArrayOutputStream.toByteArray();
    }

    public void decodeMessage(byte[] receivedData) throws IOException {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(receivedData);
        DataInputStream dataInputStream = new DataInputStream(byteArrayInputStream);

        // Read message type (1 byte)
        int messageType = dataInputStream.readByte();

        // Read message body length (4 bytes)
        int messageLength = dataInputStream.readInt();

        // Read message body
        byte[] messageBody = new byte[messageLength];
        dataInputStream.readFully(messageBody);

        // Process the message based on messageType and messageBody
        processMessage(messageType, messageBody);
    }

    private void processMessage(int messageType, byte[] messageBody) {
        // Implement message processing based on messageType and messageBody
        // Example:
        switch (messageType) {
            case 0x01:
                // Text message processing
                String textMessage = new String(messageBody, StandardCharsets.UTF_8);
                System.out.println("Received text message: " + textMessage);
                break;
            case 0x02:
                // Image message processing
                // Handle image data in messageBody
                break;
            case 0x03:
                // Audio message processing
                // Handle audio data in messageBody
                break;
            default:
                System.out.println("Unknown message type: " + messageType);
        }
    }
}
