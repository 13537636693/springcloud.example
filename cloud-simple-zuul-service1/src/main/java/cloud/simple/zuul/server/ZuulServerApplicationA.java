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

	@RequestMapping("/*")
	public String hi1() throws Exception {

		return "/*";
	}

	@RequestMapping("/a")
	public String hi2() throws Exception {

		return "/a";
	}

	@RequestMapping("/a/*")
	public String hi3() throws Exception {

		return "/a/*";
	}
}