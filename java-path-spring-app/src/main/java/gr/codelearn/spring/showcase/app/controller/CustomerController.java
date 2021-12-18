package gr.codelearn.spring.showcase.app.controller;

import gr.codelearn.spring.showcase.app.domain.Customer;
import gr.codelearn.spring.showcase.app.service.BaseService;
import gr.codelearn.spring.showcase.app.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/customers")
public class CustomerController extends AbstractController<Customer> {
	private final CustomerService customerService;

	@Override
	protected BaseService<Customer, Long> getBaseService() {
		return customerService;
	}

	@GetMapping(params = {"e"})
	public Customer find(@RequestParam("e") String email) {
		return customerService.findByEmail(email);
	}
}
