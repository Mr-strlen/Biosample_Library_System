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
	
	// 鐢宠鍗曚綅
	@Override
	public List<DispatchAppSum> findAppByApplicant(String applicant){
		applicant = '%' + applicant + '%';
		return dispatchMapper.findAppByApplicant(applicant);
	}
	// 鐢宠缁撴灉
	@Override
	public List<DispatchAppSum> findAppByResult(String result){
		return dispatchMapper.findAppByResult(result);
	}
	// 鏃堕棿
	@Override
	public List<DispatchAppSum> findAppByTime(String time){
		time = '%' + time + '%';
		return dispatchMapper.findAppByTime(time);
	}
	// 鍥炲～鐢宠琛ㄧ粨鏋�
	@Override
	public void appCheckFinal(String order, String result, String auditor) {
		//sSystem.out.println(order+" "+result);
		dispatchMapper.appCheckFinal(order, result, auditor);
	}
	public List<DispatchAppSum> findAppByAuditor(String auditor){
		return dispatchMapper.findAppByAuditor(auditor);
	}
	// 鑾峰彇褰撳墠璁㈠崟鏁伴噺鐢ㄤ簬璁㈠崟缂栧彿
	@Override
	public Integer getApplyNum() {
		return dispatchMapper.getApplyNum();
	}
	@Override
	public void insertApplySum(String order, String applicant, String time, String result) {
		dispatchMapper.insertApplySum(order, applicant, time, result);
	}
	// 鍑哄簱鏍锋湰(璋冪敤鍑哄簱鐢宠璇︽儏琛�)
	// public List<DispatchAppSum> findAppBySample(String type);
	
	// 2.鏄剧ず鍑哄簱鐢宠璇︽儏
	@Override
	public void insertApplyDe(String order, String type, int num, String condition, String result) {
		dispatchMapper.insertApplyDe(order, type, num, condition, result);
	}
	// 鏄剧ず鎸囧畾鍗曞彿鍑哄簱鐢宠璇︽儏
	@Override
	public List<DispatchAppDetail> findAppDetailByOrder(String order){
		return dispatchMapper.findAppDetailByOrder(order);
	}
	// 濉啓璇︽儏琛�
	@Override
	public void appCheck(String order, String type, String result, String reason_pos) {
		dispatchMapper.appCheck(order, type, result, reason_pos);
	}
	// 鎸囧畾鍗曟樉绀哄嚭搴撲綅缃鎯�
	@Override
	public List<String> getPosByOrder(String order){
		return dispatchMapper.getPosByOrder(order);
	}
	
	// 3.鏄剧ず鍑哄簱璁板綍
	// 鏄剧ず鍏ㄩ儴鍑哄簱璁板綍
	@Override
	public List<DispatchRecord> findAllRecord(){
		return dispatchMapper.findAllRecord();
	}
	
	// 鏄剧ず鎸囧畾鍗曞彿鐨勫嚭搴撶敵璇�
	@Override
	public List<DispatchRecord> findRecordByOrder(String order){
		order = '%' + order + '%';
		return dispatchMapper.findRecordByOrder(order);
	}
	// 鏃堕棿
	@Override
	public List<DispatchAppSum> findRecordByTime(String time){
		time = '%' + time + '%';
		return dispatchMapper.findRecordByTime(time);
	}
	// 鍑哄簱浜哄憳
	@Override
	public List<DispatchRecord> findRecordByManager(String manager){
		manager = '%' + manager + '%';
		return dispatchMapper.findRecordByManager(manager);
	}
	// 璁㈠崟鐘舵��
	@Override
	public List<DispatchRecord> findRecordByState(String state){
		state = '%' + state + '%';
		return dispatchMapper.findRecordByState(state);
	}
	// 鑾峰彇褰撳墠璁㈠崟鏁伴噺鐢ㄤ簬璁㈠崟缂栧彿
	public Integer getRecordNum() {
		return dispatchMapper.getRecordNum();
	}
	// 鑾峰彇鍑哄簱鐢宠鍗曞搴旂殑鍑哄簱鍗�
	public String getAppOrderByOrder(String application_order) {
		return dispatchMapper.getAppOrderByOrder(application_order);
	}
	// 鏂板涓�鏉″嚭搴撹鍗�
	public void insertRecord(String order, String application_order, String state) {
		dispatchMapper.insertRecord(order, application_order, state);
	}
	// 淇敼鍑哄簱璁㈠崟鐘舵��
	public void updateRecord(String order, String time, String manager, String state) {
		dispatchMapper.updateRecord(order, time, manager, state);
	}
	
	
}
