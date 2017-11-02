package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@RestController
	public class MyController {

	    @RequestMapping("hello")
	    public CompletableFuture<String> hello() {

            // 새로운 쓰레드 생성한다.
            return CompletableFuture
                    .supplyAsync(() -> "Hello World")
                    .thenApplyAsync(s -> s.toUpperCase());
        }
	}
}
