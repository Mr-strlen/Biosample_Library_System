package com.bsb.model;

//申请查询
public class DispatchAppDetail {
	private String order;		// 出库申请单号
	private String type;		// 出库申请样本
	private int num;			// 出库申请（该样本）数量
	private String condition;	// 出库申请（该样本）状态
	private String result;		// 出库样本审核结果
	private String reason_pos;	// 出库样本未通过原因或通过定位位置
		
	public String getorder() {
		return order;
	}
	public void setOrder(String _order) {
		order = _order;
	}
	
	public String getType() {
		return type;
	}
	public void setType(String _type) {
		type=_type;
	}
	
	public int getNum() {
		return num;
	}
	public void setNum(int _num) {
		num = _num;
	}
	
	public String getCondition() {
		return condition;
	}
	public void setCondition(String _condition) {
		condition = _condition;
	}
	
	public String getResult() {
		return result;
	}
	public void setResult(String _result) {
		result = _result;
	}
	
	public String getReason_pos() {
		return reason_pos;
	}
	public void setReason_pos(String _reason_pos) {
		reason_pos = _reason_pos;
	}
}
