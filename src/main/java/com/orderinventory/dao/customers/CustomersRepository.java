package com.orderinventory.dao.customers;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.orderinventory.model.customers.Customers;

@Repository
public interface CustomersRepository extends JpaRepository<Customers,Integer>{

	List<Customers> findByFullName(String fullName);
	
	// List<Customers> findByFullName(String fullname);

}
