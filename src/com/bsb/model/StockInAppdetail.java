package com.bsb.model;

public class StockInAppdetail {
	private int id;
	private String name;
	private String size;
	private String condition;
	private String suggestion;
	private String result;
	private String reason;
		
	public int getid() {
		return id;
	}
	public void setid(int _id) {
		id = _id;
	}
	
	public String getname() {
		return name;
	}
	public void setname(String _name) {
		name=_name;
	}
	
	public String getsize() {
		return size;
	}
	public void setsize(String _size) {
		size = _size;
	}
	
	public String getcondition() {
		return condition;
	}
	public void setcondition(String _condition) {
		condition = _condition;
	}
	
	public String getsuggestion() {
		return suggestion;
	}
	public void setsuggestion(String _suggestion) {
		suggestion = _suggestion;
	}
	
	public String getresult() {
		return result;
	}
	public void setresult(String _result) {
		result = _result;
	}
	
	public String getreason() {
		return reason;
	}
	public void setreason(String _reason) {
		reason = _reason;
	}
}
