package com.reactiveclown.openaiwebfluxclient;

import com.reactiveclown.openaiwebfluxclient.asynchronous.models.ListModelsResponse;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.reactive.function.client.WebClient;


@SpringBootApplication
public class OpenaiWebfluxClientApplication {

	@Autowired
	 WebClient client;

	public static void main(String[] args) {
		SpringApplication.run(OpenaiWebfluxClientApplication.class, args);
	}

	@PostConstruct
	public void someSort(){

		var monoResponse = client.get()
				.uri("/models")
				.retrieve()
				.bodyToMono(ListModelsResponse.class);

		ListModelsResponse response = monoResponse.block();
	}
}
