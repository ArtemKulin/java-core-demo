package ru.kulinartem.javacore.server;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Path;
import java.util.concurrent.ExecutionException;

public class HttpClientRunner {

    public static void main(String[] args) throws IOException, InterruptedException, ExecutionException {
        var httpClient = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_1_1)
                .build();

        var request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:9000"))
                .header("content-type", "application/xml")
                .POST(HttpRequest.BodyPublishers.ofFile(Path.of("resources", "first.xml")))
                .build();

        //var response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        //System.out.println(response.headers());
        //System.out.println(response.body());

        var response = httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString());
        var response1 = httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString());
        var response2 = httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString());

        System.out.println(response2.get().body());
    }
}
