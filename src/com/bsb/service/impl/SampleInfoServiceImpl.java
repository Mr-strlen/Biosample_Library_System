package com.bsb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bsb.dao.SampleInfoMapper;
import com.bsb.model.SampleInfoTable;
import com.bsb.model.SampleStatisticsTable;
import com.bsb.service.SampleInfoService;

@Service("SampleInfoService")
public class SampleInfoServiceImpl implements SampleInfoService{

	@Autowired
	private SampleInfoMapper sampleinfoMapper;
	
	@Override
	public String GetUnusedPosition(String type){
		return sampleinfoMapper.GetUnusedPosition(type);
	}
	
	@Override
	public String GetRestNum(String type) {
		return sampleinfoMapper.GetRestNum(type);
	}
	@Override
	public String GetNumByName(String name){
		return sampleinfoMapper.GetNumByName(name);
	}
	@Override
	public String GetUnusedNumByType(String type){
		return sampleinfoMapper.GetUnusedNumByType(type);
	}
	@Override
	public String GetNumBySource(String source){
		return sampleinfoMapper.GetNumBySource(source);
	}
	@Override
	public List<SampleInfoTable> getAllInfoTables() {
		return sampleinfoMapper.getAllInfoTables();
	}
	@Override
	public List<SampleInfoTable> NameQueryTables(String name) {
		name = '%' + name + '%';
		return sampleinfoMapper.NameQueryTables(name);
	}
	@Override
	public List<SampleInfoTable> TypeQueryTables(String type) {
		return sampleinfoMapper.TypeQueryTables(type);
	}
	@Override
	public List<SampleInfoTable> AuditorQueryTables(String auditor) {
		auditor = '%' + auditor + '%';
		return sampleinfoMapper.AuditorQueryTables(auditor);
	}
	@Override
	public List<SampleInfoTable> SourceQueryTables(String source) {
		source = '%' + source + '%';
		return sampleinfoMapper.SourceQueryTables(source);
	}
	@Override
	public List<SampleInfoTable> TimeQueryTables(String time) {
		time = '%' + time + '%';
		return sampleinfoMapper.TimeQueryTables(time);
	}
	@Override
	public List<SampleInfoTable> PositionQueryTables(String position) {
		position = '%' + position + '%';
		return sampleinfoMapper.PositionQueryTables(position);
	}
	
	
	@Override
	public List<SampleStatisticsTable> GroupByName() {
		return sampleinfoMapper.GroupByName();
	}
	@Override
	public List<SampleStatisticsTable> GroupByType() {
		List<SampleStatisticsTable> list = sampleinfoMapper.GroupByType();
		for(SampleStatisticsTable i:list){
			if(Integer.valueOf(i.getTaxonomy()) == 1){
				i.setTaxonomy("常温");
			}
			else if(Integer.valueOf(i.getTaxonomy()) == 2){
				i.setTaxonomy("冷冻");
			}
			else if(Integer.valueOf(i.getTaxonomy()) == 3){
				i.setTaxonomy("冷藏");
			}
		}
		return list;
	}
	@Override
	public List<SampleStatisticsTable> GroupByAuditor() {
		return sampleinfoMapper.GroupByAuditor();
	}
	@Override
	public List<SampleStatisticsTable> GroupBySource(){
		return sampleinfoMapper.GroupBySource();
	}
	
	
	@Override
	public void DeletRecordByName(String name){
		sampleinfoMapper.DeletRecordByName(name);
	}
	@Override
	public void DeletRecordByPosition(String position){
		sampleinfoMapper.DeletRecordByPosition(position);
	}
	@Override
	public void DeletRecordById(String id){
		sampleinfoMapper.DeletRecordById(id);
	}
	
}
