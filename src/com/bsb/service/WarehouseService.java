package com.bsb.service;

import java.util.List;

import com.bsb.model.WarehouseState;
import com.bsb.model.WarehouseAlter;
import com.bsb.model.WarehouseControl;
import com.bsb.model.WarehouseSamplestate;

public interface WarehouseService {
	//获取变动表
	public List<WarehouseAlter> FindAlter();
	//通过名字查询库存变动表
	public List<WarehouseAlter> FindAlterByName(String name);
	//获取变动编号
	public Integer getAlterNum();
	//插入库存变动表信息
	public List<WarehouseAlter> SampleStore(String code, String name,String alter,String reason,String operator,int num, String time);
	//插入库存控制表信息
	public List<WarehouseControl> SampleStore2(String name,int num,String con,String area,String time,String note);
	//库存控制表
	public List<WarehouseControl> FindControl();
	//通过名字查询库存控制表
	public List<WarehouseControl> findControlByName(String name);
	//通过存储条件查询库存控制表
	public List<WarehouseControl> findControlByCondition(String condition);
	//通过存储区域查询库存控制表
	public List<WarehouseControl> findControlByArea(String area);
	//通过时间查询库存控制表
	public List<WarehouseControl> findControlByTime(String time);
	//查询按照区域划分的库位状态表
	public List<WarehouseState> FindState();
	//更改仓库大小
	public void setWarehousetotal(String warehouse,int normal,int refrigerate,int freeze);
	//查询按照条件划分的库位状态表
	public List<WarehouseSamplestate> FindState2();	
	//获取处于拥塞的按照区域划分的库位状态表
	public List<WarehouseState> congestioncontrol();
	//获取处于拥塞的按照条件划分的库位状态表
	public List<WarehouseSamplestate> congestioncontrol2();
}
