package com.bsb.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class WarehouseState {
	private String Warehouse_area;
	private String Warehouse_state;
	private int Warehouse_balance;
	private String State_duration;
	
	public String getWarehouse_area() {
		return Warehouse_area;
	}
	
	public void setWarehouse_area(String _Warehouse_area) {
		Warehouse_area = _Warehouse_area;
	}
	
	public String getWarehouse_state() {
		return Warehouse_state;
	}
	
	public void setWarehouse_state(String _Warehouse_state) {
		Warehouse_state = _Warehouse_state;
	}
	
	public int getWarehouse_balance() {
		return Warehouse_balance;
	}
	
	public void setWarehouse_balance(int _Warehouse_balance) {
		Warehouse_balance = _Warehouse_balance;
	}
	
	public String getState_duration() {
		return State_duration;
	}
	
	public void setState_duration(Date _State_duration) {
		SimpleDateFormat sFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		State_duration = sFormat.format(_State_duration);
	}
}
