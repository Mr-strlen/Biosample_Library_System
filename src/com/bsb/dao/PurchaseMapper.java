package com.bsb.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.bsb.model.PurchaseOrderContent;
import com.bsb.model.PurchaseOrderTable;
import com.bsb.model.PurchaseRequestContent;
import com.bsb.model.PurchaseRequestTable;

@Mapper
public interface PurchaseMapper {
	public List<PurchaseRequestTable> getAllPurchaseRequestTables();
	public List<PurchaseRequestTable> getUncheckedPurchaseRequestTables();
	public List<PurchaseRequestTable> getPassedPurchaseRequestTables();
	public List<PurchaseRequestTable> getUnpassedPurchaseRequestTables();
	public List<PurchaseRequestTable> getPurchaseRequestTablesbyId(String id);
	public List<PurchaseRequestTable> getPurchaseRequestTablesbyUser(String user);
	public List<PurchaseRequestTable> getPurchaseRequestTablesbyTime(String time);
	
	public List<PurchaseRequestContent> getPurchaseRequestContentbyTableId(String tableid);
	public void setPurchaseRequestContentCheckState(@Param("id")String id, @Param("state")int state, @Param("reason")String reason);
	public void setPurchaseRequestCheckState(@Param("id")String id, @Param("state")int state);
	
	public String getBuyerId();
	public void addBuyerNum(String id);
	
	public void createPurchaseOrder(@Param("id")String id, @Param("user")String user, @Param("buyer")String buyer);
	public void createPurchaseOrderContent(@Param("id")String id, @Param("name")String name, @Param("number")int number);
	public List<PurchaseOrderTable> getAllPurchaseOrderTables();
	public List<PurchaseOrderTable> getUnstartPurchaseOrderTables();
	public List<PurchaseOrderTable> getStartedPurchaseOrderTables();
	public List<PurchaseOrderTable> getFinishedPurchaseOrderTables();
	public List<PurchaseOrderTable> getUnreimbursedPurchaseOrderTables();
	public List<PurchaseOrderTable> getReimbursingPurchaseOrderTables();
	public List<PurchaseOrderTable> getReimbursedPurchaseOrderTables();
	public List<PurchaseOrderTable> getPurchaseOrderTablesbyId(String id);
	public List<PurchaseOrderTable> getPurchaseOrderTablesbyUser(String user);
	public List<PurchaseOrderTable> getPurchaseOrderTablesbyBuyer(String buyer);
	public List<PurchaseOrderTable> getPurchaseOrderTablesbyTime(String time);
	public List<PurchaseOrderTable> getUnstartPurchaseOrderTablesbyBuyer(String buyer);
	public List<PurchaseOrderTable> getStartedPurchaseOrderTablesbyBuyer(String buyer);
	public String getBuyerbyTableId(String tableid);
	
	public List<PurchaseOrderContent> getPurchaseOrderContentbyTableId(String tableid);
	public void setPurchaseOrderStateStart(String tableid);
	public void setPurchaseOrderContentFinished(@Param("id")String id, @Param("price")String price, @Param("source")String source);
	public void setPurchaseOrderState(@Param("id")String id, @Param("state")int state);
}
