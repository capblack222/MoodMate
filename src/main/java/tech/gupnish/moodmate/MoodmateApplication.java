package tech.gupnish.moodmate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class MoodmateApplication {

	public static void main(String[] args) {
		SpringApplication.run(MoodmateApplication.class, args);
		System.out.println("Moodmate application started successfully!");
	}

	@GetMapping("/hello")
	public String hello() {
		return "Hello, welcome to Moodmate!";
	}

}
