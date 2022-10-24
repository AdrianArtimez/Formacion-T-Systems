/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tsystems.restex;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 *
 * @author aalonsoa
 */
public class WebHttpRequest {

    private final String URL;

    public WebHttpRequest(String URL)
    {
        this.URL = URL;
    }

    public String request()
    {
        String answer = "Null answer";

        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(this.URL))
                    .GET() // GET is default
                    .build();

            HttpResponse<String> response = client.send(request,
                    HttpResponse.BodyHandlers.ofString());
            answer = response.body();
        } catch (IOException | InterruptedException e) {
            System.out.println(e.toString());
        }

        return answer;
    }

}
