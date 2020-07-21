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
	
	/*1.鍏ュ簱鐢宠琛ㄦ眹鎬�*/
	//灞曠ず鎵�鏈夌敵璇疯〃
	@Override
	public List<StockInAppsum> ShowAppsum(int state) {
		return StockInMapper.ShowAppsum(state);
	}
	
	//鑾峰彇涓嬩竴涓敵璇疯〃鍗曞彿
	@Override
	public int GetNextAppId() {
		return StockInMapper.GetNextAppId();
	}
	
	/*2.鍏ュ簱鐢宠琛ㄨ缁�*/
	//鏄剧ず鐢宠琛ㄤ俊鎭�
	@Override
	public List<StockInAppdetail> ShowAppdetail(int id) {
		return StockInMapper.ShowAppdetail(id);
	}
	
	//鎻掑叆涓�娆＄敵璇疯褰�
	@Override
	public void Appsubmit(int id, String applicant, String name,String size,String request) {
		StockInMapper.Appsubmit(id, applicant, name, size, request);
	}
	
	//鐢宠琛ㄥ鏍�
	@Override
	public void Appcheck(int id, String name, String result, String reason,String auditor) {
		 StockInMapper.Appcheck(id, name, result, reason, auditor);
	}
	
	/*3.鍏ュ簱璁板綍琛�*/
	//鏄剧ず鍏ュ簱璁板綍琛�
	@Override
	public List<StockInRecord> ShowRecord(){
		return StockInMapper.ShowRecord();
	}
	
	@Override
	public List<StockInRecord> ShowReadyRecord(){
		return StockInMapper.ShowReadyRecord();
	}
	
	//鏍规嵁缂栫爜鏄剧ず鐢宠璁板綍涓叿浣撴牱鏈�
	@Override
	public List<StockInRecord> ShowRecordbySample_id(String sample_id){
		return StockInMapper.ShowRecordbySample_id(sample_id);
	}
	
	//鑾峰彇涓嬩竴涓叆搴撹褰曞彿
	@Override
	public int GetNextRecordId() {
		return StockInMapper.GetNextRecordId();
	}
	
	//鏄剧ず宸查�氳繃鏈櫥璁扮殑鐢宠
	@Override
	public List<StockInAppdetail> GetNotFinishedApp(){
		return StockInMapper.GetNotFinishedApp();
	}
	
	//鎻愪氦涓�娆℃牱鏈褰�
	@Override
	public void Recordsubmit(int id,int application_id,int sample_quantity, String sample_id, String sample_name) {
		 StockInMapper.Recordsubmit(id,  application_id, sample_quantity, sample_id, sample_name);
	}
	
}