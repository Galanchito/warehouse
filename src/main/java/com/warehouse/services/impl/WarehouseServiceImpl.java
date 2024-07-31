package com.warehouse.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.warehouse.domain.WarehouseDto;
import com.warehouse.exception.ResourceConflictException;
import com.warehouse.exception.ResourceNotFoundException;
import com.warehouse.mapper.WarehouseMapper;
import com.warehouse.model.Warehouse;
import com.warehouse.repository.WarehouseRepository;
import com.warehouse.services.WarehouseService;
import com.warehouse.services.util.Validations;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class WarehouseServiceImpl implements WarehouseService{

	@Autowired
	private WarehouseRepository warehouseRepository;
	
	@Autowired
	private WarehouseMapper warehouseMapper;
	
	@Override
	@Transactional
	public String createWarehouse(WarehouseDto warehouseDto) {
		
		log.debug("Creating new warehouse");
		
		Optional<Warehouse> optWarehouse = warehouseRepository.findById(warehouseDto.getId());
		
		if (optWarehouse.isPresent()) {
			throw new ResourceConflictException("Warehouse already exists ", warehouseDto.getId());
		}
		
		Warehouse toSave = warehouseMapper.toModel(warehouseDto);
		
		Validations.validateRacksSize(warehouseDto);
		
		warehouseDto.getRacks().forEach(rack -> {
			Validations.validateWarehouseFamilyRackType(rack, toSave );
		});
		
		toSave.getRacks().addAll(warehouseMapper.toModel(warehouseDto.getRacks(), toSave));

		return warehouseRepository.save(toSave).getUuid();
	}

	@Override
	public Set<WarehouseDto> getWarehouses() {
		
		log.debug("Getting all warehouses");
		
		List<Warehouse> warehouseEntityList = warehouseRepository.findAll();
		
		return warehouseMapper.convertToWarehouseDtoList(warehouseEntityList);
		
	}

	@Override
	public WarehouseDto getWarehouseById(String warehouseId) {
		
		log.debug("Getting warehouse with id {}", warehouseId);
		
		Warehouse warehouseEntity = warehouseRepository.findById(warehouseId).orElseThrow(() -> new ResourceNotFoundException("Warehouse not found", warehouseId));

		return warehouseMapper.convertToWarehouseDto(warehouseEntity);
	}

	@Override
	@Transactional
	public void updateWarehouse(String warehouseId, WarehouseDto warehouseDto) {
		
		log.debug("Updating warehouse ", warehouseId);

		Warehouse warehouseToUpdate = warehouseRepository.findById(warehouseId).orElseThrow(() -> new ResourceNotFoundException("Warehouse not found", warehouseId));

		warehouseToUpdate = warehouseMapper.updateWarehouse(warehouseToUpdate, warehouseDto);

		warehouseToUpdate.getRacks().clear();
		warehouseToUpdate.getRacks().addAll(warehouseMapper.toModel(warehouseDto.getRacks(), warehouseToUpdate));
		
		warehouseRepository.save(warehouseToUpdate);
	}

	@Override
	@Transactional
	public void deleteWarehouseById(String warehouseId) {
		
		log.debug("Deleting warehouse by id");
		
		Optional<Warehouse> optWarehouse = warehouseRepository.findById(warehouseId);
		
		if (!optWarehouse.isPresent()) {
			throw new ResourceNotFoundException("Warehouse not found", warehouseId);
		}

		warehouseRepository.delete(optWarehouse.get());
	}

}
