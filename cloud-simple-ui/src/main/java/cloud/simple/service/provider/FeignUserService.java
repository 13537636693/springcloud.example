package cloud.simple.service.provider;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cloud.simple.model.User;

//@FeignClient(name = 'microservice-provider-userservice',fallback = UserServiceFeignFallback.class, configuration = FeignConfig.class)
@FeignClient("cloud-simple-service")
public interface FeignUserService {
	
	   @RequestMapping(value = "/user", method = RequestMethod.GET)
	   List<User> readUserInfo();

}