package com.rise.demo.reactive.spring.client;

import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

public class PersonServiceClient {

    public static void main(String[] args) {
        WebClient webClient = WebClient.create("http://localhost:8080");
        webClient.get().uri("/persons")
                .accept(MediaType.APPLICATION_JSON).exchange();
    }
}
