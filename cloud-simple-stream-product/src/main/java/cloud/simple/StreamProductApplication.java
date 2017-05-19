/*
 * Copyright 2012-2020 the original author or authors.
 * Licensed under the Apache License, Version 2.0 (the "License");
 * @author lzhoumail@126.com/zhouli
 * Git http://git.oschina.net/zhou666/spring-cloud-7simple
 */

package cloud.simple;

//import org.springframework.beans.factory.annotation.Value;
//import org.apache.zookeeper.Environment;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@SpringBootApplication
@RestController
@EnableBinding(value = { SinkSender.class })
@EnableEurekaClient
public class StreamProductApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(StreamProductApplication.class, args);
	}

	@Autowired
	private SinkSender sender;

	@RequestMapping("/send")
	public String send() {
		String info = "hi,i'am product , msgid:" + UUID.randomUUID().toString();
		Message<String> msg = MessageBuilder.withPayload(info).build();
		sender.output().send(msg);
		return info;
	}

}
