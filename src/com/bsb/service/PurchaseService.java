package com.bsb.service;

import java.util.List;

import com.bsb.model.PurchaseOrderContent;
import com.bsb.model.PurchaseOrderTable;
import com.bsb.model.PurchaseRequestContent;
import com.bsb.model.PurchaseRequestTable;

public interface PurchaseService {
	public List<PurchaseRequestTable> getAllPurchaseRequestTables();
	public List<PurchaseRequestTable> getUncheckedPurchaseRequestTables();
	public List<PurchaseRequestTable> getPassedPurchaseRequestTables();
	public List<PurchaseRequestTable> getUnpassedPurchaseRequestTables();
	public List<PurchaseRequestTable> getPurchaseRequestTablesbyId(String id);
	public List<PurchaseRequestTable> getPurchaseRequestTablesbyUser(String user);
	public List<PurchaseRequestTable> getPurchaseRequestTablesbyTime(String time);
	
	public List<PurchaseRequestContent> getPurchaseRequestContentbyTableId(String tableid);
	public void setPurchaseRequestContentCheckState(String id, int state, String reason);
	public void setPurchaseRequestCheckState(String id, int state);
	
	public String getBuyerId();
	public void addBuyerNum(String id);
	
	public String createPurchaseOrder(String user);
	public void createPurchaseOrderContent(String id, String name, int number);
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
	public void setPurchaseOrderContentFinished(String string, String string2, String string3);
	public void setPurchaseOrderState(String tableid, int state);
}
