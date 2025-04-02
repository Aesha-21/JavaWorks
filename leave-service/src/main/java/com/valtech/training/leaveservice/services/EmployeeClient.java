package com.valtech.training.leaveservice.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.FeignClientProperties.FeignClientConfiguration;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import com.valtech.training.leaveservice.vos.EmployeeVO;

@FeignClient(name = "EMPLOYEE-SERVICE",configuration = FeignClientConfiguration.class)
public interface EmployeeClient {
	
	@GetMapping("/api/v1/employees/{id}")
	EmployeeVO getEmployeeAsManager(@PathVariable("id") long id);
	
}

//@Component
//public class EmployeeClient {
//
//	public long getManager(long empid) {
//		RestTemplate temp = new RestTemplate();
//		String url = "http://localhost:9010/api/v1/employees/"+empid;
//		EmployeeVO emp = temp.getForObject(url, EmployeeVO.class);
//		return emp.managerId();
//	}
//}
