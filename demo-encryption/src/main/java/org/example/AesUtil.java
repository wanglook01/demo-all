package org.example;

import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.security.Security;

public class AesUtil {


    public static void main1(String[] args) {
        Provider[] providers = Security.getProviders();
        for (Provider p : providers) {
            System.out.println(p.getName());
        }
    }

    public static void main(String[] args) {
        try {
            MessageDigest digester = MessageDigest.getInstance("SHA-512");
            byte[] input = "Secret string".getBytes();
            byte[] digest = digester.digest(input);
            System.out.println(DatatypeConverter.printHexBinary(digest));
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException(e);
        }
    }
}
