package com.root;

import java.util.Iterator;
import java.util.List;
import com.modal.Customer;
import com.service.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class CustomerController {
	@Autowired
	CustomerService customerService;
	
	@RequestMapping(value = "/getAllCustomers", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<Customer> getAllCustomers(Model model) {
		List<Customer> listOfCustomers = customerService.getAllCustomers();
		model.addAttribute("customer", new Customer());
		model.addAttribute("listOfCustomers", listOfCustomers);
		for(Iterator<Customer> itr=listOfCustomers.iterator();itr.hasNext();) {
			Customer customer=itr.next();
		System.out.println(customer.getEmail());
		}
		return listOfCustomers;
	}

	@RequestMapping(value = "/getCustomer/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public void getCustomerById(@PathVariable int id) {
		customerService.getCustomer(id);
	}
	
	@RequestMapping(value = "/addCustomer", method = RequestMethod.POST, headers = "Accept=application/json")
	public Customer addCustomer(@RequestBody Customer customer) {
		return customerService.addCustomer(customer);
	}
	
	@RequestMapping(value = "/addCustomer", method = RequestMethod.PUT, headers = "Accept=application/json")
	public Customer updateCustomer(@RequestBody Customer customer) {
		return customerService.updateCustomer(customer); 
	}
	
	/*
	 * @RequestMapping(value = "/deleteCustomer/{id}", method =
	 * RequestMethod.DELETE, headers = "Accept=application/json") public void
	 * deleteCustomer(@PathVariable("id") int id) {
	 * customerService.deleteCustomer(id); }
	 */	
}

