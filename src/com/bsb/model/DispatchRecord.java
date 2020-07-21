package com.bsb.model;

import java.util.Date;
import java.text.SimpleDateFormat;

public class DispatchRecord {
	private String order;				// 出库单号
	private String time;				// 出库时间
	private String manager;				// 出库管理员
	private String application_order;	// 出库申请单号
	private String state;				// 出库状态
		
	public String getOrder() {
		return order;
	}
	public void setOrder(String _order) {
		order = _order;
	}
	
	public String getTime() {
		return time;
	}
	public void setTime(Date _time) {
		SimpleDateFormat sFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		time = sFormat.format(_time);
	}
	
	public String getManager() {
		return manager;
	}
	public void setManager(String _manager) {
		manager = _manager;
	}
	
	public String getApplication_order() {
		return application_order;
	}
	public void setApplication_order(String _application_order) {
		application_order = _application_order;
	}
	
	public String getState() {
		return state;
	}
	public void setState(String _state) {
		state = _state;
	}
}
