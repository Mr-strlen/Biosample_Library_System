package com.bsb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bsb.dao.DispatchMapper;
import com.bsb.model.DispatchAppDetail;
import com.bsb.model.DispatchAppSum;
import com.bsb.model.DispatchRecord;
import com.bsb.service.DispatchService;


@Service("DispatchService")
public class DispatchServiceImpl implements DispatchService{

	@Autowired
	private DispatchMapper dispatchMapper;
	

	@Override
	public List<DispatchAppSum> findAllApp(){
		return dispatchMapper.findAllApp();
	}
	
	@Override
	public List<DispatchAppSum> findAppByOrder(String order){
		order = '%' + order + '%';
		return dispatchMapper.findAppByOrder(order);
	}
	
	// 申请单位
	@Override
	public List<DispatchAppSum> findAppByApplicant(String applicant){
		applicant = '%' + applicant + '%';
		return dispatchMapper.findAppByApplicant(applicant);
	}
	// 申请结果
	@Override
	public List<DispatchAppSum> findAppByResult(String result){
		return dispatchMapper.findAppByResult(result);
	}
	// 时间
	@Override
	public List<DispatchAppSum> findAppByTime(String time){
		time = '%' + time + '%';
		return dispatchMapper.findAppByTime(time);
	}
	// 回填申请表结果
	@Override
	public void appCheckFinal(String order, String result, String auditor) {
		//sSystem.out.println(order+" "+result);
		dispatchMapper.appCheckFinal(order, result, auditor);
	}
	public List<DispatchAppSum> findAppByAuditor(String auditor){
		return dispatchMapper.findAppByAuditor(auditor);
	}
	// 获取当前订单数量用于订单编号
	@Override
	public Integer getApplyNum() {
		return dispatchMapper.getApplyNum();
	}
	@Override
	public void insertApplySum(String order, String applicant, String time, String result) {
		dispatchMapper.insertApplySum(order, applicant, time, result);
	}
	// 出库样本(调用出库申请详情表)
	// public List<DispatchAppSum> findAppBySample(String type);
	
	// 2.显示出库申请详情
	@Override
	public void insertApplyDe(String order, String type, int num, String condition, String result) {
		dispatchMapper.insertApplyDe(order, type, num, condition, result);
	}
	// 显示指定单号出库申请详情
	@Override
	public List<DispatchAppDetail> findAppDetailByOrder(String order){
		return dispatchMapper.findAppDetailByOrder(order);
	}
	// 填写详情表
	@Override
	public void appCheck(String order, String type, String result, String reason_pos) {
		dispatchMapper.appCheck(order, type, result, reason_pos);
	}
	// 指定单显示出库位置详情
	@Override
	public List<String> getPosByOrder(String order){
		return dispatchMapper.getPosByOrder(order);
	}
	
	// 3.显示出库记录
	// 显示全部出库记录
	@Override
	public List<DispatchRecord> findAllRecord(){
		return dispatchMapper.findAllRecord();
	}
	// 显示指定单号的出库申请
	@Override
	public List<DispatchRecord> findRecordByOrder(String order){
		order = '%' + order + '%';
		return dispatchMapper.findRecordByOrder(order);
	}
	// 时间
	@Override
	public List<DispatchAppSum> findRecordByTime(String time){
		time = '%' + time + '%';
		return dispatchMapper.findRecordByTime(time);
	}
	// 出库人员
	@Override
	public List<DispatchRecord> findRecordByManager(String manager){
		manager = '%' + manager + '%';
		return dispatchMapper.findRecordByManager(manager);
	}
	// 订单状态
	@Override
	public List<DispatchRecord> findRecordByState(String state){
		state = '%' + state + '%';
		return dispatchMapper.findRecordByState(state);
	}
	// 获取当前订单数量用于订单编号
	public Integer getRecordNum() {
		return dispatchMapper.getRecordNum();
	}
	// 获取出库申请单对应的出库单
	public String getAppOrderByOrder(String application_order) {
		return dispatchMapper.getAppOrderByOrder(application_order);
	}
	// 新增一条出库订单
	public void insertRecord(String order, String application_order, String state) {
		dispatchMapper.insertRecord(order, application_order, state);
	}
	// 修改出库订单状态
	public void updateRecord(String order, String time, String manager, String state) {
		dispatchMapper.updateRecord(order, time, manager, state);
	}
	
	
}
