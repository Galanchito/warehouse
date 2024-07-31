package com.warehouse.controller;

import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.warehouse.domain.RackDto;
import com.warehouse.services.RackService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/racks")
public class RackController {

	@Autowired
	private RackService rackService;
	
	@Operation(summary = "Create new rack on a warehouse", operationId = "createRack", description = "Create new rack", tags = {
			"Rack Management Api", })
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successful operation"),
			@ApiResponse(responseCode = "400", description = "Bad request"),
			@ApiResponse(responseCode = "401", description = "Unauthorized"),
			@ApiResponse(responseCode = "403", description = "Forbidden"),
			@ApiResponse(responseCode = "404", description = "Resource not found"),
			@ApiResponse(responseCode = "500", description = "Internal Server Error") })
	@PostMapping(value = "/v1/{warehouseId}/rack", consumes = { "application/json" })
	@ResponseStatus(code = HttpStatus.CREATED)
	public String createRack(
			@Parameter(description = "The ID of the warehouse", required = true) @PathVariable("warehouseId") String warehouseId,
			@Valid @RequestBody RackDto rackDto) {
		return rackService.createRackByIdWarehouse(rackDto, warehouseId);
	}
	
	@Operation(summary = "Get all racks by warehouse Id ", operationId = "getRacksByWarehouseId", description = "Get all info of all racks by warehouse id", tags = {
			"Rack Management Api", })
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successful operation"),
			@ApiResponse(responseCode = "400", description = "Bad request"),
			@ApiResponse(responseCode = "401", description = "Unauthorized"),
			@ApiResponse(responseCode = "403", description = "Forbidden"),
			@ApiResponse(responseCode = "404", description = "Resource not found"),
			@ApiResponse(responseCode = "500", description = "Internal Server Error") })
	@GetMapping(value = "/v1/{warehouseId}/racks")
	public Set<RackDto> getRacksByWarehouseId(
			@Parameter(description = "The ID of the warehouse", required = true) @PathVariable("warehouseId") Integer warehouseId) {
		return rackService.getRacksByWarehouseId(warehouseId);
	}
	
	@Operation(summary = "Get rack by id", operationId = "getRackById", description = "Get all info of any rack by ID", tags = {
			"Rack Management Api", })
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successful operation"),
			@ApiResponse(responseCode = "400", description = "Bad request"),
			@ApiResponse(responseCode = "401", description = "Unauthorized"),
			@ApiResponse(responseCode = "403", description = "Forbidden"),
			@ApiResponse(responseCode = "404", description = "Resource not found"),
			@ApiResponse(responseCode = "500", description = "Internal Server Error") })
	@GetMapping(value = "/v1/rack/{rackId}")
	public RackDto getRackById(
			@Parameter(description = "The ID of the rack", required = true) @PathVariable("rackId") Integer rackId) {
		return rackService.getRackById(rackId);
	}
	
	@Operation(summary = "Delete any rack", operationId = "delete rack", description = "Delete any rack by ID", tags = {
			"Rack Management Api", })
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successful operation"),
			@ApiResponse(responseCode = "400", description = "Bad request"),
			@ApiResponse(responseCode = "401", description = "Unauthorized"),
			@ApiResponse(responseCode = "403", description = "Forbidden"),
			@ApiResponse(responseCode = "404", description = "Resource not found"),
			@ApiResponse(responseCode = "500", description = "Internal Server Error") })
	@DeleteMapping(value = "/v1/racks/{rackId}")
	public void deleteRackById(
			@Parameter(description = "The ID of the rack", required = true) @PathVariable("rackId") Integer rackId) {
		rackService.deleteRackById(rackId);
	}
		
}
