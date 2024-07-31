package com.warehouse.services.util;

import com.warehouse.domain.RackDto;
import com.warehouse.domain.RackTypeEnum;
import com.warehouse.domain.WarehouseDto;
import com.warehouse.domain.WarehouseFamilyEnum;
import com.warehouse.exception.ResourceConflictException;
import com.warehouse.model.Warehouse;

public class Validations {
	
	public static void validateRacksSize(Warehouse warehouse) {
		if((warehouse.getSize() >= warehouse.getRacks().size())) {
			throw new ResourceConflictException("You couldnt create new rack because is fully");
		}	
	}
	
	public static void validateRacksSize(WarehouseDto warehouseDto) {
		if(warehouseDto != null && (warehouseDto.getSize() <= warehouseDto.getRacks().size())) {
			throw new ResourceConflictException("You couldnt create new rack because is fully");
			}	
	}

	public static void validateWarehouseFamilyRackType(RackDto rackDto, Warehouse warehouse) {
		if(WarehouseFamilyEnum.EST.equals(warehouse.getFamily())){
			if(RackTypeEnum.D.equals(rackDto.getType()) ) {
				throw new ResourceConflictException("You couldnt create rack type ", rackDto.getType().name());
			}
		}else if(WarehouseFamilyEnum.ROB.equals(warehouse.getFamily())) {
			if(RackTypeEnum.B.equals(rackDto.getType()) ) {
				throw new ResourceConflictException("You couldnt create rack type ", rackDto.getType().name());
			}
		}
	}

}
