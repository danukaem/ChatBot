package com.sliit.chatApplication;

import com.sliit.chatApplication.service.impl.HttpService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ChatApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChatApplication.class, args);
		HttpService httpService = new HttpService();
		String url = "http://localhost:5000/generateChatModel";

		httpService.sendHttpGetUrlConnection(url);

	}

}
