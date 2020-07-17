package com.bsb.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class WarehouseAlter {
	private String Sample_code;
	private String Sample_name;
	private String Sample_alter;
	private String Reason;
	private int Quantity;
	private String Alter_date;
	
	public String getSample_code() {
		return Sample_code;
	}
	
	public void setSample_code(String _Sample_code) {
		Sample_code = _Sample_code;
	}
	
	public String getSample_name() {
		return Sample_name;
	}
	
	public void setSample_name(String _Sample_name) {
		Sample_name = _Sample_name;
	}
	
	public String getSample_alter() {
		return Sample_alter;
	}
	
	public void setSample_alter(String _Sample_alter) {
		Sample_alter = _Sample_alter;
	}
	
	public String getReason() {
		return Reason;
	}
	
	public void setReason(String _Reason) {
		Reason = _Reason;
	}
	
	public int getQuantity() {
		return Quantity;
	}
	
	public void setQuantity(int _Quantity) {
		Quantity = _Quantity;
	}
	
	public String getAlter_date() {
		return Alter_date;
	}
	
	public void setAlter_date(Date _Alter_date) {
		SimpleDateFormat sFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Alter_date = sFormat.format(_Alter_date);
	}
}
