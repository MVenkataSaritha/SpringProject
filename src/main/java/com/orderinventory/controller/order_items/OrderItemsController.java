package com.orderinventory.controller.order_items;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.orderinventory.exception.DuplicateOrderItemsIDException;
import com.orderinventory.exception.InvalidOrderItemsIDException;
import com.orderinventory.exception.OrderItemsNotFoundException;
import com.orderinventory.model.order_items.OrderItems;
import com.orderinventory.service.order_items.OrderItemsService;

import jakarta.validation.Valid;


@ComponentScan
@RestController
@RequestMapping(value="/orderItems")
public class OrderItemsController {
	
	@Autowired
	OrderItemsService orderItemsServ;
	
	@GetMapping(produces="application/json")
	List<OrderItems> getAllOrderItems(){
		System.out.println("Get the OrderItems");
		List<OrderItems> orderItems=orderItemsServ.getAllOrderItems();
		return orderItems;
	}
	
	@PostMapping(consumes="application/json",produces="application/json")
	public ResponseEntity<OrderItems> addOrderItems (@Valid @RequestBody OrderItems orderItems) 
		
		throws DuplicateOrderItemsIDException,InvalidOrderItemsIDException{
			if(orderItems.getOrderId()<0) {
				throw new InvalidOrderItemsIDException("Order Items ID is invalid");
			}
			int orderItemsId=orderItemsServ.addOrderItems(orderItems);
			if(orderItemsId==0) {
				throw new DuplicateOrderItemsIDException("Order Items with id "+orderItems.getOrderId()+" already exists");
			}
		
		System.out.println("Order Items added");
		return ResponseEntity.ok(orderItems);
	}
	
	@GetMapping(value="/{orderItemsId}",produces="application/json")
	public ResponseEntity<Object> findOrderItemsById(@PathVariable("orderItemsId") int orderItemsId) throws OrderItemsNotFoundException{
		OrderItems orderItems=orderItemsServ.findOrderItemsById(orderItemsId);
		return new ResponseEntity<> (orderItems, HttpStatus.OK);
	}
	
	@PutMapping(consumes = "application/json",produces = "application/json")
	ResponseEntity<OrderItems> updateOrderItems(@Valid @RequestBody OrderItems orderItems){
		OrderItems ordItems=orderItemsServ.updateOrderItems(orderItems);
		System.out.println("Order Items ID in controller");		
		return new ResponseEntity<OrderItems>(ordItems,HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/{orderItemsId}")
	ResponseEntity<Object> deleteOrderItems(@PathVariable("orderItemsId") Integer orderItemsId ) {
		orderItemsServ.deleteOrderItemsById(orderItemsId);
		return new ResponseEntity<Object>("Order Items with "+orderItemsId+" is deleted",HttpStatus.OK);
	}

}
