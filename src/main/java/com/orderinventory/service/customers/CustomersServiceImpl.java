package com.orderinventory.service.customers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orderinventory.dao.customers.CustomersRepository;

import com.orderinventory.exception.CustomersNotFoundException;
import com.orderinventory.exception.DuplicateCustomerIDException;
import com.orderinventory.model.customers.Customers;

import jakarta.transaction.Transactional;


@Service
public class CustomersServiceImpl implements CustomersService{
	
	@Autowired
	private CustomersRepository customersDao;
	
	@Override
	public List<Customers> getAllCustomers(){
		
		return customersDao.findAll();	
	}
	
	@Transactional
	@Override
	public int addCustomers(Customers c) throws DuplicateCustomerIDException{
		Optional <Customers> cust=customersDao.findById(c.getCustomerId());
		if(cust.isPresent()) {			
			throw new DuplicateCustomerIDException("Customer with ID"+c.getCustomerId()+" already Exists");
		}
		customersDao.save(c);
		return c.getCustomerId();
	}

	@Override
	public Customers findCustomersById(int custId) throws CustomersNotFoundException {
		Optional <Customers> c=customersDao.findById(custId);
		if(!c.isPresent()) {
			throw new CustomersNotFoundException("An internal server error occured while fetching customers.");
		}
		return c.get();
	}

	@Override
	public Customers findByFullName(String fullName) throws CustomersNotFoundException {

		//Optional <Customers> c=customersDao.findByFullName(fullName);
		List<Customers> customers=customersDao.findByFullName(fullName);
		return customers.get(0);
	}

	@Override
	public void deleteCustomerById(int custId) {
		// TODO Auto-generated method stub
		
	}

//	@Override
//	public Customers findByFullName(String fullName) throws CustomersNotFoundException {
//		// TODO Auto-generated method stub
//		Optional <Customers> c=customersDao.findByFullName(fullName);
//		List<Customers> customers=customersDao.findByFullname(fullName);
//		return customers;
//	}

}
