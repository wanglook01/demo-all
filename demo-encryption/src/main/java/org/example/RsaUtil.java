package org.example;

import javax.crypto.Cipher;
import java.nio.charset.StandardCharsets;
import java.security.KeyPair;
import java.security.KeyPairGenerator;

public class RsaUtil {


    public static void main(String[] args) throws Exception {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(1024);
        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        //
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, keyPair.getPublic());
        byte[] data = cipher.doFinal("hello".getBytes());
        System.out.println(new String(data, StandardCharsets.UTF_8));
        //
        cipher.init(Cipher.DECRYPT_MODE, keyPair.getPrivate());
        byte[] result = cipher.doFinal(data);
        System.out.println(new String(result));
    }
}
