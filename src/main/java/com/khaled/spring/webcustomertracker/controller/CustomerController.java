package com.khaled.spring.webcustomertracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.khaled.spring.webcustomertracker.entity.Customer;
import com.khaled.spring.webcustomertracker.service.CustomerService;

@Controller
@RequestMapping({ "/customer" })
public class CustomerController {

	@Autowired
	private CustomerService customerserv;

	@GetMapping("/list")
	public String listCustomer(Model theModel) {
		List<Customer> theCustomers = customerserv.getCustomers();

		theModel.addAttribute("customers", theCustomers);
		return "list-customers";
	}

	@GetMapping("/showFormForAdd")
	public String addCustomer(Model theModel) {
		// create model attribute to bind form data
		Customer theCustomer = new Customer();

		theModel.addAttribute("customer", theCustomer);
		return "customer-form";
	}

	@GetMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer theCustomer) {
		customerserv.saveCustomer(theCustomer);

		return "redirect:/customer/list";
	}

	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId") int theId, Model theModel) {
		Customer customer = customerserv.getCustomer(theId);

		theModel.addAttribute("customer", customer);

		return "customer-form";
	}

	@GetMapping("/deleteCustomer")
	public String deleteCustomer(@RequestParam("customerId") int theId) {
		customerserv.deleteCustomer(theId);

		return "redirect:/customer/list";
	}
}
