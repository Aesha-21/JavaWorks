package com.valtech.hackathon.userservice.services;

import java.util.List;

import com.valtech.hackathon.userservice.vos.VehicleVO;

public interface VehicleService {

	VehicleVO saveVehicle(VehicleVO vvo);

	VehicleVO getVehicle(int id);

	List<VehicleVO> getAllVehicles();

	void deleteVehicle(VehicleVO vvo);

	List<VehicleVO> getVehiclesByUserId(int userId);


	VehicleVO addVehicleByUserId(VehicleVO vvo, int userId);

	List<VehicleVO> getVehiclesByFuelType(String fuelType);

//	List<VehicleVO> getVehiclesThatHaveFeatures();

	VehicleVO addFeatureByVehicleId(int vehicleId, int featureId);

}