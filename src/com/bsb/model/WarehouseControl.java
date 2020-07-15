package com.bsb.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class WarehouseControl {
	private String Sample_code;
	private String Sample_name;
	private String Warehousing_date;
	private String Storage_conditions;
	private String Storage_area;
	private int Quantity;
	
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
	
	public String getWarehousing_date() {
		return Warehousing_date;
	}
	
	public void setWarehousing_date(Date _Warehousing_date) {
		SimpleDateFormat sFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Warehousing_date = sFormat.format(_Warehousing_date);
	}
	
	public String getStorage_conditions() {
		return Storage_conditions;
	}
	
	public void setStorage_conditions(String _Storage_conditions) {
		Storage_conditions = _Storage_conditions;
	}
	
	public String getStorage_area() {
		return Storage_area;
	}
	
	public void setStorage_area(String _Storage_area) {
		Storage_area = _Storage_area;
	}
	
	public int getQuantity() {
		return Quantity;
	}
	
	public void setcheck_id(int _Quantity) {
		Quantity = _Quantity;
	}
	
}


