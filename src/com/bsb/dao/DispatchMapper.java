package com.bsb.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.bsb.model.DispatchAppDetail;
import com.bsb.model.DispatchAppSum;
import com.bsb.model.DispatchRecord;


@Mapper
public interface DispatchMapper {
	// 1.鏄剧ず鍑哄簱鐢宠
	// 鏄剧ず鍏ㄩ儴鍑哄簱鐢宠
	public List<DispatchAppSum> findAllApp();
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
	// 鏇存敼鐢宠缁撴灉
	public void appCheckFinal(@Param("order")String order, @Param("result")String result, @Param("auditor")String auditor);
	// 鑾峰彇褰撳墠璁㈠崟鏁伴噺鐢ㄤ簬璁㈠崟缂栧彿
	public Integer getApplyNum();
	public void insertApplySum(@Param("order")String order, @Param("applicant")String applicant, @Param("time")String time, @Param("result")String result);
	
	// 2.鏄剧ず鍑哄簱鐢宠璇︽儏
	public void insertApplyDe(@Param("order")String order, @Param("type")String type, @Param("num")int num, @Param("condition")String condition, @Param("result")String result);
	// 鏄剧ず鎸囧畾鍗曞彿鍑哄簱鐢宠璇︽儏
	public List<DispatchAppDetail> findAppDetailByOrder(String order);
	// 鎸囧畾鍗曟樉绀哄嚭搴撲綅缃鎯�
	public List<String> getPosByOrder(String order);
	// 濉啓璇︽儏琛�
	public void appCheck(@Param("order")String order, @Param("type")String type, @Param("result")String result, @Param("reason_pos")String reason_pos);
	
	// 3.鏄剧ず鍑哄簱璁板綍
	// 鏄剧ず鍏ㄩ儴鍑哄簱璁板綍
	public List<DispatchRecord> findAllRecord();
	public List<DispatchRecord> findRecordByState();
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
	public void insertRecord(@Param("order")String order, @Param("application_order")String application_order, @Param("state")String state);
	// 淇敼鍑哄簱璁㈠崟鐘舵��
	public void updateRecord(@Param("order")String order, @Param("time")String time, @Param("manager")String manager, @Param("state")String state);
}
