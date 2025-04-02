package com.valtech.hackathon.userservice.vos;

import java.util.List;
import java.util.stream.Collectors;

import com.valtech.hackathon.userservice.entities.User;
import com.valtech.hackathon.userservice.entities.Vehicle;
import com.valtech.hackathon.userservice.entities.Vehicle.VehicleType;

public record VehicleVO(int id,String vin, String manufacturer, String model, String type, User owner, int year, List<Integer> featureIds) {

	public static VehicleVO from(Vehicle vehicle) {
		return new VehicleVO(vehicle.getId(), vehicle.getVin(), vehicle.getManufacturer(), vehicle.getModel(), vehicle.getType().name(),vehicle.getOwner(), vehicle.getYear(),vehicle.getFeatureIds());
	}
	
	public static List<VehicleVO> from(List<Vehicle> vehicles){
		return vehicles.stream().map(veh -> VehicleVO.from(veh)).collect(Collectors.toList());
	}
	
	public Vehicle to() { 
		return new Vehicle(vin,manufacturer,model,VehicleType.valueOf(type),owner,year,featureIds);
	}
}
