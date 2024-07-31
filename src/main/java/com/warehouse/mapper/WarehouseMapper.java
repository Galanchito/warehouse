package com.warehouse.mapper;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.warehouse.domain.RackDto;
import com.warehouse.domain.WarehouseDto;
import com.warehouse.model.Rack;
import com.warehouse.model.Warehouse;

@Mapper
public interface WarehouseMapper {
	
	//to DTO
	
	public Set<WarehouseDto> convertToWarehouseDtoList(List<Warehouse> warehouseEntityList); 
	
	@Mapping(target = "warehouseId" , source = "uuid")
	public WarehouseDto convertToWarehouseDto(Warehouse warehouseEntity); 

	@Mapping(target = "warehouseId" , source = "warehouse.uuid")
	@Mapping(target = "rackId" , source = "rackEntity.uuid")
	public RackDto convertToRackDto(Rack rackEntity); 

	
	//To ENTITY
	
	@Mapping(target = "racks", ignore = true)
	public Warehouse toModel(WarehouseDto dto);
	
	public default Set<Rack> toModel(Set<RackDto> list, @Context Warehouse warehouse) {
		if (list == null) {
			return Collections.emptySet();
		}

		Set<Rack> set = new HashSet<>(Math.max((int) (list.size() / .75f) + 1, 16));
		for (RackDto rackDto : list) {
			set.add(toModel(rackDto, warehouse));
		}

		return set;
	}
	
	@Mapping(target = "id", source = "rackdto.id")
	@Mapping(target = "warehouse", source = "warehouse")
	public Rack toModel(RackDto rackdto, Warehouse warehouse);

	@Mapping(target = "racks", ignore = true)
	public Warehouse updateWarehouse(@MappingTarget Warehouse warehouseToUpdate, WarehouseDto warehouseDto);
}
