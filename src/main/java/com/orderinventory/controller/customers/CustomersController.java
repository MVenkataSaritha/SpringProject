package com.orderinventory.controller.customers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.orderinventory.exception.CustomersListNotFoundException;
import com.orderinventory.exception.CustomersNotFoundException;
import com.orderinventory.exception.DuplicateCustomerIDException;
import com.orderinventory.exception.InvalidCustomerIDException;
import com.orderinventory.model.customers.Customers;
import com.orderinventory.service.customers.CustomersService;

import jakarta.validation.Valid;

@ComponentScan
@RestController
@RequestMapping(value="/customers")
public class CustomersController {
	
	@Autowired
	CustomersService customersServ;
	
	@GetMapping(produces="application/json")
	List<Customers> getAllCustomers(){
		System.out.println("Get the Customers");
		List<Customers> customers=customersServ.getAllCustomers();
		return customers;
	}
	
	@PostMapping(consumes="application/json",produces="application/json")
	public ResponseEntity<Customers> addCustomers (@Valid @RequestBody Customers cust) 
		
		throws DuplicateCustomerIDException,InvalidCustomerIDException{
			if(cust.getCustomerId()<0) {
				throw new InvalidCustomerIDException("Customer ID is invalid");
			}
			int custId=customersServ.addCustomers(cust);
			if(custId==0) {
				throw new DuplicateCustomerIDException("Customer with id "+cust.getCustomerId()+" already exists");
			}
		
		System.out.println("Customer added");
		return ResponseEntity.ok(cust);
	}
	
	@GetMapping(value="/{customerId}",produces="application/json")
	public ResponseEntity<Object> findCustomersById(@PathVariable("customerId") int custId) throws CustomersNotFoundException{
		Customers customer=customersServ.findCustomersById(custId);
		return new ResponseEntity<> (customer, HttpStatus.OK);
	}
	@GetMapping(value="/{fullName}",produces="application/json")
	public ResponseEntity<Object> findByFullName(@PathVariable("fullName") String fullName)throws CustomersNotFoundException{
		Customers customer=customersServ.findByFullName(fullName);
		return new ResponseEntity<> (customer, HttpStatus.OK);
	}
	
}
