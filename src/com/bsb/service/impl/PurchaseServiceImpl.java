package com.bsb.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bsb.dao.PurchaseMapper;
import com.bsb.model.PurchaseOrderContent;
import com.bsb.model.PurchaseOrderTable;
import com.bsb.model.PurchaseRequestContent;
import com.bsb.model.PurchaseRequestTable;
import com.bsb.service.PurchaseService;

@Service("purchaseService")
public class PurchaseServiceImpl implements PurchaseService{

	@Autowired
	private PurchaseMapper purchaseMapper;
	
	@Override
	public List<PurchaseRequestTable> getAllPurchaseRequestTables() {
		return purchaseMapper.getAllPurchaseRequestTables();
	}

	@Override
	public List<PurchaseRequestTable> getUncheckedPurchaseRequestTables() {
		return purchaseMapper.getUncheckedPurchaseRequestTables();
	}

	@Override
	public List<PurchaseRequestTable> getPassedPurchaseRequestTables() {
		return purchaseMapper.getPassedPurchaseRequestTables();
	}

	@Override
	public List<PurchaseRequestTable> getUnpassedPurchaseRequestTables() {
		return purchaseMapper.getUnpassedPurchaseRequestTables();
	}

	@Override
	public List<PurchaseRequestTable> getPurchaseRequestTablesbyId(String id) {
		id = '%' + id + '%';
		return purchaseMapper.getPurchaseRequestTablesbyId(id);
	}

	@Override
	public List<PurchaseRequestTable> getPurchaseRequestTablesbyUser(String user) {
		user = '%' + user + '%';
		return purchaseMapper.getPurchaseRequestTablesbyUser(user);
	}

	@Override
	public List<PurchaseRequestTable> getPurchaseRequestTablesbyTime(String time) {
		time = '%' + time + '%';
		return purchaseMapper.getPurchaseRequestTablesbyTime(time);
	}

	@Override
	public List<PurchaseRequestContent> getPurchaseRequestContentbyTableId(String tableid) {
		return purchaseMapper.getPurchaseRequestContentbyTableId(tableid);
	}

	@Override
	public void setPurchaseRequestContentCheckState(String id, int state, String reason) {
		purchaseMapper.setPurchaseRequestContentCheckState(id, state, reason);
	}

	@Override
	public void setPurchaseRequestCheckState(String id, int state) {
		purchaseMapper.setPurchaseRequestCheckState(id, state);
	}

	@Override
	public String getBuyerId() {
		return purchaseMapper.getBuyerId();
	}

	@Override
	public String createPurchaseOrder(String user) {
		SimpleDateFormat sFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		String id = sFormat.format(new Date());
		String buyer = purchaseMapper.getBuyerId();
		purchaseMapper.addBuyerNum(buyer);
		purchaseMapper.createPurchaseOrder(id, user, buyer);
		return id;
	}

	@Override
	public void addBuyerNum(String id) {
		purchaseMapper.addBuyerNum(id);
	}

	@Override
	public void createPurchaseOrderContent(String id, String name, int number) {
		purchaseMapper.createPurchaseOrderContent(id, name, number);
	}

	@Override
	public List<PurchaseOrderTable> getAllPurchaseOrderTables() {
		return purchaseMapper.getAllPurchaseOrderTables();
	}

	@Override
	public List<PurchaseOrderTable> getUnstartPurchaseOrderTables() {
		return purchaseMapper.getUnstartPurchaseOrderTables();
	}

	@Override
	public List<PurchaseOrderTable> getStartedPurchaseOrderTables() {
		return purchaseMapper.getStartedPurchaseOrderTables();
	}

	@Override
	public List<PurchaseOrderTable> getFinishedPurchaseOrderTables() {
		return purchaseMapper.getFinishedPurchaseOrderTables();
	}
	
	@Override
	public List<PurchaseOrderTable> getUnreimbursedPurchaseOrderTables() {
		return purchaseMapper.getUnreimbursedPurchaseOrderTables();
	}

	@Override
	public List<PurchaseOrderTable> getReimbursingPurchaseOrderTables() {
		return purchaseMapper.getReimbursingPurchaseOrderTables();
	}

	@Override
	public List<PurchaseOrderTable> getReimbursedPurchaseOrderTables() {
		return purchaseMapper.getReimbursedPurchaseOrderTables();
	}

	@Override
	public List<PurchaseOrderContent> getPurchaseOrderContentbyTableId(String tableid) {
		return purchaseMapper.getPurchaseOrderContentbyTableId(tableid);
	}

	@Override
	public List<PurchaseOrderTable> getPurchaseOrderTablesbyId(String id) {
		id ='%' + id + '%';
		return purchaseMapper.getPurchaseOrderTablesbyId(id);
	}

	@Override
	public List<PurchaseOrderTable> getPurchaseOrderTablesbyUser(String user) {
		user ='%' + user + '%';
		return purchaseMapper.getPurchaseOrderTablesbyUser(user);
	}

	@Override
	public List<PurchaseOrderTable> getPurchaseOrderTablesbyBuyer(String buyer) {
		buyer ='%' + buyer + '%';
		return purchaseMapper.getPurchaseOrderTablesbyBuyer(buyer);
	}

	@Override
	public List<PurchaseOrderTable> getPurchaseOrderTablesbyTime(String time) {
		time ='%' + time + '%';
		return purchaseMapper.getPurchaseOrderTablesbyTime(time);
	}

	@Override
	public List<PurchaseOrderTable> getUnstartPurchaseOrderTablesbyBuyer(String buyer) {
		return purchaseMapper.getUnstartPurchaseOrderTablesbyBuyer(buyer);
	}

	@Override
	public List<PurchaseOrderTable> getStartedPurchaseOrderTablesbyBuyer(String buyer) {
		return purchaseMapper.getStartedPurchaseOrderTablesbyBuyer(buyer);
	}

	@Override
	public void setPurchaseOrderStateStart(String tableid) {
		purchaseMapper.setPurchaseOrderStateStart(tableid);
	}

	@Override
	public String getBuyerbyTableId(String tableid) {
		return purchaseMapper.getBuyerbyTableId(tableid);
	}

	@Override
	public void setPurchaseOrderContentFinished(String id, String price, String source) {
		purchaseMapper.setPurchaseOrderContentFinished(id, price, source);
	}

	@Override
	public void setPurchaseOrderState(String tableid, int state) {
		purchaseMapper.setPurchaseOrderState(tableid, state);
	}

}
