package com.pgl.demo.datasource;
/**
* 描述：
* @author zhuy
*  邮箱: zhuyang@pgl-world.com
*  创建时间：2017年10月26日 下午4:50:57
*/
public class DataSourceInfo {
	
	private int id;
	private String type;
	private String driverClassName;
	private String url;
	private String username;
	private String password;
	private String dsName;
	private String status;
	private String alias;
	private String property;
	private String propertyStatus;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDriverClassName() {
		return driverClassName;
	}
	public void setDriverClassName(String driverClassName) {
		this.driverClassName = driverClassName;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDsName() {
		return dsName;
	}
	public void setDsName(String dsName) {
		this.dsName = dsName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getAlias() {
		return alias;
	}
	public void setAlias(String alias) {
		this.alias = alias;
	}
	
	public String getProperty() {
		return property;
	}
	public void setProperty(String property) {
		this.property = property;
	}
	public String getPropertyStatus() {
		return propertyStatus;
	}
	public void setPropertyStatus(String propertyStatus) {
		this.propertyStatus = propertyStatus;
	}
	@Override
	public String toString() {
		return "DataSourceInfo [id=" + id + ", type=" + type + ", driverClassName=" + driverClassName + ", url=" + url
				+ ", username=" + username + ", password=" + password + ", dsName=" + dsName + ", status=" + status
				+ ", alias=" + alias + ", property=" + property + ", propertyStatus=" + propertyStatus + "]";
	}

	
	
	 

}
