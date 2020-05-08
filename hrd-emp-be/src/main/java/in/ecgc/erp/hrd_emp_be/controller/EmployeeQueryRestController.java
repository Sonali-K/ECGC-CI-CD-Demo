package in.ecgc.erp.hrd_emp_be.controller;


import java.util.List;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import in.ecgc.erp.hrd_emp_be.dto.ResponseDto;
import in.ecgc.erp.hrd_emp_be.service.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


/**
 *Employee Controller class
 *
 *@version 1.1 30-April-20
 *@Author Architecture Team C-DAC Mumbai
 *
 **/
@Api(value = "Employee Query Controller", 
description = "Operations pertaining to employee in Employee Management System")//Swagger annotation
@RestController
@RequestMapping("/api")
public class EmployeeQueryRestController {

	private static final Logger LOGGER=LoggerFactory.getLogger(EmployeeQueryRestController.class);

	@Autowired
	private IEmployeeQueryService empService;
	

	
	

	/**
	 * Returns List of Employees
	 *
	 * @param EmpID			Employee Employee Id
	 * @param FirstName     Employee First Name
	 * @param Designation	Employee Designation
	 * @param Employee_type Employee Type
	 * @return
	 */
	@ApiOperation(value = "View a list of available employees", response = List.class)   	//Swagger Annotation
	@GetMapping("/employees")
	public ResponseDto getAllEmployees(){
		LOGGER.info("--Fetching Employee data--");
		ResponseDto employeeList=empService.getAllEmployees();
		System.out.println(employeeList);
		return employeeList; 
	}

	//Note Swagger Annotation @Api, @ApiOperation ,@ApiParam etc.
}
