package in.ecgc.erp.hrd_emp_be;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * HRD-BE-Service
 * 
 * @version 1.1 30-April-20
 * @Author Architecture Team C-DAC Mumbai
 * 
 * */

@SpringBootApplication
@EnableDiscoveryClient  // To register with Eureka Server
@EnableSwagger2			// Enable Swagger
@ComponentScan(basePackages = { 
		"in.ecgc.hrd_emp_be",
		"in.ecgc.erp.hrd_emp_be.controller",
		"in.ecgc.erp.hrd_emp_be.service",
		"in.ecgc.erp.hrd_emp_be.repository",
		"in.ecgc.erp.hrd_emp_be.exception",
		"in.ecgc.erp.hrd_emp_be.message"
})
public class HrdEmpBeApplication {
	

	public static void main(String[] args) {
		SpringApplication.run(HrdEmpBeApplication.class, args);
	}

	/* Swagger config Method */
	@Bean
	public Docket productApi() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("in.ecgc.erp.hrd_emp_be.controller")).build();
	}

}
