package com.bsb.service;


import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bsb.model.StockInAppsum;
import com.bsb.model.StockInRecord;
import com.bsb.model.StockInAppdetail;

public interface StockInService {
	//1.入库申请表汇总
	public List<StockInAppsum> ShowAppsum(int state);//展示所有申请表
	public int GetNextAppId();//获取下一个申请表单号
	//2.入库申请表详细
	public List<StockInAppdetail> ShowAppdetail(int id);//显示申请表信息
	public void Appsubmit(int id,String applicant,String name,String size, String request);//插入一次申请记录
	public void Appcheck(int id, String name, String result, String reason, String auditor);//申请表审核
	//3.入库记录表
	public List<StockInRecord> ShowRecord();//显示入库记录表
	public List<StockInRecord> ShowRecordbySample_id(String sample_id);//根据编码显示申请记录中具体样本
	public int GetNextRecordId();//获取下一个入库记录号
	public List<StockInAppdetail> GetNotFinishedApp();//显示已通过未登记的申请
	public void Recordsubmit(int id,int application_id,int sample_quantity,
			String sample_id,String sample_name);//提交一次样本记录
}
