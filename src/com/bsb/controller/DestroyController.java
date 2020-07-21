package com.bsb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bsb.model.DestroyRequestContent;
import com.bsb.service.DestroyService;

@Controller
@RequestMapping("/destroy")
public class DestroyController {
	
	@Autowired
	private DestroyService DestroyService;
	
	@RequestMapping("/request")
	public ModelAndView DestroyRequest(String word, String type) {
		if(word == "") {
			ModelAndView mv = new ModelAndView("DestroyRequest");
			mv.addObject("uncheckeddestroy", DestroyService.getUncheckedDestroyRequestTables());
			mv.addObject("passeddestroy", DestroyService.getPassedDestroyRequestTables());
			mv.addObject("unpasseddestroy", DestroyService.getUnpassedDestroyRequestTables());
			mv.addObject("searchresult", DestroyService.getAllDestroyRequestTables());
			return(mv);
		}
		else {
			ModelAndView mv = new ModelAndView("DestroyRequest");
			mv.addObject("uncheckeddestroy", DestroyService.getUncheckedDestroyRequestTables());
			mv.addObject("passeddestroy", DestroyService.getPassedDestroyRequestTables());
			mv.addObject("unpasseddestroy", DestroyService.getUnpassedDestroyRequestTables());
			if(type == null) {
				mv.addObject("searchresult", DestroyService.getAllDestroyRequestTables());
				return mv;
			}
			if(Integer.valueOf(type) == 1) {
				mv.addObject("searchresult", DestroyService.getDestroyRequestTablesbyId(word));
			}
			else if(Integer.valueOf(type) == 2) {
				mv.addObject("searchresult", DestroyService.getDestroyRequestTablesbyUser(word));
			}
			else if(Integer.valueOf(type) == 3) {
				mv.addObject("searchresult", DestroyService.getDestroyRequestTablesbyTime(word));
			}
			else {
				mv.addObject("searchresult", DestroyService.getAllDestroyRequestTables());
			}
			return(mv);
		}
	}
	
	@RequestMapping("/requestcontent")
	public ModelAndView DestroyRequestContent(String id, String type) {
		ModelAndView mv = new ModelAndView("DestroyRequestContent");
		mv.addObject("contents", DestroyService.getDestroyRequestContentbyTableId(id));
		mv.addObject("id", id);
		mv.addObject("type", type);
		return mv;
	}
	
	@RequestMapping("/requestsubmit")
	public ModelAndView DestroyRequestSubmit(String tableid, String id, String state, String reason) {
		String[] ids = id.split(",");
		String[] states = state.split(",");
		String[] reasons = reason.split(",");
		int ifpass = 1;
		for(int i = 0; i < ids.length; i++) {
			if(Integer.valueOf(states[i]) == 1) {
				DestroyService.setDestroyRequestContentCheckState(ids[i], 1, reasons[i]);
			}
			else if(Integer.valueOf(states[i]) == -1) {
				DestroyService.setDestroyRequestContentCheckState(ids[i], -1, reasons[i]);
				ifpass = -1;
			}
		}
		if(ifpass == 1) {
			DestroyService.setDestroyRequestCheckState(tableid, 1);
			String user = DestroyService.getDestroyRequestTablesbyId(tableid).get(0).getUser();
			String orderid = DestroyService.createDestroyOrder(user);
			List<DestroyRequestContent> DestroyRequest = DestroyService.getDestroyRequestContentbyTableId(tableid);
			for(DestroyRequestContent t:DestroyRequest) {
				DestroyService.createDestroyOrderContent(orderid, t.getName(), t.getNumber());
			}
		}
		else {
			DestroyService.setDestroyRequestCheckState(tableid, -1);
		}
		return(new ModelAndView("redirect:request"));
	}
	
