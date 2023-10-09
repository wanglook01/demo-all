package com.wanglook01.grpc;

import io.grpc.Server;
import io.grpc.ServerBuilder;

public class PbServer {

    public static void main(String[] args) throws Exception {
        int port = 9090;
        Server server = ServerBuilder
                .forPort(port)
                .addService(new UserServiceImpl())
                .build()
                .start();
        System.out.println("server started, port : " + port);
        server.awaitTermination();
    }
}
