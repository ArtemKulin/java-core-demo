package ru.kulinartem.javacore.server;

public class HttpServerRunner {

    public static void main(String[] args) {
        var server = new HttpServer(9000);
        server.run();
    }
}
