package com.cvs.inference;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import com.cvs.inference.service.InferenceService;
import com.cvs.inference.representation.Inference;

@SpringBootApplication
public class InferenceApplication {

	public static void main(String[] args) {

		SpringApplication.run(InferenceApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(InferenceService service) {
			return (args) -> {
				System.out.println("CommandLineRunner running in the InferenceApplication class...");
				Inference infer = new Inference("Atul Aphale",
						"{\"listQuestions\" : [{\"question\" : \"Question 1\",\"applicable\" : \"Yes\",\"response\" : \"Development\", \"Comments\" : \"Test 1\"}, {\"question\" : \"Question 2\",\"applicable\" : \"No\",\"response\" : \"Integration\", \"Comments\" : \"Test 2\"}]}",
						60,
						100);
				service.saveInference(infer);
			};
		}
}
