package com.bsb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bsb.dao.WarehouseMapper;
import com.bsb.model.WarehouseAlter;
import com.bsb.model.WarehouseControl;

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
	public List<WarehouseAlter> SampleStore(String code, String name,String alter,String reason,int num, String time){
		return warehouseMapper.SampleStore(code, name, alter, reason, num, time);
	}
	
	@Override
	public List<WarehouseControl> FindControl() {
		return warehouseMapper.FindControl();
	}
	
	@Override
	public List<WarehouseControl> SampleStore2(String code, String name, String date,String con,String area, int nums){
		return warehouseMapper.SampleStore2(code, name, date, con, area, nums);
	}
}
