package in.ecgc.erp.hrd_emp_be.service;



import java.sql.Timestamp;

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
 * @version 1.1 31-March-20
 * @Author Architecture Team C-DAC Mumbai
 */
@Service
public class EmployeeCommandServiceImpl implements IEmployeeCommandService {

	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeCommandServiceImpl.class);
	
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
	public ResponseDto addEmployee(Employee employee) {
		LOGGER.info("--Save Service--");
		int result = getDao().saveEmployeeData(employee);
		if(result==1) {
		return new ResponseDto(true, 
								null, 
								message.get("emp.add.success"), 
								HttpStatus.CREATED.value(),
								null,
								timestamp);
		}
		LOGGER.error(message.getStastusCode("emp.add.fail.id"));
		return new ResponseDto(false, 
				null, 
				message.get("emp.add.fail"), 
				HttpStatus.NOT_ACCEPTABLE.value(),
				null,
				timestamp);
		
	}
	

	@Override
	public ResponseDto deleteEmployee(String emp_id) {
		LOGGER.info("--Delete Service--");
		int result =getDao().deleteEmployee(emp_id);
		if(result==1) {
		return new ResponseDto(true, 
				null, 
				message.get("emp.del.success"), 
				HttpStatus.ACCEPTED.value(),
				null,
				timestamp);
		}		
		LOGGER.error(message.getStastusCode("emp.add.fail.id"));
		return new ResponseDto(false, 
						null, 
						message.getStastusCode("emp.del.fail"), 
				      	HttpStatus.NOT_ACCEPTABLE.value(),
				      	null,
				      	timestamp);
		}

}
