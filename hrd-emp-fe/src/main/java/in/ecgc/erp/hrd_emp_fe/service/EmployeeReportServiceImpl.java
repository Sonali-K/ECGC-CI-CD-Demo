package in.ecgc.erp.hrd_emp_fe.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collection;
import java.util.HashMap;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import in.ecgc.erp.hrd_emp_fe.dto.ResponseDto;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

/**
 *Report Service Implementation 
 *used for calling BE Microservice
 *
 *@version 1.1 30-April-20
 *@Author Architecture Team C-DAC Mumbai
 *
 **/
@Service
public class EmployeeReportServiceImpl implements IEmployeeReportService {
	
	@Autowired
	IEmployeeClient empClient;
	
	@Override
	public JasperPrint exportReport() throws FileNotFoundException,JRException {
		ResponseDto employeeData=empClient.getAllEmployees();
		File file=ResourceUtils.getFile("classpath:employeeReport.jrxml");
		JasperReport jasperReport=JasperCompileManager.compileReport(file.getAbsolutePath());
		JRBeanCollectionDataSource dataSource=new JRBeanCollectionDataSource((Collection<?>) employeeData.getData());
		Map<String,Object> parameters=new HashMap<>();
		parameters.put("createdBy", "cdac");
		JasperPrint jasperPrint=JasperFillManager.fillReport(jasperReport,parameters,dataSource);
		
		return jasperPrint;
	}
	
	
	
	
}
