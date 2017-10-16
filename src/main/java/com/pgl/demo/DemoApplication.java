package com.pgl.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * 项目运行启动类
 * @author Administrator
 *
 */
@SpringBootApplication
@EnableCaching
public class DemoApplication {

	/**
	 * 运行主方法
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}
