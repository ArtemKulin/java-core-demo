package ru.kulinartem.javacore.http;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Inet4Address;
import java.net.Socket;
import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

public class SocketRunner {

    public static void main(String[] args) throws IOException {
        var inetAddress = Inet4Address.getByName("localhost");
        var port = 7777;

        try (var socket = new Socket(inetAddress, port);
             var outputStream = new DataOutputStream(socket.getOutputStream());
             var inputStream = new DataInputStream(socket.getInputStream());
             var scanner = new Scanner(in)) {
            while (scanner.hasNextLine()) {
                final var request = scanner.nextLine();
                outputStream.writeUTF(request);
                var response = inputStream.readUTF();
                out.println("Response from server: " + response);
            }
        }
    }
}