package com.warehouse.domain;

import javax.validation.constraints.NotNull;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.AccessMode;
import lombok.Data;

@Data
public class RackDto {
	
	@Schema(accessMode = AccessMode.READ_ONLY , example = "362ch660-2ag7-3478-8d83-dr758d5d6474")
	private String rackId;
	
	@NotNull(message = "id cannot be null")
	@Schema(example = "122344")
	private Integer id;

	@Schema(accessMode = AccessMode.READ_ONLY , example = "733cc110-2af1-4229-8d83-cd788d5d6292")
	private String warehouseId;
	
	@NotNull(message = "Rack type cannot be null")
	private RackTypeEnum type;
	
}
