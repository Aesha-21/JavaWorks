package com.valtech.hackathon.userservice.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.valtech.hackathon.userservice.entities.Vehicle;
import com.valtech.hackathon.userservice.entities.Vehicle.VehicleType;

@Repository
public interface VehicleRepo extends JpaRepository<Vehicle, Integer>{

	List<Vehicle> findAllByOwnerId(int userId);

	List<Vehicle> findAllByType(VehicleType fuelType);

//	List<Vehicle> findByFeatureIdsIsNotEmpty();

//	List<Vehicle> findAllByVehicleType(String fuelType);

	
}
