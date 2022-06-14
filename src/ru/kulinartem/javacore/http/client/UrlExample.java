package ru.kulinartem.javacore.http.client;

import java.io.IOException;
import java.net.URL;

public class UrlExample {

    public static void main(String[] args) throws IOException {
        var url = new URL("file:/Users/artemkulin/IdeaProjects/java-core-demo/src/ru/kulinartem/javacore/http/DataGramRunner.java");
        var urlConnection = url.openConnection();

        System.out.println(new String(urlConnection.getInputStream().readAllBytes()));
    }

}
