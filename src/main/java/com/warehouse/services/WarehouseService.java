package com.warehouse.services;

import java.util.Set;

import javax.validation.Valid;

import com.warehouse.domain.WarehouseDto;

public interface WarehouseService {

	String createWarehouse(WarehouseDto newWarehouse);

	Set<WarehouseDto> getWarehouses();

	WarehouseDto getWarehouseById(String warehouseId);

	void updateWarehouse(String warehouseId, @Valid WarehouseDto warehouseDto);

	void deleteWarehouseById(String warehouseId);
	
}
