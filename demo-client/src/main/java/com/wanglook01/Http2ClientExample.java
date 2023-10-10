package com.wanglook01;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.security.KeyStore;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.concurrent.CompletableFuture;

public class Http2ClientExample {


    public static void main1(String[] args) throws Exception {
        // Load the certificate from the resources folder
        InputStream certificateInputStream = Http2ClientExample.class.getResourceAsStream("/your_keystore.p12");

        // Create a KeyStore and load the certificate
        KeyStore keyStore = KeyStore.getInstance("JKS");
        char[] password = "wang123".toCharArray(); // Replace with your keystore password
        keyStore.load(certificateInputStream, password);

        // Create a TrustManagerFactory with the KeyStore
        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        trustManagerFactory.init(keyStore);

        // Create an SSLContext with the TrustManager
        SSLContext sslContext = SSLContext.getInstance("TLS");
        sslContext.init(null, trustManagerFactory.getTrustManagers(), null);

        // Set the SSLContext for the HttpClient
        HttpClient httpClient = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_2)
                .sslContext(sslContext) // Set the custom SSLContext
                .build();

        // Create an HTTP request
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI("https://localhost:8082/demo-http/demo"))
                .build();

        // Send the request asynchronously
        CompletableFuture<HttpResponse<String>> responseFuture = httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString());

        // Handle the response when it is complete
        responseFuture.thenAccept(response -> {
            int statusCode = response.statusCode();
            String responseBody = response.body();
            System.out.println("Status Code: " + statusCode);
            System.out.println("Response Body: " + responseBody);
        });

        // Wait for the response to complete
        responseFuture.join();
    }

    public static void main(String[] args) throws Exception {
        // 加载信任存储（TrustStore）
        KeyStore trustStore = KeyStore.getInstance("JKS");
        char[] trustStorePassword = "wang123".toCharArray();
        InputStream trustStoreInputStream = Http2ClientExample.class.getResourceAsStream("/your_truststore.jks");
        trustStore.load(trustStoreInputStream, trustStorePassword);

        // 初始化信任管理器工厂
        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        trustManagerFactory.init(trustStore);

        // 创建SSL上下文
        SSLContext sslContext = SSLContext.getInstance("TLS");
        sslContext.init(null, trustManagerFactory.getTrustManagers(), null);

        // 创建自定义HTTP客户端
        HttpClient httpClient = HttpClient.newBuilder()
                .sslContext(sslContext)
                .build();

        // 创建HTTP请求
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI("https://localhost:8082/demo-http/demo"))
                .build();

        // 发送HTTP请求
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        // 处理响应
        int statusCode = response.statusCode();
        String responseBody = response.body();
        System.out.println("Status Code: " + statusCode);
        System.out.println("Response Body: " + responseBody);
    }
}
