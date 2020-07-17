package com.bsb.service;


import java.util.List;



import com.bsb.model.StockInAppsum;
import com.bsb.model.StockInRecord;
import com.bsb.model.StockInAppdetail;

public interface StockInService {
	public List<StockInAppsum> ShowAppsum(int state);
	public List<StockInAppdetail> ShowAppdetail(int id);
	public List<StockInRecord> ShowRecord();
	public void Appcheck(int id, String name, String result, String reason);
	public void Recordsubmit(int id, int application_id, String sample_id, String sample_name, String position_id);
	public List<StockInRecord> ShowRecordbySample_id(String sample_id);
	public int GetNextRecordId();
	public int GetNextAppId();
	public void Appsubmit(int id, String applicant, String name,String size,String condition);
}
