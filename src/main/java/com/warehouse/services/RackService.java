package com.warehouse.services;

import java.util.Set;

import com.warehouse.domain.RackDto;

public interface RackService {

	String createRackByIdWarehouse(RackDto rackDto, String warehouseId);
	
	Set<RackDto> getRacksByWarehouseId(Integer warehouseId);

	RackDto getRackById(Integer rackId);
	
	void deleteRackById(Integer rackId);
}
