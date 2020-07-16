package com.bsb.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bsb.model.WarehouseAlter;
import com.bsb.model.WarehouseControl;

public interface WarehouseService {
	public List<WarehouseAlter> FindAlter();
	public List<WarehouseAlter> SampleStore(String code, String name,String Alter,String reason,int num, String time);
	public List<WarehouseControl> FindControl();
}
