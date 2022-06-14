package ru.kulinartem.javacore.http;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class DataGramRunner {

    public static void main(String[] args) throws IOException {
        var inetAddress = InetAddress.getByName("localhost");
        var port = 7777;

        try (var datagramSocket = new DatagramSocket()) {
            var bytes = "Hello from DatagramRunner".getBytes();
            var packet = new DatagramPacket(bytes, bytes.length, inetAddress, port);
            datagramSocket.send(packet);
        }
    }


}
