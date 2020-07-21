package com.bsb.service;

import java.util.List;

import com.bsb.model.DispatchAppDetail;
import com.bsb.model.DispatchAppSum;
import com.bsb.model.DispatchRecord;

public interface DispatchService {
	// 1.鏄剧ず鍑哄簱鐢宠
	// 鏄剧ず鍏ㄩ儴鍑哄簱鐢宠
	public List<DispatchAppSum> findAllApp();
	public List<DispatchRecord> findRecordByState();
	// 鏄剧ず鎸囧畾鍗曞彿鐨勫嚭搴撶敵璇�
	public List<DispatchAppSum> findAppByOrder(String order);
	// 鐢宠鍗曚綅
	public List<DispatchAppSum> findAppByApplicant(String applicant);
	// 鏃堕棿
	public List<DispatchAppSum> findAppByTime(String time);
	// 鐢宠缁撴灉
	public List<DispatchAppSum> findAppByResult(String result);
	// 瀹℃牳鍛�
	public List<DispatchAppSum> findAppByAuditor(String auditor);
	// 鍥炲～鐢宠琛ㄥ鏍哥粨鏋�
	public void appCheckFinal(String order, String result, String auditor);
	// 鑾峰彇褰撳墠璁㈠崟鏁伴噺鐢ㄤ簬璁㈠崟缂栧彿
	public Integer getApplyNum();
	public void insertApplySum(String order, String applicant, String time, String result);
	
	// 2.鏄剧ず鍑哄簱鐢宠璇︽儏
	public void insertApplyDe(String order, String type, int num, String condition, String result);
	// 鏄剧ず鎸囧畾鍗曞彿鍑哄簱鐢宠璇︽儏
	public List<DispatchAppDetail> findAppDetailByOrder(String order);
	// 濉啓璇︽儏琛�
	public void appCheck(String order, String name, String result, String reason);
	// 鎸囧畾鍗曟樉绀哄嚭搴撲綅缃鎯�
	public List<String> getPosByOrder(String order);
	
	// 3.鏄剧ず鍑哄簱璁板綍
	// 鏄剧ず鍏ㄩ儴鍑哄簱璁板綍
	public List<DispatchRecord> findAllRecord();
	// 鏄剧ず鎸囧畾鍗曞彿鐨勫嚭搴撶敵璇�
	public List<DispatchRecord> findRecordByOrder(String order);
	// 鏃堕棿
	public List<DispatchAppSum> findRecordByTime(String time);
	// 鍑哄簱浜哄憳
	public List<DispatchRecord> findRecordByManager(String manager);
	// 璁㈠崟鐘舵��
	public List<DispatchRecord> findRecordByState(String state);
	// 鑾峰彇褰撳墠璁㈠崟鏁伴噺鐢ㄤ簬璁㈠崟缂栧彿
	public Integer getRecordNum();
	// 鑾峰彇鍑哄簱鐢宠鍗曞搴旂殑鍑哄簱鍗�
	public String getAppOrderByOrder(String application_order);
	// 鏂板涓�鏉″嚭搴撹鍗�
	public void insertRecord(String order, String application_order, String state);
	// 淇敼鍑哄簱璁㈠崟鐘舵��
	public void updateRecord(String order, String time, String manager, String state);
}
