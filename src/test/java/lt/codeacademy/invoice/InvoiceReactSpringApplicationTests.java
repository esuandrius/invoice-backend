package lt.codeacademy.invoice;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lt.codeacademy.invoice.controllers.ApiController;

@SpringBootTest
class InvoiceReactSpringApplicationTests {

	@Autowired
	private ApiController controller;

	@Test
	void contextLoads() throws Exception {
		assertThat( controller ).isNotNull();
	}

}
