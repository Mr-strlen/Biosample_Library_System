package com.bsb.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.bsb.model.DispatchAppDetail;
import com.bsb.model.DispatchAppSum;
import com.bsb.model.DispatchRecord;


@Mapper
public interface DispatchMapper {
	// 1.显示出库申请
	// 显示全部出库申请
	public List<DispatchAppSum> findAllApp();
	// 显示指定单号的出库申请
	public List<DispatchAppSum> findAppByOrder(String order);
	// 申请单位
	public List<DispatchAppSum> findAppByApplicant(String applicant);
	// 时间
	public List<DispatchAppSum> findAppByTime(String time);
	// 申请结果
	public List<DispatchAppSum> findAppByResult(String result);
	// 审核员
	public List<DispatchAppSum> findAppByAuditor(String auditor);
	// 更改申请结果
	public void appCheckFinal(@Param("order")String order, @Param("result")String result, @Param("auditor")String auditor);
	// 获取当前订单数量用于订单编号
	public Integer getApplyNum();
	public void insertApplySum(@Param("order")String order, @Param("applicant")String applicant, @Param("time")String time, @Param("result")String result);
	
	// 2.显示出库申请详情
	public void insertApplyDe(@Param("order")String order, @Param("type")String type, @Param("num")int num, @Param("condition")String condition, @Param("result")String result);
	// 显示指定单号出库申请详情
	public List<DispatchAppDetail> findAppDetailByOrder(String order);
	// 指定单显示出库位置详情
	public List<String> getPosByOrder(String order);
	// 填写详情表
	public void appCheck(@Param("order")String order, @Param("type")String type, @Param("result")String result, @Param("reason_pos")String reason_pos);
	
	// 3.显示出库记录
	// 显示全部出库记录
	public List<DispatchRecord> findAllRecord();
	// 显示指定单号的出库申请
	public List<DispatchRecord> findRecordByOrder(String order);
	// 时间
	public List<DispatchAppSum> findRecordByTime(String time);
	// 出库人员
	public List<DispatchRecord> findRecordByManager(String manager);
	// 订单状态
	public List<DispatchRecord> findRecordByState(String state);
	// 获取当前订单数量用于订单编号
	public Integer getRecordNum();
	// 获取出库申请单对应的出库单
	public String getAppOrderByOrder(String application_order);
	// 新增一条出库订单
	public void insertRecord(@Param("order")String order, @Param("application_order")String application_order, @Param("state")String state);
	// 修改出库订单状态
	public void updateRecord(@Param("order")String order, @Param("time")String time, @Param("manager")String manager, @Param("state")String state);
}
