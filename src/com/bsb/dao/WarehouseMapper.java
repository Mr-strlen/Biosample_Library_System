package com.bsb.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.bsb.model.WarehouseAlter;
import com.bsb.model.WarehouseControl;
import com.bsb.model.WarehouseState;
import com.bsb.model.WarehouseSamplestate;

@Mapper
public interface WarehouseMapper {
	public List<WarehouseAlter> FindAlter();
	public List<WarehouseAlter> FindAlterByName(String name);
	public List<WarehouseAlter> FindSampleAlter();
	public List<WarehouseAlter> SampleStore(@Param("code")String code, @Param("name")String name, @Param("alter")String alter,@Param("reason")String reason,@Param("num")int num, @Param("time")String time);
	public List<WarehouseControl> SampleStore2(@Param("name")String name,@Param("num")int num,@Param("con")String con,@Param("area")String area);
	public List<WarehouseControl> FindControl();
	public List<WarehouseControl> findControlByName(String name);
	public List<WarehouseControl> findControlByCondition(String condition);
	public List<WarehouseControl> findControlByArea(String area);
	public List<WarehouseControl> findControlByTime(String time);
	public void setWarehousetotal();
	public List<WarehouseState> FindState();
	public List<WarehouseSamplestate> FindState2();
	public Integer getAlterNum();
}

