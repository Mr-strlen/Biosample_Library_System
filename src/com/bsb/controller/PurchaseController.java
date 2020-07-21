package com.bsb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bsb.model.PurchaseRequestContent;
import com.bsb.service.PurchaseService;

@Controller
@RequestMapping("/purchase")
public class PurchaseController {
	
	@Autowired
	private PurchaseService purchaseService;
	
	@RequestMapping("/request")
	public ModelAndView purchaseRequest(String word, String type) {
		if(word == "") {
			ModelAndView mv = new ModelAndView("PurchaseRequest");
			mv.addObject("uncheckedpurchase", purchaseService.getUncheckedPurchaseRequestTables());
			mv.addObject("passedpurchase", purchaseService.getPassedPurchaseRequestTables());
			mv.addObject("unpassedpurchase", purchaseService.getUnpassedPurchaseRequestTables());
			mv.addObject("searchresult", purchaseService.getAllPurchaseRequestTables());
			return(mv);
		}
		else {
			ModelAndView mv = new ModelAndView("PurchaseRequest");
			mv.addObject("uncheckedpurchase", purchaseService.getUncheckedPurchaseRequestTables());
			mv.addObject("passedpurchase", purchaseService.getPassedPurchaseRequestTables());
			mv.addObject("unpassedpurchase", purchaseService.getUnpassedPurchaseRequestTables());
			if(type == null) {
				mv.addObject("searchresult", purchaseService.getAllPurchaseRequestTables());
				return mv;
			}
			if(Integer.valueOf(type) == 1) {
				mv.addObject("searchresult", purchaseService.getPurchaseRequestTablesbyId(word));
			}
			else if(Integer.valueOf(type) == 2) {
				mv.addObject("searchresult", purchaseService.getPurchaseRequestTablesbyUser(word));
			}
			else if(Integer.valueOf(type) == 3) {
				mv.addObject("searchresult", purchaseService.getPurchaseRequestTablesbyTime(word));
			}
			else {
				mv.addObject("searchresult", purchaseService.getAllPurchaseRequestTables());
			}
			return(mv);
		}
	}
	
	@RequestMapping("/requestcontent")
	public ModelAndView purchaseRequestContent(String id, String type) {
		ModelAndView mv = new ModelAndView("PurchaseRequestContent");
		mv.addObject("contents", purchaseService.getPurchaseRequestContentbyTableId(id));
		mv.addObject("id", id);
		mv.addObject("type", type);
		return mv;
	}
	
	@RequestMapping("/requestsubmit")
	public ModelAndView purchaseRequestSubmit(String tableid, String id, String state, String reason) {
		String[] ids = id.split(",");
		String[] states = state.split(",");
		String[] reasons = reason.split(",");
		int ifpass = 1;
		for(int i = 0; i < ids.length; i++) {
			if(Integer.valueOf(states[i]) == 1) {
				purchaseService.setPurchaseRequestContentCheckState(ids[i], 1, reasons[i]);
			}
			else if(Integer.valueOf(states[i]) == -1) {
				purchaseService.setPurchaseRequestContentCheckState(ids[i], -1, reasons[i]);
				ifpass = -1;
			}
		}
		if(ifpass == 1) {
			purchaseService.setPurchaseRequestCheckState(tableid, 1);
			String user = purchaseService.getPurchaseRequestTablesbyId(tableid).get(0).getUser();
			String orderid = purchaseService.createPurchaseOrder(user);
			List<PurchaseRequestContent> purchaseRequest = purchaseService.getPurchaseRequestContentbyTableId(tableid);
			for(PurchaseRequestContent t:purchaseRequest) {
				purchaseService.createPurchaseOrderContent(orderid, t.getName(), t.getNumber());
			}
		}
		else {
			purchaseService.setPurchaseRequestCheckState(tableid, -1);
		}
		return(new ModelAndView("redirect:request"));
	}
	
