package in.ecgc.erp.hrd_emp_be.message;

import java.util.Locale;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.stereotype.Component;

/**
 *Message class to access application.properties
 *
 *@version 1.1 30-April-20
 *@Author Architecture Team C-DAC Mumbai
 **/
@Component
public class Messages {

	@Autowired
	private MessageSource messageSource;
	
	private MessageSourceAccessor accessor;
	
	@PostConstruct
    private void init() {
        accessor = new MessageSourceAccessor(messageSource, Locale.ENGLISH);
    }

    public String get(String code) {
        return accessor.getMessage(code);
    }
    
    public String getStastusCode(String code){
    	code = code.trim();
    	//return Integer.parseInt(accessor.getMessage(code).trim());
    	return accessor.getMessage(code).trim();
    }
	
}
