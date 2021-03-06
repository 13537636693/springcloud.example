/*
 * Copyright 2012-2020 the original author or authors.
 * Licensed under the Apache License, Version 2.0 (the "License");
 * @author lzhoumail@126.com/zhouli
 * Git http://git.oschina.net/zhou666/spring-cloud-7simple
 */
package cloud.simple.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import cloud.simple.model.User;
import cloud.simple.service.provider.FeignUserService;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class UserService {
	@Autowired
	RestTemplate restTemplate;

	@Autowired
	FeignUserService feignUserService;

	final String SERVICE_NAME = "cloud-simple-service";

	@HystrixCommand(fallbackMethod = "fallbackSearchAll")
	public List<User> readUserInfo() {
		try {
			User[] result = restTemplate.getForObject("http://" + SERVICE_NAME
					+ "/user", User[].class);
			return Arrays.asList(result);

		} catch (Error e) {
			return null;
		}
		// return feignUserService.readUserInfo();
	}

	@SuppressWarnings("unused")
	private List<User> fallbackSearchAll() {
		System.out.println("HystrixCommand fallbackMethod handle!");
		List<User> ls = new ArrayList<User>();
		User user = new User();
		user.setUsername("TestHystrixCommand");
		ls.add(user);
		return ls;
	}
}
