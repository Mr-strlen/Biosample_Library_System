package com.bsb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bsb.dao.CheckMapper;
import com.bsb.model.CheckTable;
import com.bsb.model.CheckSampleTable;
import com.bsb.service.CheckService;

@Service("checkService")
public class CheckServiceImpl implements CheckService{
	@Autowired
	private CheckMapper checkMapper;
	
	@Override
	public List<CheckTable> findCheck() {
		return checkMapper.findCheck();
	}
	
	@Override
	public List<CheckSampleTable> findAllCheckSample() {
		return checkMapper.findAllCheckSample();
	}
	
	@Override
	public List<CheckSampleTable> findSamplebyid(int id) {
		return checkMapper.findSamplebyid(id);
	}
	
	@Override
	public List<CheckTable> creatCheck(String check_id, String check_ctt, String check_wh, String check_ct, String check_dp) {
		return checkMapper.creatCheck(check_id, check_ctt,check_wh,check_ct,check_dp);
	}
	
	@Override
	public List<CheckSampleTable> creatSample(String sample_id, String position_id, String check_id) {
		return checkMapper.creatSample(sample_id, position_id, check_id);
	}
	
	@Override
	public List<CheckSampleTable> creatComp(String check_id) {
		return checkMapper.creatComp(check_id);
	}
	
	@Override
	public String findSampleStatebyPosition(String position_id) {
		return checkMapper.findSampleStatebyPosition(position_id);
	}
	
	@Override
	public String findSampleIdbyPosition(String position_id) {
		return checkMapper.findSampleIdbyPosition(position_id);
	}
	
	@Override
	public void setSampleState(String position_id, String dp) {
		checkMapper.setSampleState(position_id, dp);
	}
	
	@Override
	public void setCheckState(String check_id) {
		checkMapper.setCheckState(check_id);
	}
}
