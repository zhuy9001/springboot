package com.pgl.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pgl.demo.domain.ConfigBean;
import com.pgl.demo.domain.User;

@RestController
@EnableConfigurationProperties({ConfigBean.class,User.class})
public class ZhuyController {
	
	@Autowired
	private ConfigBean configBean;
	
	@Autowired
	private User user;
	
	@RequestMapping("zhuy")
	public String getZhuy() {
		 return configBean.getGreeting()+" >>>>"+configBean.getName()+" >>>>"+ configBean.getUuid()+" >>>>"+configBean.getMax();
	}

	@RequestMapping(value = "/user")
    public String user(){
        return user.getName()+user.getAge();
    }
}
