package com.orderinventory.controller.shipments;

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

import com.orderinventory.exception.DuplicateShipmentsIDException;
import com.orderinventory.exception.InvalidShipmentIDException;
import com.orderinventory.exception.ShipmentsNotFoundException;
import com.orderinventory.model.shipments.Shipments;
import com.orderinventory.service.shipments.ShipmentsService;

import jakarta.validation.Valid;

@ComponentScan
@RestController
@RequestMapping(value="/shipments")
public class ShipmentsController {
	
	@Autowired
	ShipmentsService shipmentsServ;
	
	@GetMapping(produces="application/json")
	List<Shipments> getAllShipments(){
		System.out.println("Get the Shipments");
		List<Shipments> shipments=shipmentsServ.getAllShipments();
		return shipments;
	}
	
	@PostMapping(consumes="application/json",produces="application/json")
	public ResponseEntity<Shipments> addShipments (@Valid @RequestBody Shipments shipments) 
		
		throws DuplicateShipmentsIDException,InvalidShipmentIDException{
			if(shipments.getShipmentId()<0) {
				throw new InvalidShipmentIDException("Shipment ID is invalid");
			}
			int shipmentId=shipmentsServ.addShipments(shipments);
			if(shipmentId==0) {
				throw new DuplicateShipmentsIDException("Shipments with id "+shipments.getShipmentId()+" already exists");
			}
		
		System.out.println("Shipment added");
		return ResponseEntity.ok(shipments);
	}
	
	@GetMapping(value="/{shipmentId}",produces="application/json")
	public ResponseEntity<Object> findOrderItemsById(@PathVariable("shipmentId") int orderItemsId) throws ShipmentsNotFoundException{
		Shipments shipments=shipmentsServ.findShipmentsById(orderItemsId);
		return new ResponseEntity<> (shipments, HttpStatus.OK);
	}
	
	@PutMapping(consumes = "application/json",produces = "application/json")
	ResponseEntity<Shipments> updateOrderItems(@Valid @RequestBody Shipments shipments){
		Shipments shipmts=shipmentsServ.updateShipments(shipments);
		System.out.println("Shipment ID in controller");		
		return new ResponseEntity<Shipments>(shipmts,HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/{shipmentsId}")
	ResponseEntity<Object> deleteOrderItems(@PathVariable("shipmentsId") Integer shipmentsId ) {
		shipmentsServ.deleteShipmentsById(shipmentsId);
		return new ResponseEntity<Object>("Order Items with "+shipmentsId+" is deleted",HttpStatus.OK);
	}

}
