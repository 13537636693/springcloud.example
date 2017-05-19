/*
 * Copyright 2012-2020 the original author or authors.
 * Licensed under the Apache License, Version 2.0 (the "License");
 * @author lzhoumail@126.com/zhouli
 * Git http://git.oschina.net/zhou666/spring-cloud-7simple
 */

package cloud.simple;

//import org.springframework.beans.factory.annotation.Value;
//import org.apache.zookeeper.Environment;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

@SpringBootApplication
@EnableBinding(Sink.class)
@EnableEurekaClient
public class StreamCustomerApplication {
	private final Logger logger = Logger.getLogger(getClass());

	public static void main(String[] args) throws Exception {
		SpringApplication.run(StreamCustomerApplication.class, args);
	}

	@StreamListener(Sink.INPUT)
	public void receive(Object payload) {
		logger.info("Received:" + payload);
	}

}
