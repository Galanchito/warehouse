package com.warehouse.controller;

import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.warehouse.domain.WarehouseDto;
import com.warehouse.services.WarehouseService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/warehouses")
public class WarehouseController {

	@Autowired
	private WarehouseService warehouseService;
	
	@Operation(summary = "Create new warehouse", operationId = "createWarehouse", description = "Create new warehouse", tags = {
			"Warehouse Management Api", })
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successful operation"),
			@ApiResponse(responseCode = "400", description = "Bad request"),
			@ApiResponse(responseCode = "401", description = "Unauthorized"),
			@ApiResponse(responseCode = "403", description = "Forbidden"),
			@ApiResponse(responseCode = "404", description = "Resource not found"),
			@ApiResponse(responseCode = "500", description = "Internal Server Error") })
	@PostMapping(value = "/v1/warehouse", consumes = { "application/json" })
	@ResponseStatus(code = HttpStatus.CREATED)
	public String createWarehouse(@Valid @RequestBody WarehouseDto newWarehouse) {
		return warehouseService.createWarehouse(newWarehouse);
	}
	
	@Operation(summary = "Get all warehouses", operationId = "getWarehouses", description = "Get all info of all Warehouses", tags = {
			"Warehouse Management Api", })
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successful operation"),
			@ApiResponse(responseCode = "400", description = "Bad request"),
			@ApiResponse(responseCode = "401", description = "Unauthorized"),
			@ApiResponse(responseCode = "403", description = "Forbidden"),
			@ApiResponse(responseCode = "404", description = "Resource not found"),
			@ApiResponse(responseCode = "500", description = "Internal Server Error") })
	@GetMapping(value = "/v1/warehouses")
	public Set<WarehouseDto> getWarehouses() {
		return warehouseService.getWarehouses();
	}
	
	@Operation(summary = "Get warehouse by id", operationId = "getWarehouseById", description = "Get all info of any warehouse by ID", tags = {
			"Warehouse Management Api", })
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successful operation"),
			@ApiResponse(responseCode = "400", description = "Bad request"),
			@ApiResponse(responseCode = "401", description = "Unauthorized"),
			@ApiResponse(responseCode = "403", description = "Forbidden"),
			@ApiResponse(responseCode = "404", description = "Resource not found"),
			@ApiResponse(responseCode = "500", description = "Internal Server Error") })
	@GetMapping(value = "/v1/warehouses/{warehouseId}")
	public WarehouseDto getWarehouseById(
			@Parameter(description = "The ID of the warehouse", required = true) @PathVariable("warehouseId") String warehouseId) {
		return warehouseService.getWarehouseById(warehouseId);
	}
	
	@Operation(summary = "Update warehouse", operationId = "updateWarehouse", description = "Update all info of warehouse", tags = {
			"Warehouse Management Api", })
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successful operation"),
			@ApiResponse(responseCode = "400", description = "Bad request"),
			@ApiResponse(responseCode = "401", description = "Unauthorized"),
			@ApiResponse(responseCode = "403", description = "Forbidden"),
			@ApiResponse(responseCode = "404", description = "Resource not found"),
			@ApiResponse(responseCode = "500", description = "Internal Server Error") })
	@PutMapping(value = "/v1/warehouses/{warehouseId}", consumes = { "application/json" })
	public void updateWarehouse(
			@Parameter(description = "The ID of the warehouse", required = true) @PathVariable("warehouseId") String warehouseId,
			@Parameter(description = "") @Valid @RequestBody(required = true) WarehouseDto warehouseDto) {
		warehouseService.updateWarehouse(warehouseId, warehouseDto);
	}
	
	@Operation(summary = "Delete any warehouse", operationId = "delete Warehouse", description = "Delete any warehouse by ID", tags = {
			"Warehouse Management Api", })
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successful operation"),
			@ApiResponse(responseCode = "400", description = "Bad request"),
			@ApiResponse(responseCode = "401", description = "Unauthorized"),
			@ApiResponse(responseCode = "403", description = "Forbidden"),
			@ApiResponse(responseCode = "404", description = "Resource not found"),
			@ApiResponse(responseCode = "500", description = "Internal Server Error") })
	@DeleteMapping(value = "/v1/warehouses/{warehouseId}")
	public void deleteWarehouseById(
			@Parameter(description = "The ID of the warehouse", required = true) @PathVariable("warehouseId") String warehouseId) {
		warehouseService.deleteWarehouseById(warehouseId);
	}
		
}
