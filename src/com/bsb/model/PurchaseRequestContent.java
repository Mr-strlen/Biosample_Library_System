package com.bsb.model;

public class PurchaseRequestContent {
	private String id;
	private String tableid;
	private String name;
	private int number;
	private String notes;
	private String state;
	private String reason;
	
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
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
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
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
}
