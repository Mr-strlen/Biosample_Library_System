package com.bsb.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CheckTable {
	private int check_id;
	private String check_warehouse;
	private String check_creator;
	private String check_create_time;
	private String check_accept_time;
	private String check_description;
	private String check_state;
	
	public int getcheck_id() {
		return check_id;
	}
	
	public void setcheck_id(int _check_id) {
		check_id = _check_id;
	}
	
	public String getcheck_warehouse() {
		return check_warehouse;
	}
	
	public void setcheck_warehouse(String _check_warehouse) {
		check_warehouse = _check_warehouse;
	}
	
	public String getcheck_creator() {
		return check_creator;
	}
	
	public void setcheck_creator(String _check_creator) {
		check_creator = _check_creator;
	}
	
	public String getcheck_description() {
		return check_description;
	}
	
	public void setcheck_description(String _check_description) {
		check_description = _check_description;
	}
	
	public String getcheck_state() {
		return check_state;
	}
	
	public void setcheck_state(String _check_state) {
		check_state = _check_state;
	}
	
	public String getcheck_create_time() {
		return check_create_time;
	}
	
	public void setcheck_create_time(Date _check_create_time) {
		SimpleDateFormat sFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		check_create_time = sFormat.format(_check_create_time);
	}
	
	public String getcheck_accept_time() {
		return check_accept_time;
	}
	
	public void setcheck_accept_time(Date _check_accept_time) {
		SimpleDateFormat sFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		check_accept_time = sFormat.format(_check_accept_time);
	}
}
