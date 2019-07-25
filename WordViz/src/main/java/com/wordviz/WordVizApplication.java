package com.wordviz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "localhost:8085")
@SpringBootApplication
public class WordVizApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(WordVizApplication.class, args);
	}

}