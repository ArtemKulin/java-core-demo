package ru.kulinartem.javacore.http;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

public class SocketServerRunner {

    public static void main(String[] args) throws IOException {
        final var stopWord = "stop";
        try (var serverSocket = new ServerSocket(7777);
             var socket = serverSocket.accept();
             var scanner = new Scanner(in)) {
            var dataOutputStream = new DataOutputStream(socket.getOutputStream());
            var dataInputStream = new DataInputStream(socket.getInputStream());
            var request = dataInputStream.readUTF();
            while (!stopWord.equalsIgnoreCase(request)) {
                out.println("Client request " + request);
                var response = scanner.nextLine();
                dataOutputStream.writeUTF(response);
                request = dataInputStream.readUTF();
            }
        }
    }
}