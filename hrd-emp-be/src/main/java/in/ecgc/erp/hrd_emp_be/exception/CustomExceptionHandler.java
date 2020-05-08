package in.ecgc.erp.hrd_emp_be.exception;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/*
 *Custom Exception Handler Class
 *
 *@version 1.1 30-April-20
 *@Author Architecture Team C-DAC Mumbai
 *
 **/
@SuppressWarnings({"unchecked","rawtypes"})
@RestController
@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler 
{
	private static final Logger LOG=LoggerFactory.getLogger(CustomExceptionHandler.class);
	
	Timestamp timestamp = new Timestamp(System.currentTimeMillis());
    
    @ExceptionHandler(HttpClientErrorException.class)
    public final ErrorResponse handleForbiddenException(HttpClientErrorException ex, WebRequest request) {
        ErrorResponse error = new ErrorResponse(ex.getRawStatusCode(),timestamp,ex.getStatusText(), ex.getLocalizedMessage());
        LOG.error(ex.getMessage());
        return error;
      //  
    }
    
    @ExceptionHandler(HttpServerErrorException.class)
    public final ErrorResponse handleAllExceptions(HttpServerErrorException ex, WebRequest request) {
        ErrorResponse error = new ErrorResponse(ex.getRawStatusCode(),timestamp,ex.getStatusText(), ex.getLocalizedMessage());
        LOG.error(ex.getMessage());
        return error;
    }

    @ExceptionHandler(SQLException.class)
    public final ErrorResponse handleSQLExceptions(SQLException ex, WebRequest request) {
        ErrorResponse error = new ErrorResponse(ex.getErrorCode(),timestamp,ex.getMessage(), ex.getLocalizedMessage());
        LOG.error(ex.getMessage());
        return error;
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        List<String> details = new ArrayList<>();
        for(ObjectError error : ex.getBindingResult().getAllErrors()) {
            details.add(error.getDefaultMessage());
        }
        ErrorResponse error = new ErrorResponse(HttpStatus.BAD_REQUEST.value(),timestamp,"Internal server Error" , ex.getLocalizedMessage());
        LOG.error(ex.getMessage());
        return new ResponseEntity(error, HttpStatus.BAD_REQUEST);
    }
    
}