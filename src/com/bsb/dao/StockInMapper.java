package com.bsb.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.bsb.model.StockInAppdetail;
import com.bsb.model.StockInAppsum;
import com.bsb.model.StockInRecord;

@Mapper
public interface StockInMapper {
	public List<StockInAppsum> ShowAppsum(int state);
	public int ShowAppsum();
	
	
}
