package com.bsb.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bsb.model.WarehouseState;
import com.bsb.model.WarehouseAlter;
import com.bsb.model.WarehouseControl;
import com.bsb.model.WarehouseSamplestate;

public interface WarehouseService {
	public List<WarehouseAlter> FindAlter();
	public List<WarehouseAlter> FindAlterByName(String name);
	public Integer getAlterNum();
	public List<WarehouseAlter> SampleStore(String code, String name,String alter,String reason,int num, String time);
	public List<WarehouseControl> SampleStore2(String name,int num,String con,String area);
	public List<WarehouseControl> FindControl();
	public List<WarehouseControl> findControlByName(String name);
	public List<WarehouseControl> findControlByCondition(String condition);
	public List<WarehouseControl> findControlByArea(String area);
	public List<WarehouseControl> findControlByTime(String time);
	public List<WarehouseState> FindState();
	public void setWarehouseState(String date,String area, int nums);
	public List<WarehouseSamplestate> FindState2();	
}
