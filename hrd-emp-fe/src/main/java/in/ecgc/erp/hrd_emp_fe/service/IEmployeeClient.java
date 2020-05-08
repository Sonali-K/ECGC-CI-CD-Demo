package in.ecgc.erp.hrd_emp_fe.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;

import in.ecgc.erp.hrd_emp_fe.dto.EmployeeInput;
import in.ecgc.erp.hrd_emp_fe.dto.ResponseDto;



/**
 *Employee client interface
 *used for calling BE Microservice
 *
 *@version 1.1 30-April-20
 *@Author Architecture Team C-DAC Mumbai
 *
 **/
@FeignClient(name = "hrd-emp-be",fallbackFactory = EmployeeClientFallback.class)
public interface IEmployeeClient {
	
	//Get all Employee Data : From BE Service	
	@GetMapping("/api/employees")
	public  ResponseDto getAllEmployees();

	//Save Employee Data :through BE Service
	@PostMapping("/api/employee")
	public ResponseDto addEmployee(EmployeeInput employee);
	
	//Delete Employee Data : through BE Service
	@DeleteMapping("/api/employee/{id}")
	public ResponseDto deleteEmployee(@PathVariable("id") String id);
}
