package com.hexaware.customerrestapi.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.customerrestapi.dto.CustomerDTO;
import com.hexaware.customerrestapi.dto.CustomerProductVO;
import com.hexaware.customerrestapi.entities.Customer;
import com.hexaware.customerrestapi.service.CustomerServiceImpl;
import com.hexaware.customerrestapi.service.ICustomerService;

@RestController
@RequestMapping("/api/customers")
public class CustomerRestConroller {

	@Autowired
	ICustomerService service = new CustomerServiceImpl();

	@PostMapping("/add")
	public Customer addCustomer(@RequestBody CustomerDTO dto) {
		return service.addCustomer(dto);
	}

	@GetMapping("/get/{customerId}")
	public CustomerDTO getCustomerById(@PathVariable int customerId) {
		return service.getCustomerById(customerId);
	}

	@GetMapping("/getall")
	public List<Customer> getAllCustomer() {
		return service.getAllCustomer();
	}
	

	@GetMapping("/getdetails/{customerId}")
	public CustomerProductVO getCustomerAndProductById(@PathVariable int customerId) {
		return service.getCustomerAndProductById(customerId);
	}
	
	@DeleteMapping("/delete/{customerId}")
	public String deleteProductbyCustomer(@PathVariable int customerId) {
		service.deleteProductbyCustomer(customerId);
		return "1 record deleted";
	}
	
	@PutMapping("/update/{customerId}/{productId}")
	public CustomerProductVO updateProductforCustomer(@PathVariable int customerId, @PathVariable int productId) {
		return service.updateProductforCustomer(customerId, productId);
	}

}
