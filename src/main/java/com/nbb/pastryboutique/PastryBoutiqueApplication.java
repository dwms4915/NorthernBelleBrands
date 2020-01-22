package com.nbb.pastryboutique;

import java.util.stream.Stream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

import com.nbb.pastryboutique.user.User;
import com.nbb.pastryboutique.user.UserRepository;

@SpringBootApplication
public class PastryBoutiqueApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(PastryBoutiqueApplication.class, args);
	}
	
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(PastryBoutiqueApplication.class);
	}
	
	
	@Bean
    CommandLineRunner init(UserRepository userRepository) {
        return args -> {
            Stream.of("Cake", "Cookie", "Cinnamon Rolls", "Cake Shots", "Cupcakes").forEach(name -> {
                User user = new User(name, name.toLowerCase() + "@domain.com");
                userRepository.save(user);
            });
            userRepository.findAll().forEach(System.out::println);
          
            
        };
    }

}
