package com.bsb.service;

import java.util.List;

import com.bsb.model.CheckTable;
import com.bsb.model.CheckSampleTable;

public interface CheckService {
	public List<CheckTable> findCheck();
	public List<CheckSampleTable> findAllCheckSample();
	public List<CheckSampleTable> findSamplebyid(int id);
	public List<CheckTable> creatCheck(String check_id, String check_ctt, String check_wh, String check_ct, String check_dp);
	public List<CheckSampleTable> creatSample(String sample_id, String position_id, String check_id);
	public List<CheckSampleTable> creatComp(String check_id);
	public String findSampleStatebyPosition(String position_id);
	public String findSampleIdbyPosition(String position_id);
	public void setSampleState(String position_id, String dp);
	public void setCheckState(String check_id);
}
