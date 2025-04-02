package com.valtech.training.leaveservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.valtech.training.leaveservice.services.LeaveService;
import com.valtech.training.leaveservice.vos.LeaveMasterVO;

@RestController
@RequestMapping("/api/v1/leaveMasters")
public class LeaveMasterController {

	@Autowired
	public LeaveService leaveService;
	
	
	
	@GetMapping("/{id}")
	public LeaveMasterVO getLeaveMaster(@PathVariable long empId) {
		return leaveService.getLeaveMaster(empId);
	}
	
	@GetMapping("/")
	public List<LeaveMasterVO> getAllLeaveMaster() {
		return leaveService.getAllLeaveMaster();
	}
	
	@PostMapping("/")
	public LeaveMasterVO saveOrUpdateLeaveMaster(@RequestBody LeaveMasterVO vo) {
		
		return leaveService.saveOrUpdateLeaveMaster(vo);
		
	}
}
