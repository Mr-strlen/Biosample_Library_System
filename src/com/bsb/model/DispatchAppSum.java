package com.bsb.model;

import java.util.Date;
import java.text.SimpleDateFormat;

public class DispatchAppSum {
	private String order;		// 出库申请单号
	private String applicant;	// 出库申请单位
	private String time;		// 出库申请时间
	private String result;		// 出库申请结果
	private String auditor;		// 出库审核员
		
	public String getOrder() {
		return order;
	}
	public void setOrder(String _order) {
		order = _order;
	}
	
	public String getApplicant() {
		return applicant;
	}
	public void setapplicant(String _applicant) {
		applicant = _applicant;
	}
	
	public String getTime() {
		return time;
	}
	public void setTime(Date _time) {
		SimpleDateFormat sFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		time = sFormat.format(_time);
	}
	
	public String getResult() {
		return result;
	}
	public void setResult(String _result) {
		result = _result;
	}
	
	public String getAuditor() {
		return auditor;
	}
	public void setAuditor(String _auditor) {
		auditor = _auditor;
	}
}
