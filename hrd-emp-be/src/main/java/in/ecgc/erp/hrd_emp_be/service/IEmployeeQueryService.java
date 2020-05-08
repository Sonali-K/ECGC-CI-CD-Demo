package in.ecgc.erp.hrd_emp_be.service;

import in.ecgc.erp.hrd_emp_be.dto.ResponseDto;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


/**
 * Employee Query Service interface
 * @version 1.1 30-April-20
 * @Author Architecture Team C-DAC Mumbai
 */

@EnableSwagger2
public interface IEmployeeQueryService {
	
	/**
	   * Request for fetch all Employees
	   * 
	   * @return A list of employees
	*/	
	public ResponseDto getAllEmployees();

//	ResponseDto getAllEmployees();
	
}
