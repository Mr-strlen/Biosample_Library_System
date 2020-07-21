package com.bsb.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DestroyOrderTable {
	private String id;
	private String time;
	private String user;
	private String buyer;
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
	public String getBuyer() {
		return buyer;
	}
	public void setBuyer(String buyer) {
		this.buyer = buyer;
	}
	public String getState() {
		return state;
	}
	public void setState(int state) {
		if(state == 0) {
			this.state = "待销毁";
		}
		else if(state == 1) {
			this.state = "销毁中";
		}
		else if(state == 2) {
			this.state = "已完成";
		}
		/*else if(state == 3) {
			this.state = "报销中";
		}
		else if(state == 4) {
			this.state = "已报销";
		}*/
	}
}
