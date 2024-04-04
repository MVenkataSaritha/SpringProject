package com.orderinventory.service.shipments;

import java.util.List;

import com.orderinventory.exception.DuplicateShipmentsIDException;
import com.orderinventory.exception.ShipmentsNotFoundException;
import com.orderinventory.model.shipments.Shipments;

public interface ShipmentsService {
	
	List<Shipments> getAllShipments();
	
	int addShipments(Shipments shipments) throws DuplicateShipmentsIDException;
    
	Shipments findShipmentsById(int shipmentId) throws ShipmentsNotFoundException;
	
	Shipments updateShipments(Shipments shipments);
    
    void deleteShipmentsById(int ShipmentId);

}
