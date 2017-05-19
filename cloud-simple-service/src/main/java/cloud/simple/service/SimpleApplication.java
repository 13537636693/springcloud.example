package cloud.simple.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.stereotype.Controller;

@Controller
@SpringBootApplication
@EnableEurekaClient
public class SimpleApplication {
	public static void main(String[] args) throws Exception {
		SpringApplication.run(SimpleApplication.class, args);
	}
}
