package com.hexaware.customerrestapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.hexaware.customerrestapi.dto.CustomerDTO;
import com.hexaware.customerrestapi.dto.CustomerProductVO;
import com.hexaware.customerrestapi.dto.Product;
import com.hexaware.customerrestapi.entities.Customer;
import com.hexaware.customerrestapi.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements ICustomerService {
	
	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private CustomerRepository repo;

	@Override
	public Customer addCustomer(CustomerDTO customerDTO) {
		Customer customer = new Customer();
		customer.setCustomerId(customerDTO.getCustomerId());
		customer.setCustomerName(customerDTO.getCustomerName());
		customer.setDateOfBirth(customerDTO.getDateOfBirth());
		customer.setProductId(customerDTO.getProductId());

		return repo.save(customer);
	}

	@Override
	public CustomerDTO getCustomerById(int customerId) {
		Customer cust = repo.findById(customerId).orElse(null);
		CustomerDTO dto = new CustomerDTO();
		dto.setCustomerId(cust.getCustomerId());
		dto.setCustomerName(cust.getCustomerName());
		dto.setDateOfBirth(cust.getDateOfBirth());
		dto.setProductId(cust.getProductId());
		return dto;
	}

	@Override
	public List<Customer> getAllCustomer() {
		return repo.findAll();
	}

	@Override
	public CustomerProductVO getCustomerAndProductById(int customerId) {
		
		CustomerDTO customer = getCustomerById(customerId);
		int pid = customer.getProductId();
		
		Product product = restTemplate.getForObject("http://localhost:8282/api/products/get/"+pid, Product.class);
		
		CustomerProductVO vo = new CustomerProductVO();
		vo.setCustomer(customer);
		vo.setProduct(product);
		return vo;
	}

	@Override
	public void deleteProductbyCustomer(int customerId) {
		CustomerDTO customer = getCustomerById(customerId);
		int pid = customer.getProductId();
		restTemplate.delete("http://localhost:8282/api/products/delete"+pid);
		
	}

	@Override
	public CustomerProductVO updateProductforCustomer(int customerId, int productId) {
		Product product = restTemplate.getForObject("http://localhost:8282/api/products/get/"+productId, Product.class);
		CustomerDTO dto = getCustomerById(customerId);
		Customer customer = new Customer();
		dto.setProductId(productId);
		customer.setCustomerId(customerId);
		customer.setCustomerName(dto.getCustomerName());
		customer.setDateOfBirth(dto.getDateOfBirth());
		customer.setProductId(productId);
		repo.save(customer);
		
		CustomerProductVO vo = new CustomerProductVO();
		vo.setCustomer(dto);
		vo.setProduct(product);
		return vo;
	}

}