	@RequestMapping("/orders")
	public ModelAndView DestroyOrder(String word, String type) {
		if(word == "") {
			ModelAndView mv = new ModelAndView("DestroyOrder");
			mv.addObject("unstartdestroy", DestroyService.getUnstartDestroyOrderTables());
			mv.addObject("starteddestroy", DestroyService.getStartedDestroyOrderTables());
			mv.addObject("finishedDestroy", DestroyService.getFinishedDestroyOrderTables());
			mv.addObject("searchresult", DestroyService.getAllDestroyOrderTables());
			return(mv);
		}
		else {
			ModelAndView mv = new ModelAndView("DestroyOrder");
			mv.addObject("unstartdestroy", DestroyService.getUnstartDestroyOrderTables());
			mv.addObject("starteddestroy", DestroyService.getStartedDestroyOrderTables());
			mv.addObject("finisheddestroy", DestroyService.getFinishedDestroyOrderTables());
			if(type == null) {
				mv.addObject("searchresult", DestroyService.getAllDestroyOrderTables());
				return mv;
			}
			if(Integer.valueOf(type) == 1) {
				mv.addObject("searchresult", DestroyService.getDestroyOrderTablesbyId(word));
			}
			else if(Integer.valueOf(type) == 2) {
				mv.addObject("searchresult", DestroyService.getDestroyOrderTablesbyUser(word));
			}
			else if(Integer.valueOf(type) == 3) {
				mv.addObject("searchresult", DestroyService.getDestroyOrderTablesbyBuyer(word));
			}
			else if(Integer.valueOf(type) == 4) {
				mv.addObject("searchresult", DestroyService.getDestroyOrderTablesbyTime(word));
			}
			else {
				mv.addObject("searchresult", DestroyService.getAllDestroyOrderTables());
			}
			return(mv);
		}
	}
	
	@RequestMapping("/ordercontent")
	public ModelAndView DestroyOrderContent(String id, String type) {
		ModelAndView mv = new ModelAndView("DestroyOrderContent");
		mv.addObject("contents", DestroyService.getDestroyOrderContentbyTableId(id));
		mv.addObject("id", id);
		mv.addObject("type", type);
		return mv;
	}
	
	@RequestMapping("/orderbuy")
	public ModelAndView DestroyOrderBuy(String buyer) {
		ModelAndView mv = new ModelAndView("DestroyOrderBuy");
		if(buyer == null) {
			mv.addObject("buyer", "null");
		}
		else {
			buyer = 'B' + buyer;
			mv.addObject("buyer", buyer);
			mv.addObject("unstartdestroy", DestroyService.getUnstartDestroyOrderTablesbyBuyer(buyer));
			mv.addObject("starteddestroy", DestroyService.getStartedDestroyOrderTablesbyBuyer(buyer));
		}
		return mv;
	}
	
	@RequestMapping("/ordersubmit")
	public ModelAndView DestroyOrderSubmit(String checked, String type, String state, String tableid, String id, String price, String source) {
		if(type.equals("start")) {
			DestroyService.setDestroyOrderStateStart(tableid);
			String buyer = DestroyService.getBuyerbyTableId(tableid);
			buyer = buyer.substring(1);
			return(new ModelAndView("redirect:orderbuy?buyer=" + buyer));
		}
		if(type.equals("submit")) {
			String[] ids = id.split(",");
			String[] prices = price.split(",");
			String[] sources = source.split(",");
			String[] checkeds = checked.split(",");
			String[] states = state.split(",");
			Boolean isfinish = true;
			for(int i = 0; i < checkeds.length; i++) {
				if(checkeds[i].equals("on")) {
					DestroyService.setDestroyOrderContentFinished(ids[i], prices[i], sources[i]);
				}
				if(checkeds[i].equals("off") && !states[i].equals("已完成")) {
					isfinish = false;
				}
			}
			if(isfinish) {
				DestroyService.setDestroyOrderState(tableid, 2);
			}
			String buyer = DestroyService.getBuyerbyTableId(tableid);
			buyer = buyer.substring(1);
			return(new ModelAndView("redirect:orderbuy?buyer=" + buyer));
		}
		if(type.equals("reimburse")) {
			DestroyService.setDestroyOrderState(tableid, 3);
			return(new ModelAndView("redirect:orderreimburse"));
		}
		return(new ModelAndView("redirect:orders"));
	}
	
	@RequestMapping("/orderreimburse")
	public ModelAndView DestroyOrderReimburse() {
		ModelAndView mv = new ModelAndView("DestroyOrderReimburse");
		mv.addObject("unreimburseddestroy", DestroyService.getUnreimbursedDestroyOrderTables());
		mv.addObject("reimbursingdestroy", DestroyService.getReimbursingDestroyOrderTables());
		mv.addObject("reimburseddestroy", DestroyService.getReimbursedDestroyOrderTables());
		return mv;
	}
	
}
