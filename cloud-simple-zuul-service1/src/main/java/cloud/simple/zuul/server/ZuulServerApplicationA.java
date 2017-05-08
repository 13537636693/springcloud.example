package cloud.simple.zuul.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
public class ZuulServerApplicationA {

	public static void main(String[] args) {
		SpringApplication.run(ZuulServerApplicationA.class, args);
	}
}

@RestController
class HiController {

	@RequestMapping("/A/*")
	public String hi() throws Exception {
		return "serviceA";
	}
}