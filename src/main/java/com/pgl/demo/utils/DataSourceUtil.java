package com.pgl.demo.utils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.pgl.demo.datasource.DataSourceInfo;

public class DataSourceUtil {
	
	private static Map<String, Map<String, Object>> getCustomDataSourceInfo(DataSource defaultDataSource) {
		Map<String, Map<String, Object>> customMap = new HashMap<>();
		String sql = "select type,`driver_class_name`,url,username,`password`,`dsname` from datasource where status=1";
		JdbcTemplate jdbcTemplate=new JdbcTemplate(defaultDataSource);
		List<DataSourceInfo> infos=jdbcTemplate.query(sql, new RowMapper<DataSourceInfo>() {
			@Override
			public DataSourceInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
				DataSourceInfo info=new DataSourceInfo();
				info.setType(rs.getString("type"));
				info.setDriverClassName(rs.getString("driver_class_name"));
				info.setUrl(rs.getString("url"));
				info.setPassword(rs.getString("password"));
				info.setUsername(rs.getString("username"));
				info.setDsName(rs.getString("dsname"));
				return info;
			}
		});
		for(DataSourceInfo info:infos) {
			Map<String, Object> dsMap = new HashMap<>();
			dsMap.put("type", info.getType());
			dsMap.put("driver-class-name", info.getDriverClassName());
			dsMap.put("url", info.getUrl());
			dsMap.put("username", info.getUsername());
			dsMap.put("password", info.getPassword());
			customMap.put(info.getDsName(), dsMap);
		}
		jdbcTemplate=null;
		return customMap;
	}

}
