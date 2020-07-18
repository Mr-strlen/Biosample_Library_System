package com.bsb.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.bsb.model.WarehouseAlter;
import com.bsb.model.WarehouseControl;
import com.bsb.model.WarehouseState;

@Mapper
public interface WarehouseMapper {
	public List<WarehouseAlter> FindAlter();
	public List<WarehouseAlter> FindSampleAlter();
	public List<WarehouseAlter> SampleStore(@Param("code")String code, @Param("name")String name, @Param("alter")String alter,@Param("reason")String reason,@Param("num")int num, @Param("time")String time);
	public List<WarehouseControl> SampleStore2(@Param("name")String name, @Param("date")String date,@Param("con")String con,@Param("area")String area);
	public List<WarehouseControl> FindControl();
	public void setWarehouseState(@Param("date")String date,@Param("area")String area, @Param("nums")int nums);
	public List<WarehouseState> FindState();
}

