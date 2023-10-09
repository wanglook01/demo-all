package com.wanglook01;

import io.undertow.Undertow;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.undertow.UndertowBuilderCustomizer;
import org.springframework.boot.web.embedded.undertow.UndertowServletWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoHttpApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoHttpApplication.class, args);
    }


    @Bean
    public WebServerFactoryCustomizer<UndertowServletWebServerFactory> undertowCustomizer() {
        return factory -> {
            factory.addBuilderCustomizers(new UndertowBuilderCustomizer() {
                @Override
                public void customize(Undertow.Builder builder) {
                    builder.addHttpListener(8081, "0.0.0.0");
                    builder.setIoThreads(4);
                    builder.setWorkerThreads(10);
                }
            });
        };
    }

}
