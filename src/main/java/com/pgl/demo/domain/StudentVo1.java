package com.pgl.demo.domain;

public class StudentVo1 {
	
	private String sname;
	private String ssex;
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getSsex() {
		return ssex;
	}
	public void setSsex(String ssex) {
		this.ssex = ssex;
	}
	@Override
	public String toString() {
		return "StudentVo1 [sname=" + sname + ", ssex=" + ssex + "]";
	}
	

}
