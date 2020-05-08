package in.ecgc.erp.hrd_emp_fe.service;

import java.io.FileNotFoundException;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperPrint;

/**
 *Report Service Interface
 *used for calling BE Microservice
 *
 *@version 1.1 30-April-20
 *@Author Architecture Team C-DAC Mumbai
 *
 **/
public interface IEmployeeReportService {
	
	//Method for convert object into JasperPrint
	JasperPrint exportReport() throws FileNotFoundException, JRException;

}
