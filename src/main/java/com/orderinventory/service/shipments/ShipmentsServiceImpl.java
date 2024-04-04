package com.orderinventory.service.shipments;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.orderinventory.dao.shipments.ShipmentsRepository;
import com.orderinventory.exception.DuplicateShipmentsIDException;
import com.orderinventory.exception.ShipmentsNotFoundException;
import com.orderinventory.model.shipments.Shipments;

import jakarta.transaction.Transactional;

public class ShipmentsServiceImpl implements ShipmentsService{
	
	@Autowired
	private ShipmentsRepository shipmentsDao;

	@Override
	public List<Shipments> getAllShipments() {
		return shipmentsDao.findAll();
	}
	
	@Transactional
	@Override
	public int addShipments(Shipments shipments) throws DuplicateShipmentsIDException {
		Optional <Shipments> shipmt=shipmentsDao.findById(shipments.getShipmentId());
		if(shipmt.isPresent()) {			
			throw new DuplicateShipmentsIDException("Shipments with ID"+shipments.getShipmentId()+" already Exists");
		}
		shipmentsDao.save(shipments);
		return shipments.getShipmentId();
	}

	@Transactional
	@Override
	public Shipments findShipmentsById(int shipmentId) throws ShipmentsNotFoundException {
		Optional <Shipments> shipmt=shipmentsDao.findById(shipmentId);
		if(!shipmt.isPresent()) {
			throw new ShipmentsNotFoundException("An internal server error occured while fetching Shipments.");
		}
		return shipmt.get();
	}

	@Transactional
	@Override
	public Shipments updateShipments(Shipments shipments) {
		Optional<Shipments> previousShipments= shipmentsDao.findById(shipments.getShipmentId());
		Shipments shipmentupdated=previousShipments.get();
		shipmentupdated.setShipmentId(shipments.getShipmentId()); 
		return shipmentupdated;
	}

	@Transactional
	@Override
	public void deleteShipmentsById(int ShipmentId) {
		shipmentsDao.deleteById(ShipmentId);
		
	}

}
