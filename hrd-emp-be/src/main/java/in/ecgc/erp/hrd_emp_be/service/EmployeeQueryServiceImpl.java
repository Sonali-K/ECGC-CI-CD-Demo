package in.ecgc.erp.hrd_emp_be.service;

import java.sql.Timestamp;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import in.ecgc.erp.hrd_emp_be.dto.ResponseDto;
import in.ecgc.erp.hrd_emp_be.message.Messages;
import in.ecgc.erp.hrd_emp_be.model.Employee;
import in.ecgc.erp.hrd_emp_be.repository.IEmployeeDao;



/**
 * Employee Service implementation
 *  
 * @version 1.0 31-March-20
 * @Author Architecture Team C-DAC Mumbai
 */
@Service
public class EmployeeQueryServiceImpl implements IEmployeeQueryService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeQueryServiceImpl.class);

	Timestamp timestamp = new Timestamp(System.currentTimeMillis());
	
	@Autowired(required = true)
	private IEmployeeDao dao;
	
	@Autowired
	private Messages message;
	
	public IEmployeeDao getDao() {
		return dao;
	}

	public void setDao(IEmployeeDao dao) {
		this.dao = dao;
	}

	@Override
	public ResponseDto getAllEmployees() {
		try {
		List<Employee> employee=getDao().allEmployeeData();	
		 return new ResponseDto(true, 
				 				employee, 
				 				message.get("emp.get.success"), 
				 				HttpStatus.OK.value(), 
				 				null,
				 				timestamp);
		}catch (Exception e){
		LOGGER.error(e.getMessage());
		LOGGER.error(message.getStastusCode("emp.get.fail.id"));
		return new ResponseDto(false, 
								null, 
								message.get("emp.get.fail"), 
								HttpStatus.ACCEPTED.value(),
								null,
								timestamp);
		}
	}
}
