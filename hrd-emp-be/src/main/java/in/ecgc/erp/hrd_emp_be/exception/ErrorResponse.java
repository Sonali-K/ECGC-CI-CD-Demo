package in.ecgc.erp.hrd_emp_be.exception;



import java.sql.Timestamp;
import lombok.Data;
/**
 *Error Response class
 *
 *@version 1.1 30-April-20
 *@Author Architecture Team C-DAC Mumbai
 **/
//@Data
public class ErrorResponse 
{	
	private int code;
	private Timestamp timestamp;
	private String message;
	private String details;
	public ErrorResponse(int code, Timestamp timestamp, String message, String details) {
		super();
		this.code = code;
		this.timestamp = timestamp;
		this.message = message;
		this.details = details;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public Timestamp getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
}