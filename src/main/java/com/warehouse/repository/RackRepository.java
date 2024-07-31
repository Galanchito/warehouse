package com.warehouse.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.warehouse.model.Rack;



@Repository
public interface RackRepository extends JpaRepository<Rack, String>{

	List<Rack> findByWarehouseId(Integer warehouseId);
	
	Optional<Rack> findById(Integer warehouseId);

}
