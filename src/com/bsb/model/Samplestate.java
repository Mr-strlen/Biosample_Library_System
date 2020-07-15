package com.bsb.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Samplestate {
	private String Sample_code;
	private String Sample_name;
	private String Sample_state;
	private String State_time;
	
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
	
	public String getSample_state() {
		return Sample_state;
	}
	
	public void setSample_state(String _Sample_state) {
		Sample_state = _Sample_state;
	}
	
	public String getState_time() {
		return State_time;
	}
	
	public void setState_time(Date _State_time) {
		SimpleDateFormat sFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		State_time = sFormat.format(_State_time);
	}
}
