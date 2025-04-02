package com.valtech.hackathon.userservice.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.valtech.hackathon.userservice.services.VehicleService;
import com.valtech.hackathon.userservice.vos.VehicleVO;

@RestController
@RequestMapping("/api/v1/vehicles")
public class VehicleController {

	@Autowired
	private VehicleService vehicleService;
	
	@GetMapping("{id}")
	public VehicleVO getVehicleById(@PathVariable("id") int id) {
		return vehicleService.getVehicle(id);
	}
	
	@GetMapping("/")
	public List<VehicleVO> getAllVehicles(){
		return vehicleService.getAllVehicles();
	}
	
	@GetMapping("/ofUser/{userId}")
	public List<VehicleVO> getVehiclesByUserId(@PathVariable("userId") int userId){
		return vehicleService.getVehiclesByUserId(userId);
	}
	
	@GetMapping("/fuelType/{fuelType}")
	public List<VehicleVO> getVehiclesByFuelType(@PathVariable("fuelType") String fuelType){
		return vehicleService.getVehiclesByFuelType(fuelType);
	}
}
