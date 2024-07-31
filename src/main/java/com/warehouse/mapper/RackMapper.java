package com.warehouse.mapper;

import java.util.List;
import java.util.Set;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.warehouse.domain.RackDto;
import com.warehouse.model.Rack;
import com.warehouse.model.Warehouse;

@Mapper
public interface RackMapper {

	@Mapping(target = "warehouse" , source = "warehouse")
	@Mapping(target = "id" , source = "dto.id")
	public Rack convertToRackEntity(Warehouse warehouse, RackDto dto);

	public Set<RackDto> convertToRackDtoList(List<Rack> rackEntityList); 
	
	@Mapping(target = "rackId" , source = "id")
	@Mapping(target = "warehouseId" , source = "rackEntity.warehouse.id")
	public RackDto convertToRackDto(Rack rackEntity);
}
