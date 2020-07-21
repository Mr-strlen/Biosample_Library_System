package com.bsb.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DestroyRequestTable {
	private String id;
	private String time;
	private String user;
	private String state;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTime() {
		return time;
	}
	public void setTime(Date time) {
		SimpleDateFormat sFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		this.time = sFormat.format(time);
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getState() {
		return state;
	}
	public void setState(int state) {
		if(state == 0) {
			this.state = "待审核";
		}
		else if(state == 1) {
			this.state = "已通过";
		}
		else if(state == -1) {
			this.state = "未通过";
		}
	}
	
	
}
