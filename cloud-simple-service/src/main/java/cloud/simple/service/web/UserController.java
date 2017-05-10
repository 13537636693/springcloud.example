package cloud.simple.service.web;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.metrics.CounterService;
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
	@Autowired
	private CounterService counterService;

	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public List<User> readUserInfo() {
		counterService.increment("view.counter.user");
		List<User> ls = userService.searchAll();
		return ls;
	}
}
