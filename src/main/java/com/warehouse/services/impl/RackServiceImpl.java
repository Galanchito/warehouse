package com.warehouse.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.warehouse.domain.RackDto;
import com.warehouse.exception.ResourceNotFoundException;
import com.warehouse.mapper.RackMapper;
import com.warehouse.model.Rack;
import com.warehouse.model.Warehouse;
import com.warehouse.repository.RackRepository;
import com.warehouse.repository.WarehouseRepository;
import com.warehouse.services.RackService;
import com.warehouse.services.util.Validations;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class RackServiceImpl implements RackService{
	
	@Autowired
	private WarehouseRepository warehouseRepository;
	
	@Autowired
	private RackRepository rackRepository;
	
	@Autowired
	private RackMapper rackMapper;
	
	@Override
	@Transactional
	public String createRackByIdWarehouse(RackDto rackDto, String warehouseId) {
		
		log.debug("Creating new rack");
		
		Warehouse warehouse = warehouseRepository.findById(warehouseId).orElseThrow(() -> new ResourceNotFoundException("Warehouse not found", warehouseId));

		Validations.validateRacksSize(warehouse);
		
		Validations.validateWarehouseFamilyRackType(rackDto, warehouse);
				
		warehouse.getRacks().add(rackMapper.convertToRackEntity(warehouse,rackDto));
		
		return warehouseRepository.save(warehouse).getUuid();
	}

	@Override
	public Set<RackDto> getRacksByWarehouseId(Integer warehouseId) {

		log.debug("Getting all racks by warehouse", warehouseId);
		
		List<Rack> rackEntityList = rackRepository.findByWarehouseId(warehouseId);
		
		return rackMapper.convertToRackDtoList(rackEntityList);
	}

	@Override
	public RackDto getRackById(Integer rackId) {

		log.debug("Getting rack with id {}", rackId);
		
		Rack rackEntity = rackRepository.findById(rackId).orElseThrow(() -> new ResourceNotFoundException("Rack not found", rackId));

		return rackMapper.convertToRackDto(rackEntity);
	}

	@Override
	public void deleteRackById(Integer rackId) {
		
		log.debug("Deleting rack by id");
		
		Optional<Rack> optRack = rackRepository.findById(rackId);
		
		if (!optRack.isPresent()) {
			throw new ResourceNotFoundException("Rack not found", rackId);
		}

		rackRepository.delete(optRack.get());
	}
}
