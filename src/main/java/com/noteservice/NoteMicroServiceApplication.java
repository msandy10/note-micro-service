package com.noteservice;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.noteservice.pojo.User;
import com.noteservice.repositories.UserRepository;

@SpringBootApplication
public class NoteMicroServiceApplication{

	@Autowired
	UserRepository userRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(NoteMicroServiceApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner commandlineRunner(UserRepository userRepository){
		return new CommandLineRunner() {
			
			@Override
			public void run(String... args) throws Exception {
				userRepository.save(new User("admin@noteservice.com", "passcode", new Date(), new Date()));
				userRepository.save(new User("user1@noteservice.com", "passcode", new Date(), new Date()));
			}
		};
	}
}
