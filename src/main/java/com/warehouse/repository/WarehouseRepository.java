package com.warehouse.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.warehouse.model.Warehouse;

@Repository
public interface WarehouseRepository extends JpaRepository<Warehouse, String>{

	Optional<Warehouse> findById(Integer name);
	
}