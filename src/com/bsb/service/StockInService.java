package com.bsb.service;

import java.util.List;

import com.bsb.model.StockInAppsum;
import com.bsb.model.StockInRecord;
import com.bsb.model.StockInAppdetail;

public interface StockInService {
	//1.鍏ュ簱鐢宠琛ㄦ眹鎬�
	public List<StockInAppsum> ShowAppsum(int state);//灞曠ず鎵�鏈夌敵璇疯〃
	public int GetNextAppId();//鑾峰彇涓嬩竴涓敵璇疯〃鍗曞彿
	//2.鍏ュ簱鐢宠琛ㄨ缁�
	public List<StockInAppdetail> ShowAppdetail(int id);//鏄剧ず鐢宠琛ㄤ俊鎭�
	public void Appsubmit(int id,String applicant,String name,String size, String request);//鎻掑叆涓�娆＄敵璇疯褰�
	public void Appcheck(int id, String name, String result, String reason, String auditor);//鐢宠琛ㄥ鏍�
	//3.鍏ュ簱璁板綍琛�
	public List<StockInRecord> ShowRecord();//鏄剧ず鍏ュ簱璁板綍琛�
	public List<StockInRecord> ShowReadyRecord();
	public List<StockInRecord> ShowRecordbySample_id(String sample_id);//鏍规嵁缂栫爜鏄剧ず鐢宠璁板綍涓叿浣撴牱鏈�
	public int GetNextRecordId();//鑾峰彇涓嬩竴涓叆搴撹褰曞彿
	public List<StockInAppdetail> GetNotFinishedApp();//鏄剧ず宸查�氳繃鏈櫥璁扮殑鐢宠
	public void Recordsubmit(int id,int application_id,int sample_quantity,
			String sample_id,String sample_name);//鎻愪氦涓�娆℃牱鏈褰�
}
