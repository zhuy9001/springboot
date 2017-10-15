package com.pgl.demo.utils;

public class ResultMsg {
	private int errcode;
	private String errmsg;
	private Object data;
	
	public ResultMsg(int errCode, String errMsg, Object data)
	{
		this.errcode = errCode;
		this.errmsg = errMsg;
		this.data = data;
	}
	public int getErrcode() {
		return errcode;
	}
	public void setErrcode(int errcode) {
		this.errcode = errcode;
	}
	public String getErrmsg() {
		return errmsg;
	}
	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	
}

