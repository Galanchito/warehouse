package com.warehouse.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import com.warehouse.domain.RackTypeEnum;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@RequiredArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Rack extends BaseModel{
	
	@NonNull
	@NotNull
	@ManyToOne
	@JoinColumn(name = "warehouse_uuid")
	private Warehouse warehouse;
	
	@NotNull
	@NonNull
	private Integer id;

	@NonNull
	@NotNull
	@Enumerated(EnumType.STRING)
	private RackTypeEnum type;
	
	protected Rack() {
		// Constructor for JPA Default Empty
	}
}
