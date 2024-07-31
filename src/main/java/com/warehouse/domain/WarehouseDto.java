package com.warehouse.domain;

import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.AccessMode;
import lombok.Data;

@Data
public class WarehouseDto {
	
	@Schema(accessMode = AccessMode.READ_ONLY , example = "733cc110-2af1-4229-8d83-cd788d5d6292")
	private String warehouseId;
	
	@NotNull(message = "id cannot be null")
	@Schema(example = "5736724")
	private Integer id;

	@NotEmpty
	@NotNull(message = "Client cannot be null")
	@Size(max = 100, message = "client should not be greater than 250 characters")
	@Schema(example = "Amazon")	
	private String client;
	
	@NotNull(message = "Warehouse Family cannot be null")
	private WarehouseFamilyEnum family;
	
	@NotNull(message = "Size cannot be null")
	@Schema(example = "2")
	private Integer size;
	
	@NotNull
	private Set<RackDto> racks = new HashSet<>();
	
}
