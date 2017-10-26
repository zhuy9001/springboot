package com.pgl.demo.service;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/source")
public class DataSourceController {
	
	
	@RequestMapping("/update")
	public String updateDataSource() {
		
		
		return "同步DataSource成功";
	}

}
