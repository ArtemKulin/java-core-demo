package ru.kulinartem.javacore.http.client;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpClientExample {

    public static void main(String[] args) throws IOException, InterruptedException {
        var uri = "https://www.google.com";

        var httpClient = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_1_1)
                .build();

        HttpRequest getRequest = HttpRequest.newBuilder(URI.create(uri))
                .GET()
                .build();
        var postRequest = HttpRequest.newBuilder(URI.create(uri))
                .POST(HttpRequest.BodyPublishers.ofString("body"))
                .build();
        var getResponse = httpClient.send(getRequest, HttpResponse.BodyHandlers.ofString());
        var postResponse = httpClient.send(postRequest, HttpResponse.BodyHandlers.ofString());
        System.out.println(getResponse.body());
        System.out.println(getResponse.headers());
        System.out.println("-------------------------------");
        System.out.println(postResponse.body());
        System.out.println(postResponse.headers());
    }
}
