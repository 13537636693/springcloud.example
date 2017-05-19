/*
 * Copyright 2012-2020 the original author or authors.
 * Licensed under the Apache License, Version 2.0 (the "License");
 * @author lzhoumail@126.com/zhouli
 * Git http://git.oschina.net/zhou666/spring-cloud-7simple
 */

package cloud.simple;

//import org.springframework.beans.factory.annotation.Value;
//import org.apache.zookeeper.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@SpringBootApplication
@RestController
public class BusApplication1 {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(BusApplication1.class, args);
	}

	@Autowired
	private Environment env;

	@RequestMapping("/from")
	public String from() {
		return env.getProperty("from", "undefined");
	}

}
