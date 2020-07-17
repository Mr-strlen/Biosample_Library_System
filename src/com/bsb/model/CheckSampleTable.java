package com.bsb.model;

public class CheckSampleTable {
	private int cs_id;
	private String sample_id;
	private String position_id;
	private int check_id;
	private String state;
	
	public int getcs_id() {
		return cs_id;
	}
	
	public void setcs_id(int _cs_id) {
		cs_id = _cs_id;
	}
	
	public String getsample_id() {
		return sample_id;
	}
	
	public void setsample_id(String _sample_id) {
		sample_id = _sample_id;
	}
	
	public String getposition_id() {
		return position_id;
	}
	
	public void setposition_id(String _position_id) {
		position_id = _position_id;
	}
	
	public int getcheck_id() {
		return check_id;
	}
	
	public void setcheck_id(int _check_id) {
		check_id = _check_id;
	}
	
	public String getstate() {
		return state;
	}
	
	public void setstate(String _state) {
		state = _state;
	}
}
