package com.reactiveclown.openaiwebfluxclient;

import com.reactiveclown.openaiwebfluxclient.asynchronous.completions.CreateCompletionRequest;
import com.reactiveclown.openaiwebfluxclient.asynchronous.completions.CreateCompletionResponse;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;


@SpringBootApplication
public class OpenaiWebfluxClientApplication {

    @Autowired
    WebClient client;

    public static void main(String[] args) {
        SpringApplication.run(OpenaiWebfluxClientApplication.class, args);
    }

    @PostConstruct
    public void someSort() {

        var request = new CreateCompletionRequest
                .Builder("babbage")
                .promptListOfLists(List.of(List.of("prompt")))
                .build();

        var response = client.post()
                .uri("/completions")
                .bodyValue(request)
                .retrieve()
                .bodyToMono(CreateCompletionResponse.class)
                .block();
        System.out.println(response);
    }
}
