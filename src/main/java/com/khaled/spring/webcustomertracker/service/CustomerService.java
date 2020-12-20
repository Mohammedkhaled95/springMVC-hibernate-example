package com.khaled.spring.webcustomertracker.service;

import java.util.List;

import com.khaled.spring.webcustomertracker.entity.Customer;

public interface CustomerService {
	
	
	public List<Customer> getCustomers();
	void saveCustomer(Customer theCustomer);
	public Customer getCustomer(int theId);
	public Customer deleteCustomer(int theId);

}
