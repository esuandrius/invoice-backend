package lt.codeacademy.invoice;

//import static lt.codeacademy.invoice.utils.Utils.ADMIN;
//import static lt.codeacademy.invoice.utils.Utils.MODERATOR;
//import static lt.codeacademy.invoice.utils.Utils.USER;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import lt.codeacademy.invoice.security.services.UserDetailsServiceImpl;
import lt.codeacademy.invoice.services.RoleService;
import lt.codeacademy.invoice.services.UserService;
import lt.codeacademy.invoice.entities.ERole;
import lt.codeacademy.invoice.entities.Role;
import lt.codeacademy.invoice.entities.User;
import lt.codeacademy.invoice.repositories.RoleRepository;


@SpringBootApplication
public class InvoiceReactSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run( InvoiceReactSpringApplication.class, args );
	}
	//
//	@Bean //without this annotation it will not work
//	CommandLineRunner run(RoleService roleService,UserService userService, RoleRepository roleRep	) {
//		
//		return args -> {
//			
//			
//			//if data exists in db we have to quit 
//			if(!roleService.getRoleList().isEmpty()) return;
//			
//			//adding first role to the system
//			roleService.addRole(new Role(null, ERole.ROLE_USER));
//			roleService.addRole(new Role(null, ERole.ROLE_MODERATOR));
//			roleService.addRole(new Role(null, ERole.ROLE_ADMIN));
//			Role adminRole = roleRep.findByName(ERole.ROLE_ADMIN).orElseThrow(() -> new RuntimeException("Error: Role is not found."));
//			userService.addUser(new User("Admin", "admin@admin.com", "123456", adminRole));
//			
//		};}
}