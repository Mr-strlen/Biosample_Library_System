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
	public void Appsubmit(int id, String applicant, String name,String size,String request) {
		StockInMapper.Appsubmit(id, applicant, name, size, request);
	}
	
	//申请表审核
	@Override
	public void Appcheck(int id, String name, String result, String reason,String auditor) {
		 StockInMapper.Appcheck(id, name, result, reason, auditor);
	}
	
	/*3.入库记录表*/
	//显示入库记录表
	@Override
	public List<StockInRecord> ShowRecord(){
		return StockInMapper.ShowRecord();
	}
	
	//根据编码显示申请记录中具体样本
	@Override
	public List<StockInRecord> ShowRecordbySample_id(String sample_id){
		return StockInMapper.ShowRecordbySample_id(sample_id);
	}
	
	//获取下一个入库记录号
	@Override
	public int GetNextRecordId() {
		return StockInMapper.GetNextRecordId();
	}
	
	//显示已通过未登记的申请
	@Override
	public List<StockInAppdetail> GetNotFinishedApp(){
		return StockInMapper.GetNotFinishedApp();
	}
	
	//提交一次样本记录
	@Override
	public void Recordsubmit(int id,int application_id,int sample_quantity, String sample_id, String sample_name) {
		 StockInMapper.Recordsubmit(id,  application_id, sample_quantity, sample_id, sample_name);
	}
	
}