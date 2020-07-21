package com.bsb.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.bsb.model.CheckTable;
import com.bsb.model.CheckSampleTable;

@Mapper
public interface CheckMapper {
	public List<CheckTable> findCheck();
	public List<CheckSampleTable> findAllCheckSample();
	public List<CheckSampleTable> findSamplebyid(int id);
	public List<CheckTable> creatCheck(@Param("id") String check_id, @Param("ctt") String check_ctt, @Param("wh") String check_wh, @Param("ct") String check_ct, @Param("dp") String check_dp);
	public List<CheckSampleTable> creatSample(@Param("sid") String sample_id, @Param("pid") String position_id, @Param("cid") String check_id);
	public List<CheckSampleTable> creatComp(@Param("sid") String sample_id);
	public String findSampleStatebyPosition(@Param("pid") String position_id);
	public String findSampleIdbyPosition(@Param("pid") String position_id);
	public void setSampleState(@Param("pid") String position_id, @Param("dp")String dp);
	public void setCheckState(@Param("cid")String check_id);
}
