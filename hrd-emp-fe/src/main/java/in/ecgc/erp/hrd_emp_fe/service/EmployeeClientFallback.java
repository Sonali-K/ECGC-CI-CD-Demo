
package in.ecgc.erp.hrd_emp_fe.service;





import java.sql.Timestamp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import feign.hystrix.FallbackFactory;
import in.ecgc.erp.hrd_emp_fe.dto.EmployeeInput;
import in.ecgc.erp.hrd_emp_fe.dto.ResponseDto;

/**
 *Employee client fallback
 *
 *@version 1.1 30-April-20
 *@Author Architecture Team C-DAC Mumbai
 *
 **/
@Component
public class EmployeeClientFallback implements FallbackFactory<IEmployeeClient> {

	private static final Logger LOGGER=LoggerFactory.getLogger(EmployeeClientFallback.class);
	
	Timestamp timestamp = new Timestamp(System.currentTimeMillis());
	
	
		@Override 
		public IEmployeeClient create(Throwable cause) { 
			
		return new IEmployeeClient() {

			@Override 
			public ResponseDto addEmployee(EmployeeInput employee) {
				
				LOGGER.error("Service is Down Add Employee:- "
								   + cause);  
				
				return new ResponseDto(false, null, cause.getMessage(),500,cause.getLocalizedMessage(), timestamp);  
			}
	
			@Override 
			public ResponseDto deleteEmployee(String id) { 
				LOGGER.error("Service is Down Delete Employee:- "
						   + cause.getMessage()); 
				return new ResponseDto(false, null, cause.getMessage(),500,cause.getLocalizedMessage(),timestamp); 
			}

			@Override
			public  ResponseDto getAllEmployees() {
				LOGGER.error("Service is Down Fetching Employee:- "
						   + cause.getMessage()); 
				return new ResponseDto(false, null, cause.getMessage(),500,cause.getLocalizedMessage(),timestamp);
			}

		};

	}

}
