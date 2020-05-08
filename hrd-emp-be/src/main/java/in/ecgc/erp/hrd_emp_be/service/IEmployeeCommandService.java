package in.ecgc.erp.hrd_emp_be.service;




import in.ecgc.erp.hrd_emp_be.dto.ResponseDto;
import in.ecgc.erp.hrd_emp_be.model.Employee;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


/**
 * Employee Service interface
 * @version 1.1 30-April-20
 * @Author Architecture Team C-DAC Mumbai
 */

@EnableSwagger2
public interface IEmployeeCommandService {
	
	/**
	   * Add new Employee to the Employee Master.
	   *
	   * @param employee      Employee employee
	   * @return result       which is boolean value
	*/	
	public ResponseDto addEmployee(Employee employee);
	
	/**
	   * Delete particular Employee 
	   * 
	   * @param emp_id  Employee empId
	   * @return result 1 for true 0 for false
	*/
	public ResponseDto deleteEmployee(String emp_id);
}
