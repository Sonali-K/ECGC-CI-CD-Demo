package in.ecgc.erp.hrd_emp_be.controller;


import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.slf4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.ecgc.erp.hrd_emp_be.dto.ResponseDto;
import in.ecgc.erp.hrd_emp_be.model.*;
import in.ecgc.erp.hrd_emp_be.service.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;


/**
 *Employee Command Rest Controller class
 *
 *@version 1.1 30-April-20
 *@Author Architecture Team C-DAC Mumbai
 **/
@Api(value = "Employee Command Rest Controller", 
     description = "Operations pertaining to employee in Employee Management System")//Swagger annotation
@RestController
@RequestMapping("/api")
public class EmployeeCommandRestController {

	private static final Logger LOGGER=LoggerFactory.getLogger(EmployeeCommandRestController.class);
	
	@Autowired
	private IEmployeeCommandService empService;
	/**
	   * Save Employee Data into Employee Master
	   * 
	   * @param employee   Employee employee-object
	   * @return result    ResponseDto object
	*/
	@ApiOperation(value = "Save an employee")						//Swagger Annotation 
	@PostMapping("/employee")
	public ResponseDto saveEmployeeData(@RequestBody Employee employee,Locale locale, Model model) {
		LOGGER.info("--Save Employee Data--");
		ResponseDto result = empService.addEmployee(employee);
	    return result;
	}
	
    /**
     * Delete Employee with particular ID
     *
     * @param EmpID			Employee Employee Id
     * @return				ResponseDto object
     */
    @ApiOperation(value = "Delete an employee")								//Swagger Annotation
	@DeleteMapping("/employee/{id}")
	public ResponseDto deleteEmployee(@ApiParam(value = "Employee Id from which employee object will delete from database table", required = true)
	                          @PathVariable("id") String empId){
		LOGGER.info("--Deleting Employee Data--");
        System.out.println(empId);
        ResponseDto result=empService.deleteEmployee(empId);
		System.out.println(result);
		return result;
	}
	
    //Note Swagger Annotation @Api, @ApiOperation ,@ApiParam etc.
}
