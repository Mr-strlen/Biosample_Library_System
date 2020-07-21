package com.bsb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bsb.service.StockInService;
//import com.bsb.service.SampleInfoService;
import com.bsb.service.WarehouseService;

@Controller
@RequestMapping("/stockin")
public class StockInController {
	@Autowired
    private StockInService StockInService;
//	@Autowired
//	private SampleInfoService sampleinfoService;
	@Autowired
    private WarehouseService warehouseService;
	
	//审核申请界面
	@RequestMapping("/stockin_checking")
    public ModelAndView showappchecking(){
        ModelAndView mv = new ModelAndView("StockInAppChecking");
        mv.addObject("stockin_checking",StockInService.ShowAppsum(Integer.valueOf("0")));
        return mv;
    }
	
	//已审核申请界面
	@RequestMapping("/stockin_checked")
    public ModelAndView showappchecked(){
        ModelAndView mv = new ModelAndView("StockInAppChecked");
        mv.addObject("stockin_checked",StockInService.ShowAppsum(Integer.valueOf("1")));
        return mv;
    }
	
	//申请详情
	@RequestMapping("/stockin_appdetail")
    public ModelAndView showappdetail(String id){
        ModelAndView mv = new ModelAndView("StockInAppdetail");
        mv.addObject("stockin_appdetail",StockInService.ShowAppdetail(Integer.valueOf(id)));
        return mv;
    }
	
	//入库记录
	@RequestMapping("/stockin_record")
    public ModelAndView showrecord(){
        ModelAndView mv = new ModelAndView("StockInRecord");
        mv.addObject("stockin_record",StockInService.ShowRecord());
        mv.addObject("appnotfinished",StockInService.GetNotFinishedApp());
        return mv;
    }
	
	//库存详细信息
	@RequestMapping("/stockin_check")
    public ModelAndView showcheck(String id){
        ModelAndView mv = new ModelAndView("StockInCheck");
        mv.addObject("stockin_appdetail",StockInService.ShowAppdetail(Integer.valueOf(id)));
        mv.addObject("areastate",warehouseService.FindState());
        return mv;
    }
	
	//进行审核
	@RequestMapping("/stockin_checksubmit")
	public ModelAndView submitcheck(int id, String name, String reason, String result, String auditor) {
		StockInService.Appcheck(Integer.valueOf(id), name, result, reason, auditor);
		return(new ModelAndView("redirect:stockin_checking"));
	}
	
	
	//申请记录提交
	@RequestMapping("/stockin_recordsubmit")
	public ModelAndView submitrecord( int application_id,  String sample_id,int sample_quantity, String sample_name) {
		int id = StockInService.GetNextRecordId();
		StockInService.Recordsubmit(id, application_id, sample_quantity, sample_id, sample_name);
		return(new ModelAndView("redirect:stockin_record"));
	}
	
	//显示已通过未登记申请
	@RequestMapping("/stockin_appnotfinished")
    public ModelAndView GetNotFinishedApp(){
		ModelAndView mv = new ModelAndView("StockInRecord");
        mv.addObject("appnotfinished",StockInService.GetNotFinishedApp());
        return mv;
    }
	
	//入库记录查询
	@RequestMapping("/stockin_findrecord")
    public ModelAndView findrecord(String sample_id){
		//System.out.println(sample_id);
		ModelAndView mv = new ModelAndView("StockInRecord");
        mv.addObject("stockin_record",StockInService.ShowRecordbySample_id(sample_id));
        return mv;
    }
	
	//入库申请填写
	@RequestMapping("/stockin_app")
    public ModelAndView app(){
		ModelAndView mv = new ModelAndView("StockInAppsubmit");
        mv.addObject("stockin_nextappid",StockInService.GetNextAppId());        
        return mv;
    }
	
	//入库申请提交
	@RequestMapping("/stockin_appsubmit")
    public ModelAndView submitapp(int id, String applicant, String name,String size,String request){				
        StockInService.Appsubmit(id, applicant, name, size, request);
        return(new ModelAndView("StockInApplySuccess"));
    }
	
}
