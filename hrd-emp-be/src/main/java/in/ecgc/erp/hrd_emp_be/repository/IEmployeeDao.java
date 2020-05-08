package in.ecgc.erp.hrd_emp_be.repository;

import java.util.List;

import in.ecgc.erp.hrd_emp_be.model.Employee;

/**
 * Employee Repository interface
 * @version 1.1 30-April-20
 * @Author Architecture Team C-DAC Mumbai
 */
public interface IEmployeeDao {

	/* Method for saving Employee Data */
	public int saveEmployeeData(Employee employee);
	
	/* Method for Fetching All Employee Data */
	public List<Employee> allEmployeeData();
	
	/* Method for delete particular Employee By Emp_ID */
	public int deleteEmployee(String emp_id);
}
