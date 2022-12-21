package lt.codeacademy.invoice;

//import static lt.codeacademy.invoice.utils.Utils.ADMIN;
//import static lt.codeacademy.invoice.utils.Utils.MODERATOR;
//import static lt.codeacademy.invoice.utils.Utils.USER;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import lt.codeacademy.invoice.security.services.UserDetailsServiceImpl;
import lt.codeacademy.invoice.entities.Role;


@SpringBootApplication
public class InvoiceReactSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run( InvoiceReactSpringApplication.class, args );
	}
	//
//	@Bean //without this annotation it will not work
//	CommandLineRunner run(UserDetailsServiceImpl userService) {
//		return args -> {
//									
//			//if data exists in db we have to quit 
//			if(!userService.getRoles().isEmpty()) return;
//			
//			//adding first role to the system
//			userService.save(new Role(null, USER));
//			userService.save(new Role(null, ADMIN));
//			userService.save(new Role(null, MODERATOR));
//		};}
}