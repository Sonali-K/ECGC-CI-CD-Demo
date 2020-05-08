package in.ecgc.erp.hrd_emp_fe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/*HRD-FE-Service
 * 
 * @Author Architecture Team C-DAC Mumbai
 */
@SpringBootApplication
@EnableDiscoveryClient	// To register with Eureka Server
@EnableFeignClients     // Enable FeignClients for calling other service
@EnableCircuitBreaker   // Enable Circuit breaker via Hystrix
@ComponentScan(basePackages = { 
		"in.ecgc.hrd_emp_fe",
		"in.ecgc.erp.hrd_emp_fe.controller",
		"in.ecgc.erp.hrd_emp_fe.service",
})
public class HrdEmpFeApplication {
	public static void main(String[] args) {
		SpringApplication.run(HrdEmpFeApplication.class, args);
	}	
}
