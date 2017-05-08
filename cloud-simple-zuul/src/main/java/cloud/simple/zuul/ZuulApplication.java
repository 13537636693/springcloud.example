package cloud.simple.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

//zuul网关示例，基于jvm的反向代理功能，类似于nginx
@EnableZuulProxy
// @SpringBootApplication
@SpringCloudApplication
public class ZuulApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZuulApplication.class, args);
	}
}
