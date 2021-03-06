package com.bsb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bsb.dao.WarehouseMapper;
import com.bsb.model.WarehouseState;
import com.bsb.model.WarehouseAlter;
import com.bsb.model.WarehouseControl;
import com.bsb.model.WarehouseSamplestate;
import com.bsb.service.WarehouseService;

@Service("WarehouseService")
public class WarehouseServiceImpl implements WarehouseService{
	@Autowired
	private WarehouseMapper warehouseMapper;
	
	@Override
	public List<WarehouseAlter> FindAlter() {
		return warehouseMapper.FindAlter();
	}
	
	@Override
	public List<WarehouseAlter> FindAlterByName(String name){
		return warehouseMapper.FindAlterByName(name);
	}
	
	@Override
	public List<WarehouseAlter> SampleStore(String code, String name,String alter,String reason,String operator,int num, String time){
		return warehouseMapper.SampleStore(code, name, alter, reason, operator, num, time);
	}
	
	@Override
	public List<WarehouseControl> FindControl() {
		return warehouseMapper.FindControl();
	}
	
	@Override
	public List<WarehouseControl> SampleStore2(String name,int num,String con,String area,String time,String note){
		return warehouseMapper.SampleStore2(name, num, con, area,time, note);
	}
	
	@Override
	public List<WarehouseControl> findControlByName(String name){
		name = '%' + name + '%';
		return warehouseMapper.findControlByName(name);
	}
	
	@Override
	public List<WarehouseControl> findControlByCondition(String condition){
		condition = '%' + condition + '%';
		return warehouseMapper.findControlByCondition(condition);
	}
	
	@Override
	public List<WarehouseControl> findControlByArea(String area){
		area = '%' + area + '%';
		return warehouseMapper.findControlByArea(area);
	}
	
	@Override
	public List<WarehouseControl> findControlByTime(String time){
		time = '%' + time + '%';
		return warehouseMapper.findControlByTime(time);
	}
	
	@Override
	public void setWarehousetotal(String warehouse,int normal,int refrigerate,int freeze){
		warehouseMapper.setWarehousetotal(warehouse,normal,refrigerate,freeze);
	}
	
	@Override
	public List<WarehouseState> FindState(){
		return warehouseMapper.FindState();
	}
	
	@Override
	public List<WarehouseSamplestate> FindState2(){
		return warehouseMapper.FindState2();
	}
	
	@Override
	public Integer getAlterNum() {
		return warehouseMapper.getAlterNum();
	}
	
	@Override
	public List<WarehouseState> congestioncontrol(){
		return warehouseMapper.congestioncontrol();
	}
	
	@Override
	public List<WarehouseSamplestate> congestioncontrol2(){
		return warehouseMapper.congestioncontrol2();
	}
}
