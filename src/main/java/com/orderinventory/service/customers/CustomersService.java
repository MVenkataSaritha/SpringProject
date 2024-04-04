package com.orderinventory.service.customers;

import java.util.List;
import com.orderinventory.exception.CustomersNotFoundException;
import com.orderinventory.exception.DuplicateCustomerIDException;
import com.orderinventory.model.customers.Customers;

public interface CustomersService {
	
	List<Customers> getAllCustomers();
	
    int addCustomers(Customers c) throws DuplicateCustomerIDException;
    
    Customers findCustomersById(int custId) throws CustomersNotFoundException;
    
    Customers findByFullName(String fullName) throws CustomersNotFoundException;
    
    void deleteCustomerById(int custId);
    

}
