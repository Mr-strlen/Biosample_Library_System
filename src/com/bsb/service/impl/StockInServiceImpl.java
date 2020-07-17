package com.bsb.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bsb.dao.StockInMapper;
import com.bsb.model.StockInAppsum;
import com.bsb.model.StockInRecord;
import com.bsb.model.StockInAppdetail;

import com.bsb.service.StockInService;

@Service("StockInService")
public class StockInServiceImpl implements StockInService{
	@Autowired
	private StockInMapper StockInMapper;
	
	/*1.入库申请表汇总*/
	//展示所有申请表
	@Override
	public List<StockInAppsum> ShowAppsum(int state) {
		return StockInMapper.ShowAppsum(state);
	}
	
	//获取下一个申请表单号
	@Override
	public int GetNextAppId() {
		return StockInMapper.GetNextAppId();
	}
	
	/*2.入库申请表详细*/
	//显示申请表信息
	@Override
	public List<StockInAppdetail> ShowAppdetail(int id) {
		return StockInMapper.ShowAppdetail(id);
	}
	
	//插入一次申请记录
	@Override
	public void Appsubmit(int id, String applicant, String name,String size,String condition) {
		StockInMapper.Appsubmit(id, applicant, name, size, condition);
	}
	
	//申请表审核
	@Override
	public void Appcheck(int id, String name, String result, String reason) {
		 StockInMapper.Appcheck(id, name, result, reason);
	}
	
	
	
}