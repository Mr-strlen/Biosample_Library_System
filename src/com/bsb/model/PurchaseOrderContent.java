package com.bsb.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class PurchaseOrderContent {
	private String id;
	private String tableid;
	private String name;
	private String number;
	private String price;
	private String source;
	private String time;
	private String state;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTableid() {
		return tableid;
	}
	public void setTableid(String tableid) {
		this.tableid = tableid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getTime() {
		return time;
	}
	public void setTime(Date time) {
		SimpleDateFormat sFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		this.time = sFormat.format(time);
	}
	public String getState() {
		return state;
	}
	public void setState(int state) {
		if(state == 0) {
			this.state = "待采购";
		}
		else if(state == 1) {
			this.state = "采购中";
		}
		else if(state == 2) {
			this.state = "已完成";
		}
	}
}
