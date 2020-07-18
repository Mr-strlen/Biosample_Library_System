package com.bsb.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bsb.model.WarehouseState;
import com.bsb.model.WarehouseAlter;
import com.bsb.model.WarehouseControl;

public interface WarehouseService {
	public List<WarehouseAlter> FindAlter();
	public List<WarehouseAlter> SampleStore(String code, String name,String alter,String reason,int num, String time);
	public List<WarehouseControl> SampleStore2(String name, String date,String con,String area);
	public List<WarehouseControl> FindControl();
	public List<WarehouseState> FindState();
	public void setWarehouseState(String date,String area, int nums);
}
