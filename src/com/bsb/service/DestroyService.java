package com.bsb.service;

import java.util.List;

import com.bsb.model.DestroyOrderContent;
import com.bsb.model.DestroyOrderTable;
import com.bsb.model.DestroyRequestContent;
import com.bsb.model.DestroyRequestTable;

public interface DestroyService {
	public List<DestroyRequestTable> getAllDestroyRequestTables();
	public List<DestroyRequestTable> getUncheckedDestroyRequestTables();
	public List<DestroyRequestTable> getPassedDestroyRequestTables();
	public List<DestroyRequestTable> getUnpassedDestroyRequestTables();
	public List<DestroyRequestTable> getDestroyRequestTablesbyId(String id);
	public List<DestroyRequestTable> getDestroyRequestTablesbyUser(String user);
	public List<DestroyRequestTable> getDestroyRequestTablesbyTime(String time);
	
	public List<DestroyRequestContent> getDestroyRequestContentbyTableId(String tableid);
	public void setDestroyRequestContentCheckState(String id, int state, String reason);
	public void setDestroyRequestCheckState(String id, int state);
	
	public String getBuyerId();
	public void addBuyerNum(String id);
	
	public String createDestroyOrder(String user);
	public void createDestroyOrderContent(String id, String name, int number);
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
	public void setDestroyOrderContentFinished(String string, String string2, String string3);
	public void setDestroyOrderState(String tableid, int state);
}
