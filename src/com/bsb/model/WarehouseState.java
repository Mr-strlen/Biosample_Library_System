package com.bsb.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class WarehouseState {
	private String Warehouse_State;
	private int Warehouse_balance;
	private String State_duration;
	
	public String getWarehouse_State() {
		return Warehouse_State;
	}
	
	public void setSample_code(String _Warehouse_State) {
		Warehouse_State = _Warehouse_State;
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
