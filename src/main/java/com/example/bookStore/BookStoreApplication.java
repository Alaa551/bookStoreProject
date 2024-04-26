package com.example.bookStore;

import com.example.bookStore.model.Email;
import com.example.bookStore.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@SpringBootApplication
public class BookStoreApplication {

	@Autowired
	private EmailService emailService;

	public static void main(String[] args) {
		SpringApplication.run(BookStoreApplication.class, args);
	}

//	@EventListener(ApplicationReadyEvent.class)
//	public void sendEmail(){
//		emailService.sendEmail(
//				new Email("alaaosna23@gmail.com", "Reset Password Email", "hello")
//		);
//	}
}
