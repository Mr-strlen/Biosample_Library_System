package com.bsb.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.bsb.model.DestroyOrderContent;
import com.bsb.model.DestroyOrderTable;
import com.bsb.model.DestroyRequestContent;
import com.bsb.model.DestroyRequestTable;

@Mapper
public interface DestroyMapper {
	public List<DestroyRequestTable> getAllDestroyRequestTables();
	public List<DestroyRequestTable> getUncheckedDestroyRequestTables();
	public List<DestroyRequestTable> getPassedDestroyRequestTables();
	public List<DestroyRequestTable> getUnpassedDestroyRequestTables();
	public List<DestroyRequestTable> getDestroyRequestTablesbyId(String id);
	public List<DestroyRequestTable> getDestroyRequestTablesbyUser(String user);
	public List<DestroyRequestTable> getDestroyRequestTablesbyTime(String time);
	
	public List<DestroyRequestContent> getDestroyRequestContentbyTableId(String tableid);
	public void setDestroyRequestContentCheckState(@Param("id")String id, @Param("state")int state, @Param("reason")String reason);
	public void setDestroyRequestCheckState(@Param("id")String id, @Param("state")int state);
	
	public String getBuyerId();
	public void addBuyerNum(String id);
	
	public void createDestroyOrder(@Param("id")String id, @Param("user")String user, @Param("buyer")String buyer);
	public void createDestroyOrderContent(@Param("id")String id, @Param("name")String name, @Param("number")int number);
	public List<DestroyOrderTable> getAllDestroyOrderTables();
	public List<DestroyOrderTable> getUnstartDestroyOrderTables();
	public List<DestroyOrderTable> getStartedDestroyOrderTables();
	public List<DestroyOrderTable> getFinishedDestroyOrderTables();
	public List<DestroyOrderTable> getUnreimbursedDestroyOrderTables();
	public List<DestroyOrderTable> getReimbursingDestroyOrderTables();
	public List<DestroyOrderTable> getReimbursedDestroyOrderTables();
	public List<DestroyOrderTable> getDestroyOrderTablesbyId(String id);
	public List<DestroyOrderTable> getDestroyOrderTablesbyUser(String user);
	public List<DestroyOrderTable> getDestroyOrderTablesbyBuyer(String buyer);
	public List<DestroyOrderTable> getDestroyOrderTablesbyTime(String time);
	public List<DestroyOrderTable> getUnstartDestroyOrderTablesbyBuyer(String buyer);
	public List<DestroyOrderTable> getStartedDestroyOrderTablesbyBuyer(String buyer);
	public String getBuyerbyTableId(String tableid);
	
	public List<DestroyOrderContent> getDestroyOrderContentbyTableId(String tableid);
	public void setDestroyOrderStateStart(String tableid);
	public void setDestroyOrderContentFinished(@Param("id")String id, @Param("price")String price, @Param("source")String source);
	public void setDestroyOrderState(@Param("id")String id, @Param("state")int state);
}
