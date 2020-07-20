package com.bsb.model;

import java.util.Date;
import java.text.SimpleDateFormat;

public class StockInAppsum {
	private int id;
	private String date;
	private String applicant;
	private int state;
	private String auditor;
		
	public int getid() {
		return id;
	}
	public void setid(int _id) {
		id = _id;
	}	
	public String getdate() {
		return date;
	}
	public void setdate(Date _date) {
		SimpleDateFormat sFormat = new SimpleDateFormat("yyyy-MM-dd HH:ss:ss");
		date = sFormat.format(_date);
	}
	
	public String getapplicant() {
		return applicant;
	}
	public void setapplicant(String _applicant) {
		applicant = _applicant;
	}
	
	public int getstate() {
		return state;
	}
	public void setstate(int _state) {
		state = _state;
	}
	
	public String getauditor() {
		return auditor;
	}
	public void setauditor(String _auditor) {
		auditor = _auditor;
	}
}
