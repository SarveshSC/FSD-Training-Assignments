package com.hexaware.customerrestapi.service;

import java.util.List;

import com.hexaware.customerrestapi.dto.CustomerDTO;
import com.hexaware.customerrestapi.dto.CustomerProductVO;
import com.hexaware.customerrestapi.entities.Customer;

public interface ICustomerService {
	public Customer addCustomer(CustomerDTO customerDTO);

	public CustomerDTO getCustomerById(int customerId);

	public List<Customer> getAllCustomer();

	public CustomerProductVO getCustomerAndProductById(int customerId);
	
	public void deleteProductbyCustomer(int customerId);
	
	public CustomerProductVO updateProductforCustomer(int customerId, int productId);

}
