package com.orderinventory.service.order_items;

import java.util.List;

import com.orderinventory.exception.DuplicateOrderItemsIDException;
import com.orderinventory.exception.OrderItemsNotFoundException;
import com.orderinventory.model.order_items.OrderItems;


public interface OrderItemsService {
	
	List<OrderItems> getAllOrderItems();
	
	int addOrderItems(OrderItems orderItems) throws DuplicateOrderItemsIDException;
    
	OrderItems findOrderItemsById(int orderItemsId) throws OrderItemsNotFoundException;
	
	OrderItems updateOrderItems(OrderItems orderItems);
    
    void deleteOrderItemsById(int OrderItemsId);

}
