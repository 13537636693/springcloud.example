/**
 * spring cloud config server
 * @author lzhoumail@126.com 
 */
package cloud.config.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

//@Configuration
//@EnableAutoConfiguration
//@EnableConfigServer

//@EnableDiscoveryClient
@SpringBootApplication
@EnableConfigServer
@Controller
public class ConfigServerApplication {

	@ResponseBody
	@RequestMapping(value = "/")
	String home() {
		return "config server ~\r\nhttp://localhost:8888/cloud-simple-service/dev/master\r\nhttp://localhost:8888/cloud-simple-bus-service1/dev/master\r\n config refresh~http://localhost:8888/bus/refresh";
	}

	public static void main(String[] args) {
		SpringApplication.run(ConfigServerApplication.class, args);
	}
}
