package com.khaled.spring.webcustomertracker.rest;

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

import com.khaled.spring.webcustomertracker.entity.Customer;
import com.khaled.spring.webcustomertracker.service.CustomerService;

@RestController
@RequestMapping("/api")
public class CustomerRestController {

	@Autowired
	CustomerService customerService;
	
	
	@GetMapping("/customers")
	public List<Customer>  getCustomers(){
		return customerService.getCustomers();
	}
	
	@GetMapping("/customers/{customerId}")
	public Customer getCustomer(@PathVariable int customerId){
		Customer c = customerService.getCustomer(customerId) ;
		if (c ==null ) {
			throw new CustomerNotFoundException("Customer with specified id not found id= "+customerId);
		}
		return customerService.getCustomer(customerId);
	}
	@PostMapping("/customers")
	public Customer addCustomer(@RequestBody Customer customer) {
	
		customerService.saveCustomer(customer);
		return customer;
	}
	
	
	@PutMapping("/customers")
	public Customer updateCustomer(@RequestBody Customer customer)  {
	if (customer.getId()<0) {
		throw new CustomerNotFoundException("what are you updating");
	}
		customerService.saveCustomer(customer);
		return customer;
	}
	
	
	@DeleteMapping("/customers/{customerId}")
	public String  deleteCustomer(@PathVariable int customerId){
		Customer c = customerService.getCustomer(customerId) ;
		if (c ==null ) {
			throw new CustomerNotFoundException("Customer with specified id not found id= "+customerId);
		}
		// return customerService.deleteCustomer(customerId);
		return"customer with id "+customerId+" deleted succefully";
	}	
	
	
	
	
	
	
	
	
	
	
	
}
