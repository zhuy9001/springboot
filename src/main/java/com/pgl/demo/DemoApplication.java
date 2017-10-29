package com.pgl.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;

import com.pgl.demo.datasource.DynamicDataSourceRegister;

/**
 * 项目运行启动类
 * @author Administrator
 *
 */
@SpringBootApplication
@EnableCaching
@EnableAspectJAutoProxy(exposeProxy = true)
@Import(DynamicDataSourceRegister.class)
public class DemoApplication {

	/**
	 * 运行主方法
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}
