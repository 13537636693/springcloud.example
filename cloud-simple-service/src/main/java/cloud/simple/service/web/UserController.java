package cloud.simple.service.web;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cloud.simple.service.domain.UserService;
import cloud.simple.service.model.User;

@RestController
public class UserController {

	private final Logger logger = Logger.getLogger(getClass());
	@Autowired
	UserService userService;

	@Autowired
	private DiscoveryClient client;

	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public List<User> readUserInfo() {
		ServiceInstance instance = client.getLocalServiceInstance();
		logger.info("/user, host:" + instance.getHost() + ", service_id:"
				+ instance.getServiceId());
		List<User> ls = userService.searchAll();
		return ls;
	}
}
