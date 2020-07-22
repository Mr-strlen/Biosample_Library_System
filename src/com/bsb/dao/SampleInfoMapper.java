package com.bsb.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.bsb.model.SampleInfoTable;
import com.bsb.model.SampleStatisticsTable;

@Mapper
public interface SampleInfoMapper {
	public List<SampleInfoTable> getAllInfoTables();
	public List<SampleInfoTable> NameQueryTables(String name);
	public List<SampleInfoTable> TypeQueryTables(String type);
	public List<SampleInfoTable> AuditorQueryTables(String auditor);
	public List<SampleInfoTable> SourceQueryTables(String source);
	public List<SampleInfoTable> TimeQueryTables(String time);
	public List<SampleInfoTable> PositionQueryTables(String position);
	public String GetUnusedPosition(String type);
	public String GetUnusedNumByType(String type);
	public String GetNumByName(String name);
	public String GetNumBySource(String source);
	public String GetRestNum(String type);
	
	public void DeletRecordByName(String name);
	public void DeletRecordByPosition(String position);
	public void DeletRecordById(String id);
	
	public List<SampleStatisticsTable> GroupByName();
	public List<SampleStatisticsTable> GroupByType();
	public List<SampleStatisticsTable> GroupByAuditor();
	public List<SampleStatisticsTable> GroupBySource();
}
