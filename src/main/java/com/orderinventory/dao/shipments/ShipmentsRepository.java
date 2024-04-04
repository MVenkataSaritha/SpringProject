package com.orderinventory.dao.shipments;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.orderinventory.model.shipments.Shipments;

@Repository
public interface ShipmentsRepository extends JpaRepository<Shipments,Integer>{

}
