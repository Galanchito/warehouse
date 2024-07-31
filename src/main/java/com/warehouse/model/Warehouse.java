package com.warehouse.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.warehouse.domain.WarehouseFamilyEnum;

import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Data
@Entity
@RequiredArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Warehouse extends BaseModel{
	
	@NonNull
	private Integer id;
	
	@NonNull
	@NotEmpty(message = "client is mandatory")
	@Size(max = 50, message = "client should not be greater than 50 characters")
	@Column(length = 50)
	private String client;
	
	@NonNull
	@NotNull
	@Enumerated(EnumType.STRING)
	private WarehouseFamilyEnum family;
	
	@NotNull
	@NonNull
	private Integer size;
	
	@OneToMany(mappedBy = "warehouse", cascade = CascadeType.ALL, orphanRemoval = true)
	@Setter(AccessLevel.NONE)
	private List<Rack> racks = new ArrayList<>();
	
	protected Warehouse() {
		// Constructor for JPA Default Empty
	}
}
