package com.bsb.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bsb.dao.DestroyMapper;
import com.bsb.model.DestroyOrderContent;
import com.bsb.model.DestroyOrderTable;
import com.bsb.model.DestroyRequestContent;
import com.bsb.model.DestroyRequestTable;
import com.bsb.service.DestroyService;

@Service("DestroyService")
public class DestroyServiceImpl implements DestroyService{

	@Autowired
	private DestroyMapper DestroyMapper;
	
	@Override
	public List<DestroyRequestTable> getAllDestroyRequestTables() {
		return DestroyMapper.getAllDestroyRequestTables();
	}

	@Override
	public List<DestroyRequestTable> getUncheckedDestroyRequestTables() {
		return DestroyMapper.getUncheckedDestroyRequestTables();
	}

	@Override
	public List<DestroyRequestTable> getPassedDestroyRequestTables() {
		return DestroyMapper.getPassedDestroyRequestTables();
	}

	@Override
	public List<DestroyRequestTable> getUnpassedDestroyRequestTables() {
		return DestroyMapper.getUnpassedDestroyRequestTables();
	}

	@Override
	public List<DestroyRequestTable> getDestroyRequestTablesbyId(String id) {
		id = '%' + id + '%';
		return DestroyMapper.getDestroyRequestTablesbyId(id);
	}

	@Override
	public List<DestroyRequestTable> getDestroyRequestTablesbyUser(String user) {
		user = '%' + user + '%';
		return DestroyMapper.getDestroyRequestTablesbyUser(user);
	}

	@Override
	public List<DestroyRequestTable> getDestroyRequestTablesbyTime(String time) {
		time = '%' + time + '%';
		return DestroyMapper.getDestroyRequestTablesbyTime(time);
	}

	@Override
	public List<DestroyRequestContent> getDestroyRequestContentbyTableId(String tableid) {
		return DestroyMapper.getDestroyRequestContentbyTableId(tableid);
	}

	@Override
	public void setDestroyRequestContentCheckState(String id, int state, String reason) {
		DestroyMapper.setDestroyRequestContentCheckState(id, state, reason);
	}

	@Override
	public void setDestroyRequestCheckState(String id, int state) {
		DestroyMapper.setDestroyRequestCheckState(id, state);
	}

	@Override
	public String getBuyerId() {
		return DestroyMapper.getBuyerId();
	}

	@Override
	public String createDestroyOrder(String user) {
		SimpleDateFormat sFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		String id = sFormat.format(new Date()) + user;
		String buyer = DestroyMapper.getBuyerId();
		DestroyMapper.addBuyerNum(buyer);
		DestroyMapper.createDestroyOrder(id, user, buyer);
		return id;
	}

	@Override
	public void addBuyerNum(String id) {
		DestroyMapper.addBuyerNum(id);
	}

	@Override
	public void createDestroyOrderContent(String id, String name, int number) {
		DestroyMapper.createDestroyOrderContent(id, name, number);
	}

	@Override
	public List<DestroyOrderTable> getAllDestroyOrderTables() {
		return DestroyMapper.getAllDestroyOrderTables();
	}

	@Override
	public List<DestroyOrderTable> getUnstartDestroyOrderTables() {
		return DestroyMapper.getUnstartDestroyOrderTables();
	}

	@Override
	public List<DestroyOrderTable> getStartedDestroyOrderTables() {
		return DestroyMapper.getStartedDestroyOrderTables();
	}

	@Override
	public List<DestroyOrderTable> getFinishedDestroyOrderTables() {
		return DestroyMapper.getFinishedDestroyOrderTables();
	}
	
	@Override
	public List<DestroyOrderTable> getUnreimbursedDestroyOrderTables() {
		return DestroyMapper.getUnreimbursedDestroyOrderTables();
	}

	@Override
	public List<DestroyOrderTable> getReimbursingDestroyOrderTables() {
		return DestroyMapper.getReimbursingDestroyOrderTables();
	}

	@Override
	public List<DestroyOrderTable> getReimbursedDestroyOrderTables() {
		return DestroyMapper.getReimbursedDestroyOrderTables();
	}

	@Override
	public List<DestroyOrderContent> getDestroyOrderContentbyTableId(String tableid) {
		return DestroyMapper.getDestroyOrderContentbyTableId(tableid);
	}

	@Override
	public List<DestroyOrderTable> getDestroyOrderTablesbyId(String id) {
		id ='%' + id + '%';
		return DestroyMapper.getDestroyOrderTablesbyId(id);
	}

	@Override
	public List<DestroyOrderTable> getDestroyOrderTablesbyUser(String user) {
		user ='%' + user + '%';
		return DestroyMapper.getDestroyOrderTablesbyUser(user);
	}

	@Override
	public List<DestroyOrderTable> getDestroyOrderTablesbyBuyer(String buyer) {
		buyer ='%' + buyer + '%';
		return DestroyMapper.getDestroyOrderTablesbyBuyer(buyer);
	}

	@Override
	public List<DestroyOrderTable> getDestroyOrderTablesbyTime(String time) {
		time ='%' + time + '%';
		return DestroyMapper.getDestroyOrderTablesbyTime(time);
	}

	@Override
	public List<DestroyOrderTable> getUnstartDestroyOrderTablesbyBuyer(String buyer) {
		return DestroyMapper.getUnstartDestroyOrderTablesbyBuyer(buyer);
	}

	@Override
	public List<DestroyOrderTable> getStartedDestroyOrderTablesbyBuyer(String buyer) {
		return DestroyMapper.getStartedDestroyOrderTablesbyBuyer(buyer);
	}

	@Override
	public void setDestroyOrderStateStart(String tableid) {
		DestroyMapper.setDestroyOrderStateStart(tableid);
	}

	@Override
	public String getBuyerbyTableId(String tableid) {
		return DestroyMapper.getBuyerbyTableId(tableid);
	}

	@Override
	public void setDestroyOrderContentFinished(String id, String price, String source) {
		DestroyMapper.setDestroyOrderContentFinished(id, price, source);
	}

	@Override
	public void setDestroyOrderState(String tableid, int state) {
		DestroyMapper.setDestroyOrderState(tableid, state);
	}

}
