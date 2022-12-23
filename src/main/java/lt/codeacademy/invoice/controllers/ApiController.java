package lt.codeacademy.invoice.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.ApiOperation;

import lt.codeacademy.invoice.entities.Customer;
import lt.codeacademy.invoice.entities.Invoice;
import lt.codeacademy.invoice.entities.Item;
import lt.codeacademy.invoice.entities.Role;
import lt.codeacademy.invoice.entities.User;
import lt.codeacademy.invoice.services.CustomerService;
import lt.codeacademy.invoice.services.InvoiceService;
import lt.codeacademy.invoice.services.ItemService;
import lt.codeacademy.invoice.services.RoleService;
import lt.codeacademy.invoice.services.UserService;

/**
 * Komentaras virš klasės JavaDoc. ApiController komentaras Šita klasė pažymėta
 * kaip RestController, turi endpointus ir dirba su JSON tipo failais
 *
 */
@ApiOperation(value ="Invoice API", notes = "")
@RestController
@RequestMapping("/api/v1")
@CrossOrigin("*")
public class ApiController {

	@Autowired
	private CustomerService customerService;

	@Autowired
	private ItemService itemService;

	@Autowired
	private InvoiceService invoiceService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	PasswordEncoder encoder;

	//*************** Customers endpoint's
	
	@ApiOperation(value = "Get all Customers list")	//Customize method description in swagger
	@GetMapping("/customers")
	@PreAuthorize("hasRole('USER') or hasRole('MANAGER') or hasRole('ADMIN')")
	public List<Customer> getAllCustomers() {
		return customerService.getCustomerList();
	}

	@PostMapping("/customers")
	@PreAuthorize("hasRole('MANAGER') or hasRole('ADMIN')")
	public Customer saveCustomerDetails(@RequestBody Customer customer) {
		System.out.println( customer );
		return customerService.addCustomer( customer );
	}

	@PostMapping("/customers/{id}")
	@PreAuthorize("hasRole('MANAGER') or hasRole('ADMIN')")
	public Customer updateCustomer(@RequestBody Customer customer, @PathVariable Long id) {
		return customerService.updateCustomerById( id, customer );
	}

	@GetMapping("/customers/{id}")
	@PreAuthorize("hasRole('USER') or hasRole('MANAGER') or hasRole('ADMIN')")
	public Customer getCustomerById(@PathVariable Long id) {
		return customerService.getCustomerById( id );
	}

	@DeleteMapping("/customers/{id}")
	@PreAuthorize("hasRole('MANAGER') or hasRole('ADMIN')")
	public ResponseEntity<HttpStatus> deleteCustomerById(@PathVariable Long id) {
		customerService.deleteCustomerById( id );
		return new ResponseEntity<>( HttpStatus.NO_CONTENT );
	}

	//*************** Items endpoint's
	
	@GetMapping("/items")
	@PreAuthorize("hasRole('USER') or hasRole('MANAGER') or hasRole('ADMIN')")
	public List<Item> getAllItems() {
		return itemService.getItemList();
	}

	@PostMapping("/items")
	@PreAuthorize("hasRole('MANAGER') or hasRole('ADMIN')")
	public Item saveItemDetails(@RequestBody Item item) {
		return itemService.addItem( item );
	}

	@PostMapping("/items/{id}")
	@PreAuthorize("hasRole('MANAGER') or hasRole('ADMIN')")
	public Item updateItem(@RequestBody Item item, @PathVariable Long id) {
		return itemService.updateItemById( id, item );
	}

	@GetMapping("/items/{id}")
	@PreAuthorize("hasRole('USER') or hasRole('MANAGER') or hasRole('ADMIN')")
	public Item getItemById(@PathVariable Long id) {
		return itemService.getItemById( id );
	}
	
	@DeleteMapping("/items/{id}")
	@PreAuthorize("hasRole('MANAGER') or hasRole('ADMIN')")
	public ResponseEntity<HttpStatus> deleteItemById(@PathVariable Long id) {
		itemService.deleteItemById( id );
		return new ResponseEntity<>( HttpStatus.NO_CONTENT );
	}
	
	//*************** Invoices endpoint's
	
	@PreAuthorize("hasRole('USER') or hasRole('MANAGER') or hasRole('ADMIN')")
	@GetMapping("/invoices")
	public List<Invoice> getAllInvoices() {

		return invoiceService.getInvoiceList();
	}
	@PreAuthorize("hasRole('USER') or hasRole('MANAGER') or hasRole('ADMIN')")
	@PostMapping("/invoices")
	public Invoice saveInvoiceDetails(@RequestBody Invoice invoice) {
		return invoiceService.addInvoice( invoice );
	}

	@PostMapping("/invoices/{id}")
	@PreAuthorize("hasRole('MANAGER') or hasRole('ADMIN')")
	public Invoice updateInvoice(@RequestBody Invoice invoice, @PathVariable Long id) {
		return invoiceService.updateInvoiceById( id, invoice );
	}

	@GetMapping("/invoices/{id}")
	@PreAuthorize("hasRole('USER') or hasRole('MANAGER') or hasRole('ADMIN')")
	public Invoice getInvoiceById(@PathVariable Long id) {
		return invoiceService.getInvoiceById( id );
	}

	@DeleteMapping("/invoices/{id}")
	@PreAuthorize("hasRole('MANAGER') or hasRole('ADMIN')")
	public ResponseEntity<HttpStatus> deleteInvoiceById(@PathVariable Long id) {
		invoiceService.deleteInvoiceById( id );
		return new ResponseEntity<>( HttpStatus.NO_CONTENT );
	}
	
	//*************** Users endpoint's

	@GetMapping("/users")
	@PreAuthorize("hasRole('MANAGER') or hasRole('ADMIN')")
	public List<User> getAllUsers() {
		return userService.getUserList();
	}
	
	@PostMapping("/users")
	@PreAuthorize("hasRole('ADMIN')")
	public User saveUser(@RequestBody User user) {
		String pass=encoder.encode(user.getPassword());
		user.setPassword(pass);
		System.out.println(pass + "       cia passs");
		return userService.addUser( user );
	}

	@PostMapping("/users/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public User updateUser(@RequestBody User user, @PathVariable Long id) {
		return userService.updateUserById( id, user );
	}

	@GetMapping("/users/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public User getUserById(@PathVariable Long id) {
		return userService.getUserById( id );
	}

	@DeleteMapping("/users/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<HttpStatus> deleteUserById(@PathVariable Long id) {
		userService.deleteUserById( id );
		return new ResponseEntity<>( HttpStatus.NO_CONTENT );
	}
	
	//*************** Roles endpoint's
	
	@GetMapping("/roles")
	@PreAuthorize("hasRole('USER') or hasRole('MANAGER') or hasRole('ADMIN')")
	public List<Role> getAllRoles() {
		return roleService.getRoleList();
	}
	
	@GetMapping("/all")
	public String allAccess() {
	    return "Public Content.";
	}

}
