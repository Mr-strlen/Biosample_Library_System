package com.bsb.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bsb.service.DispatchService;
import com.bsb.service.SampleInfoService;

import com.bsb.controller.IndexController;

@Controller
@RequestMapping("/dispatch")
public class DispatchController {
	
	@Autowired
	private DispatchService dispatchService;
	@Autowired
	private SampleInfoService sampleinfoService;
	
	//出库申请
	@RequestMapping("/apply")
	public ModelAndView getApply(){
        ModelAndView mv = new ModelAndView("DispatchApply");
        return mv;
    }
	
	// 申请完成
	@RequestMapping("/apply_deliversum")
	public ModelAndView getApplySum(String applicant, String type, String snum, String condition){
		ModelAndView mv = new ModelAndView("DispatchApply");
		mv.addObject("applicant", applicant);
		mv.addObject("type", type);
		mv.addObject("snum", snum);
		mv.addObject("condition", condition);
		
		String[] types = type.split(",");
		String[] snums = snum.split(",");
		String[] conditions = condition.split(",");

        int anum = dispatchService.getApplyNum();
		anum = anum + 1;
		String order = "DA" + String.valueOf(anum);
		
		String result = "待审核";
		
		for(int i = 0; i < types.length; i++) {
			int num = Integer.valueOf(snums[i]);
			type = types[i];
			condition = conditions[i];
			dispatchService.insertApplyDe(order, type, num, condition, result); 
		}
		
		
		SimpleDateFormat sFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = sFormat.format(new Date());
		
		dispatchService.insertApplySum(order, applicant, time, result);
		JOptionPane.showMessageDialog(null,"申请成功！");
        // 返回界面
        return(new ModelAndView("index"));
    }

	// 待审核申请
	@RequestMapping("/app_checksum")
	public ModelAndView getCheckApp(){
        ModelAndView mv = new ModelAndView("DispatchAppCheckSum");
        mv.addObject("app_checksum",dispatchService.findAppByResult("待审核"));
        return mv;
    }
	// 申请详情
	@RequestMapping("/app_detail")
	public ModelAndView getAppDetail(String type){
        ModelAndView mv = new ModelAndView("DispatchAppDetail");
        mv.addObject("app_detail",dispatchService.findAppDetailByOrder(type));
        return mv;
    }
	// 申请查询
	@RequestMapping("/app_select")
	public ModelAndView getSelectApp(String type, String word){
        ModelAndView mv = new ModelAndView("DispatchAppSelect");
        if(word == "") {
        	mv.addObject("app_select",dispatchService.findAllApp());
        }
        else {
        	if(type == null) {
				mv.addObject("app_select", dispatchService.findAllApp());
				return mv;
			}
			if(Integer.valueOf(type) == 1) {
				mv.addObject("app_select", dispatchService.findAppByOrder(word));
			}
			else if(Integer.valueOf(type) == 2) {
				mv.addObject("app_select", dispatchService.findAppByApplicant(word));
			}
			else if(Integer.valueOf(type) == 3) {
				mv.addObject("app_select", dispatchService.findAppByTime(word));
			}
			else if(Integer.valueOf(type) == 4) {
				mv.addObject("app_select", dispatchService.findAppByResult(word));
			}
			else if(Integer.valueOf(type) == 5) {
				mv.addObject("app_select", dispatchService.findAppByAuditor(word));
			}
        }
        return mv;
    }
	// 审核申请
	@RequestMapping("/app_checkdetail")
    public ModelAndView setCheckDetail(String type){
        ModelAndView mv = new ModelAndView("DispatchAppCheckDetail");
        mv.addObject("app_checkdetail",dispatchService.findAppDetailByOrder(type));
        return mv;
    }
	// 申请审核提交
	@RequestMapping("/app_checksubmit")
	public ModelAndView submitcheck(String order, String type, String result,  String reason_pos, String auditor) {
		//System.out.println(order+" "+type+" "+result+" "+reason_pos);
		String[] orders = order.split(",");
		order = orders[0];
		String[] types = type.split(",");
		String[] results = result.split(",");
		String[] reason_poss = reason_pos.split(",");
		boolean flag = true;
		for(int i = 0; i < types.length; i++) {
			dispatchService.appCheck(order, types[i], results[i], reason_poss[i]);
			if(results[i].equals("未通过")) {
				flag = false;
			}
		}
		if(flag) {
			dispatchService.appCheckFinal(order, "已通过", auditor);
			
			// 向Record新增数据
			int num = dispatchService.getRecordNum();
			num = num + 1;
			String recordorder = "D" + String.valueOf(num);
			
			
			String application_order = order;
			order = recordorder;
			dispatchService.insertRecord(order, application_order, "待完成");
		}
		else {
			dispatchService.appCheckFinal(order, "未通过", auditor);
			
		}	
		return(new ModelAndView("redirect:app_checksum"));
	}
	
	// 待出库订单
	@RequestMapping("/record_opsum")
	public ModelAndView getRecordOpSum(){
        ModelAndView mv = new ModelAndView("DispatchRecordOpSum");
        mv.addObject("record_opsum",dispatchService.findRecordByState("待完成"));
        return mv;
    }
	
	// 出库操作详情
	@RequestMapping("/record_opdetail")
    public ModelAndView setOpDetail(String type){
        ModelAndView mv = new ModelAndView("DispatchRecordOpDetail");
        mv.addObject("record_opdetail",dispatchService.findAppDetailByOrder(type));
        return mv;
    }
	
	// 出库提交
	@RequestMapping("/record_checksubmit")
	public ModelAndView recordSubmitcheck(String application_order, String manager) {
		// 更新记录表
		SimpleDateFormat sFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = sFormat.format(new Date());
		
		String order = dispatchService.getAppOrderByOrder(application_order);
		//System.out.println(order+" "+ time+" "+manager+" "+application_order);
		
		dispatchService.updateRecord(order, time, manager, "已完成");
		
		List<String> ls = dispatchService.getPosByOrder(application_order);
		for(String pos : ls) {
			  
			String[] reason_poss = pos.split(",");
			for(int i = 0; i < reason_poss.length; i++) {
				// 总表中删除
				String position = reason_poss[i];
				System.out.println(position);
				sampleinfoService.DeletRecordByPosition(position);
			}
		}
		
		return(new ModelAndView("redirect:record_opsum"));
	}
	
	// 订单（申请）详情
	@RequestMapping("/record_detail")
	public ModelAndView getRecordDetail(String id, String type){
        ModelAndView mv = new ModelAndView("DispatchRecordDetail");
        mv.addObject("id", id);
        mv.addObject("record_detail",dispatchService.findAppDetailByOrder(type));
        return mv;
    }
	
	// 	出库订单查询
	@RequestMapping("/record_select")
	public ModelAndView getSelectRecord(String type, String word){
        ModelAndView mv = new ModelAndView("DispatchRecordSelect");
        if(word == "") {
        	mv.addObject("record_select",dispatchService.findAllRecord());
        }
        else {
        	if(type == null) {
				mv.addObject("record_select", dispatchService.findAllRecord());
				return mv;
			}
			if(Integer.valueOf(type) == 1) {
				mv.addObject("record_select", dispatchService.findRecordByOrder(word));
			}
			else if(Integer.valueOf(type) == 2) {
				mv.addObject("record_select", dispatchService.findRecordByTime(word));
			}
			else if(Integer.valueOf(type) == 3) {
				mv.addObject("record_select", dispatchService.findRecordByManager(word));
			}
			else if(Integer.valueOf(type) == 4) {
				mv.addObject("record_select", dispatchService.findRecordByState(word));
			}
        }
        return mv;
    }
}