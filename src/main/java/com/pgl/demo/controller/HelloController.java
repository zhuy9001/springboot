package com.pgl.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pgl.demo.domain.ConfigBean;

@RestController
@EnableConfigurationProperties({ConfigBean.class})
public class HelloController {
	
	@Value("${zhuy.name}")
	private String name;
	@Value("${zhuy.age}")
	private int age;
	
	
	@RequestMapping("hello")
	public String hello() {
		return "helle demo";
	}

	@RequestMapping("getName")
	public String getNameAndAge(){
		return "姓名:"+name+" age:"+age;
	}
}
