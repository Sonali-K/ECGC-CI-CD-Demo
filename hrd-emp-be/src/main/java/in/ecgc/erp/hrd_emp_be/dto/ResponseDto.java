package in.ecgc.erp.hrd_emp_be.dto;

import java.sql.Timestamp;
import lombok.Data;
/**
 *Response DTO class
 *
 *@version 1.1 30-April-20
 *@Author Architecture Team C-DAC Mumbai
 **/
//@Data
public class ResponseDto {

	private boolean success;
	private Object data;
	private String message;
	private int code;
	private String details;
	private Timestamp timestamp;
	public ResponseDto(boolean success, Object data, String message, int code,String details, Timestamp timestamp) {
		super();
		this.success = success;
		this.data = data;
		this.message = message;
		this.code = code;
		this.details=details;
		this.timestamp = timestamp;
	}
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public Timestamp getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}
	
	
	
}
