package com.bsb.model;

import java.util.Date;
import java.text.SimpleDateFormat;

public class StockInRecord {
	private int id;
	private String date;
	private int application_id;
	private String sample_id;
	private String sample_name;
	private String position_id;
		
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
		SimpleDateFormat sFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		date = sFormat.format(_date);
	}
	
	public int getapplication_id() {
		return application_id;
	}
	public void setapplication_id(int _application_id) {
		application_id = _application_id;
	}
	
	public String getsample_id() {
		return sample_id;
	}
	public void setsample_id(String _sample_id) {
		sample_id = _sample_id;
	}
	
	public String getsample_name() {
		return sample_name;
	}
	public void setsample_name(String _sample_name) {
		sample_name = _sample_name;
	}
	
	public String getposition_id() {
		return position_id;
	}
	public void setposition_id(String _position_id) {
		position_id = _position_id;
	}
}
