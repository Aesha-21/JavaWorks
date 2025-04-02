package com.valtech.hackathon.userservice.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.hackathon.userservice.entities.User;
import com.valtech.hackathon.userservice.entities.Vehicle;
import com.valtech.hackathon.userservice.entities.Vehicle.VehicleType;
import com.valtech.hackathon.userservice.repos.UserRepo;
import com.valtech.hackathon.userservice.repos.VehicleRepo;
import com.valtech.hackathon.userservice.vos.VehicleVO;



@Service
@Transactional(propagation = Propagation.REQUIRED)
public class VehicleServiceImpl implements VehicleService {

	@Autowired
	private VehicleRepo vehicleRepo;
	
	@Autowired
	private UserRepo userRepo;
	
	
	@Override
	public VehicleVO saveVehicle(VehicleVO vvo) {
		return VehicleVO.from(vehicleRepo.save(vvo.to()));
	}
	@Override
	public VehicleVO getVehicle(int id) {
		return VehicleVO.from(vehicleRepo.getReferenceById(id));
	}
	@Override
	public List<VehicleVO> getAllVehicles(){
		return VehicleVO.from(vehicleRepo.findAll());
	}
	@Override
	public void deleteVehicle(VehicleVO vvo) {
		vehicleRepo.delete(vvo.to());
	}
	@Override
	public List<VehicleVO> getVehiclesByUserId(int userId) {
		return VehicleVO.from(vehicleRepo.findAllByOwnerId(userId));
	}
	@Override
	public VehicleVO addVehicleByUserId(VehicleVO vvo,int userId) {
		User user = userRepo.getReferenceById(userId);
		Vehicle vehicle = vvo.to();
		vehicle.setOwner(user);
		return VehicleVO.from(vehicleRepo.save(vehicle));
	}
	@Override
	public List<VehicleVO> getVehiclesByFuelType(String fuelType) {
		return VehicleVO.from(vehicleRepo.findAllByType(VehicleType.valueOf(fuelType)));
	}
	
//	@Override
//	public List<VehicleVO> getVehiclesThatHaveFeatures(){
//		return VehicleVO.from(vehicleRepo.findByFeatureIdsIsNotEmpty());
//	}
	
	@Override
	public VehicleVO addFeatureByVehicleId(int vehicleId, int featureId) {
		Vehicle vehicle = vehicleRepo.getReferenceById(vehicleId);
		return VehicleVO.from(vehicle.addFeatureId(featureId));
	} 
}
