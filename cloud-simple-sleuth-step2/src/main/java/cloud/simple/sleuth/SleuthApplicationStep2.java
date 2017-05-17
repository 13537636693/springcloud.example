package cloud.simple.sleuth;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@EnableDiscoveryClient
@SpringCloudApplication
public class SleuthApplicationStep2 {

	private final Logger logger = Logger.getLogger(getClass());

	@Bean
	@LoadBalanced
	RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@SuppressWarnings("static-access")
	@RequestMapping(value = "/trace-2", method = RequestMethod.GET)
	public String trace() throws InterruptedException {

		logger.info("===call trace-2.1");
		Thread.currentThread().sleep(1000);
		logger.info("===call trace-2.2");
		trace2();
		return "Trace";
	}

	@SuppressWarnings("static-access")
	public String trace2() throws InterruptedException {

		logger.info("===call trace-3.1");
		Thread.currentThread().sleep(5000);
		logger.info("===call trace-3.2");
		return "Trace";
	}

	public static void main(String[] args) {
		SpringApplication.run(SleuthApplicationStep2.class, args);
	}
}
