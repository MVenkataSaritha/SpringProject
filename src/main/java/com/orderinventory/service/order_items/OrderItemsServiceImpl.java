package com.orderinventory.service.order_items;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orderinventory.dao.order_items.OrderItemsRepository;
import com.orderinventory.exception.DuplicateOrderItemsIDException;
import com.orderinventory.exception.OrderItemsNotFoundException;
import com.orderinventory.model.order_items.OrderItems;

import jakarta.transaction.Transactional;

@Service
public class OrderItemsServiceImpl implements OrderItemsService{
	
	@Autowired
	private OrderItemsRepository orderItemsDao;
	
	@Override
	public List<OrderItems> getAllOrderItems(){
		
		return orderItemsDao.findAll();	
	}
	
	@Transactional
	@Override
	public int addOrderItems(OrderItems ordItems) throws DuplicateOrderItemsIDException{
		Optional <OrderItems> orderItems=orderItemsDao.findById(ordItems.getOrderId());
		if(orderItems.isPresent()) {			
			throw new DuplicateOrderItemsIDException("Order Items with ID"+ordItems.getOrderId()+" already Exists");
		}
		orderItemsDao.save(ordItems);
		return ordItems.getOrderId();
	}
	
	@Transactional
	@Override
	public OrderItems findOrderItemsById(int orderItemsId) throws OrderItemsNotFoundException {
		Optional <OrderItems> ordItems=orderItemsDao.findById(orderItemsId);
		if(!ordItems.isPresent()) {
			throw new OrderItemsNotFoundException("An internal server error occured while fetching Order Items.");
		}
		return ordItems.get();
	}
	
	

	@Transactional
	@Override
	public void deleteOrderItemsById(int orderItemsId) {
		
		orderItemsDao.deleteById(orderItemsId);
		
	}
	
	@Transactional
	@Override
	public OrderItems updateOrderItems(OrderItems orderItems) {
		Optional<OrderItems> previouOrderItems= orderItemsDao.findById(orderItems.getOrderId());//Entity is in persistence state
		OrderItems orderItemupdated=previouOrderItems.get();
		orderItemupdated.setOrderId(orderItems.getOrderId()); 
		return orderItemupdated;
	}
	

}
