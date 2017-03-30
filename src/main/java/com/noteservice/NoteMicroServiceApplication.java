package com.noteservice;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

import com.noteservice.pojo.Role;
import com.noteservice.pojo.User;
import com.noteservice.repositories.RoleRepository;
import com.noteservice.repositories.UserRepository;

@SpringBootApplication
@Import(SecurityConfig.class)
public class NoteMicroServiceApplication{

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	RoleRepository roleRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(NoteMicroServiceApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner commandlineRunner(UserRepository userRepository,RoleRepository roleRepository){
		return new CommandLineRunner() {
			
			@Override
			public void run(String... args) throws Exception {
				User adminUser = new User("admin@noteservice.com", "passcode");
				User user1User = new User("user1@noteservice.com", "passcode");
				
				Set<User> set1 = new HashSet<User>();
				set1.add(adminUser);
				Role adminRole = new Role("admin", set1);
				Set<User> set2 = new HashSet<User>();
				set1.add(user1User);
				Role userRole = new Role("user", set2);

				userRepository.save(adminUser);
				userRepository.save(user1User);
				roleRepository.save(adminRole);
				roleRepository.save(userRole);
			}
		};
	}
	
}
