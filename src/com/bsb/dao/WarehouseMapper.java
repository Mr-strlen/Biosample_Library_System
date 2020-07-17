package com.bsb.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.bsb.model.WarehouseAlter;
import com.bsb.model.WarehouseControl;

@Mapper
public interface WarehouseMapper {
	public List<WarehouseAlter> FindAlter();
	public List<WarehouseAlter> SampleStore(@Param("code")String code, @Param("name")String name, @Param("alter")String alter,@Param("reason")String reason,@Param("num")int num, @Param("time")String time);
	public List<WarehouseControl> FindControl();
}

