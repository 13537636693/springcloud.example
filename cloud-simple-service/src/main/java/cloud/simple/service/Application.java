package cloud.simple.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.stereotype.Controller;

@Controller
@SpringBootApplication
@EnableEurekaClient
public class Application {
	public static void main(String[] args) throws Exception {
		SpringApplication.run(Application.class, args);
	}
}
