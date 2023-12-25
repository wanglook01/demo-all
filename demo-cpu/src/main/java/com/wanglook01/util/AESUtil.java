package com.wanglook01.util;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;

public class AESUtil {

    public static final String key = "jkl;POIU1234++==";

    // 加密
    // deprecated
    public static String encrypt(String input) {
        try {
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            SecretKeySpec keySpec = new SecretKeySpec(key.getBytes(StandardCharsets.UTF_8), "AES");
            cipher.init(Cipher.ENCRYPT_MODE, keySpec);
            byte[] aesStr = cipher.doFinal(input.getBytes(StandardCharsets.UTF_8));
            //
            byte[] bytes = Base64.encodeBase64(aesStr);
            //
            return new String(bytes, StandardCharsets.UTF_8);
        } catch (Exception e) {
            throw new RuntimeException("error");
        }
    }

    // 解密
    // deprecated
    public static String decrypt(String sStr) {
        try {
            byte[] cipherText = Base64.decodeBase64(sStr);
            //
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            SecretKeySpec keySpec = new SecretKeySpec(key.getBytes(), "AES");
            cipher.init(Cipher.DECRYPT_MODE, keySpec);
            byte[] encrypted = cipher.doFinal(cipherText);
            //
            return new String(encrypted, StandardCharsets.UTF_8);
        } catch (Exception e) {
            throw new RuntimeException("error");
        }
    }

    public static void main(String[] args) {
        String body = "王二小立了大功";
        String encrypt = encrypt(body);
        System.out.println(encrypt);
        //
        String decrypt = decrypt(encrypt);
        System.out.println(decrypt);
    }

}