	@RequestMapping("/orders")
	public ModelAndView purchaseOrder(String word, String type) {
		if(word == "") {
			ModelAndView mv = new ModelAndView("PurchaseOrder");
			mv.addObject("unstartpurchase", purchaseService.getUnstartPurchaseOrderTables());
			mv.addObject("startedpurchase", purchaseService.getStartedPurchaseOrderTables());
			mv.addObject("finishedpurchase", purchaseService.getFinishedPurchaseOrderTables());
			mv.addObject("searchresult", purchaseService.getAllPurchaseOrderTables());
			return(mv);
		}
		else {
			ModelAndView mv = new ModelAndView("PurchaseOrder");
			mv.addObject("unstartpurchase", purchaseService.getUnstartPurchaseOrderTables());
			mv.addObject("startedpurchase", purchaseService.getStartedPurchaseOrderTables());
			mv.addObject("finishedpurchase", purchaseService.getFinishedPurchaseOrderTables());
			if(type == null) {
				mv.addObject("searchresult", purchaseService.getAllPurchaseOrderTables());
				return mv;
			}
			if(Integer.valueOf(type) == 1) {
				mv.addObject("searchresult", purchaseService.getPurchaseOrderTablesbyId(word));
			}
			else if(Integer.valueOf(type) == 2) {
				mv.addObject("searchresult", purchaseService.getPurchaseOrderTablesbyUser(word));
			}
			else if(Integer.valueOf(type) == 3) {
				mv.addObject("searchresult", purchaseService.getPurchaseOrderTablesbyBuyer(word));
			}
			else if(Integer.valueOf(type) == 4) {
				mv.addObject("searchresult", purchaseService.getPurchaseOrderTablesbyTime(word));
			}
			else {
				mv.addObject("searchresult", purchaseService.getAllPurchaseOrderTables());
			}
			return(mv);
		}
	}
	
	@RequestMapping("/ordercontent")
	public ModelAndView purchaseOrderContent(String id, String type) {
		ModelAndView mv = new ModelAndView("PurchaseOrderContent");
		mv.addObject("contents", purchaseService.getPurchaseOrderContentbyTableId(id));
		mv.addObject("id", id);
		mv.addObject("type", type);
		return mv;
	}
	
	@RequestMapping("/orderbuy")
	public ModelAndView purchaseOrderBuy(String buyer) {
		ModelAndView mv = new ModelAndView("PurchaseOrderBuy");
		if(buyer == null) {
			mv.addObject("buyer", "null");
		}
		else {
			buyer = 'B' + buyer;
			mv.addObject("buyer", buyer);
			mv.addObject("unstartpurchase", purchaseService.getUnstartPurchaseOrderTablesbyBuyer(buyer));
			mv.addObject("startedpurchase", purchaseService.getStartedPurchaseOrderTablesbyBuyer(buyer));
		}
		return mv;
	}
	
	@RequestMapping("/ordersubmit")
	public ModelAndView purchaseOrderSubmit(String checked, String type, String state, String tableid, String id, String price, String source) {
		if(type.equals("start")) {
			purchaseService.setPurchaseOrderStateStart(tableid);
			String buyer = purchaseService.getBuyerbyTableId(tableid);
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
					purchaseService.setPurchaseOrderContentFinished(ids[i], prices[i], sources[i]);
				}
				if(checkeds[i].equals("off") && !states[i].equals("已完成")) {
					isfinish = false;
				}
			}
			if(isfinish) {
				purchaseService.setPurchaseOrderState(tableid, 2);
			}
			String buyer = purchaseService.getBuyerbyTableId(tableid);
			buyer = buyer.substring(1);
			return(new ModelAndView("redirect:orderbuy?buyer=" + buyer));
		}
		if(type.equals("reimburse")) {
			purchaseService.setPurchaseOrderState(tableid, 3);
			return(new ModelAndView("redirect:orderreimburse"));
		}
		return(new ModelAndView("redirect:orders"));
	}
	
	@RequestMapping("/orderreimburse")
	public ModelAndView purchaseOrderReimburse() {
		ModelAndView mv = new ModelAndView("PurchaseOrderReimburse");
		mv.addObject("unreimbursedpurchase", purchaseService.getUnreimbursedPurchaseOrderTables());
		mv.addObject("reimbursingpurchase", purchaseService.getReimbursingPurchaseOrderTables());
		mv.addObject("reimbursedpurchase", purchaseService.getReimbursedPurchaseOrderTables());
		return mv;
	}
	
}
