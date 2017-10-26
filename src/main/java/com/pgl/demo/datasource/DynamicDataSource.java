package com.pgl.demo.datasource;

import java.util.Map;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
* 描述：
* @author zhuy
*  邮箱: zhuyang@pgl-world.com
*  创建时间：2017年10月26日 下午4:50:57
*/
public class DynamicDataSource extends AbstractRoutingDataSource {
	

	@Override
	protected Object determineCurrentLookupKey() {
		  return DynamicDataSourceContextHolder.getDataSourceType();
	}
	

}
