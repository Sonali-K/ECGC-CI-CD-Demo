package in.ecgc.erp.hrd_emp_fe.controller;





import java.util.Locale;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.core.JsonProcessingException;




import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import in.ecgc.erp.hrd_emp_fe.dto.EmployeeInput;
import in.ecgc.erp.hrd_emp_fe.dto.ResponseDto;
import in.ecgc.erp.hrd_emp_fe.service.IEmployeeClient;





/**
 *Employee FE Controller class
 *
 *@version 1.1 30-April-20
 *@Author Architecture Team C-DAC Mumbai
 **/
@Controller
@RequestMapping("/")
public class HrdEmpFeController {
	
	private static final Logger LOGGER=LoggerFactory.getLogger(HrdEmpFeController.class);

	
	@Autowired
	private IEmployeeClient empClient;
	
	String err=null;

	@GetMapping(value= {"/","Dashboard"})
	public String dashboard() {
		LOGGER.info("--Dashboard--");
		return "dashboard";
	}
	 /**
     * Returns Employees
	 * @param <T>
     *
     * @param EmpID			Employee Employee Id
     * @param FirstName     Employee First Name
     * @param Designation	Employee Designation
     * @param Employee_type Employee Type
     * @return
	 * @throws JsonProcessingException 
     */
	@GetMapping(value = "/employees")
	public String getAllEmployees(Model model,Locale locale) {
		LOGGER.info("--All Employees--");
		ResponseDto emp=empClient.getAllEmployees();
		
		if(emp.isSuccess()&& emp.getData()!=null) {
			model.addAttribute("listEmployee",emp.getData());
			return "allEmployees";
		}
		model.addAttribute("listEmployee",null);
		return "allEmployees";
	}
	
	
	@GetMapping(value = "/employee/create")
	public String createEmployee(Locale locale, Model model) {		
		LOGGER.info("--Employee Creation--");
		model.addAttribute("employee", new EmployeeInput());
		return "employeeProfileCreation";
	}
	
	/**
	   * Save Employee Data into Employee Master
	   * @param employee   EmployeeInput employee-object
	   * @return 
	*/
	//@HystrixCommand(fallbackMethod = "fallback")
	@PostMapping(value = "/employee")
	public String saveEmployeeData(@ModelAttribute("employee") @Valid EmployeeInput employee,BindingResult errors, Locale locale,Model model){
		LOGGER.info("--Save Employee Credentail--");
		
		if(errors.hasErrors()) {
			model.addAttribute("employee", employee);
			return "employeeProfileCreation";
		}
		ResponseDto result=empClient.addEmployee(employee);
        
        if(result.isSuccess()) {
        	return "redirect:/employees";
        }else {
        	err=result.getMessage();
        	model.addAttribute("employee", employee);
    		model.addAttribute("err", err);
    		return "employeeProfileCreation";
        }
	}
	
	/**
	 * Method for delete employee
	 * @PathVariable empid
	 * @return integer
	 * */
	@GetMapping(value = "/employee/{id}")
	public String deleteEmployeeData(@PathVariable("id") String empId,Locale locale,Model model) {
		LOGGER.info("--Delete Employee Credentail--");
		LOGGER.info("Deleting Employee Data:{}"+ empId);

		ResponseDto result =empClient.deleteEmployee(empId);
		if(result.isSuccess()) {
			err="Successfully deleted";
			model.addAttribute("err", err);
			return "redirect:/employees";	
		}
		err="Failed to delete Employee";
		return "redirect:/hrd";
		
	}
	
	
	//Format for datatable
	@GetMapping("/datatable")
	public String datatables() {
		
		return "datatable";
	}

	//Format for Buttons
	@GetMapping("/buttons")
	public String buttons() {
		
		return "buttons";
	}
	//Format for Form Elements
	@GetMapping("/formelements")
	public String formelements() {
		
		return "formelements";
	}

	
	@GetMapping("/deatailedtable")
	public String detailtable() {
		
		return "deatailedtable";
	}

	//Format for Alerts
	@GetMapping("/alert")
	public String alert() {
		LOGGER.info("--Alert demo--");
		
		return "alert";
	}

	//Loader
	@GetMapping("/loader")
	public String loader() {
		LOGGER.info("--Loader demo--");
		return "loader";
	}
	
	@GetMapping("/userProfile")
	public String userProfile() {
		LOGGER.info("--User Profile demo--");
		return "userprofile";
	}
	
	//Fallback method
	public String fallback(@ModelAttribute("employee") @Valid EmployeeInput employee,BindingResult errors, Locale locale,Model model,Throwable throwable) {
		
		 
		 LOGGER.info("Backend Service exception:Fallback Method " + throwable);
		 return "redirect:/";	
	}
	
}














 
  
 