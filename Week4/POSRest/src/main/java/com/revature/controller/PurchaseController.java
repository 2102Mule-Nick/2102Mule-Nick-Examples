package com.revature.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.pojo.PurchaseOrder;
import com.revature.service.PurchaseOrderServiceFinder;
import com.revature.service.ShoppingCartService;

@Controller
public class PurchaseController {

	private ShoppingCartService shoppingCartService;
	
	
	@Autowired
	public void setShoppingCartService(ShoppingCartService shoppingCartService) {
		this.shoppingCartService = shoppingCartService;
	}
	
	private PurchaseOrderServiceFinder purchaseOrderService;
	
	@Autowired
	public void setPurchaseOrderService(PurchaseOrderServiceFinder purchaseOrderService) {
		this.purchaseOrderService = purchaseOrderService;
	}
	
	@GetMapping("/purchase")
	@ResponseBody
	public List<PurchaseOrder> getPurchaseOrders(){
		return purchaseOrderService.getPurchaseOrders();
	}
	
	@GetMapping("/purchase/{date}")
	@ResponseBody
	public List<PurchaseOrder> getPurchaseOrdersByDate(@PathVariable String date){
		return purchaseOrderService.getPurchaseOrdersByDate(date);
	}
	
	@GetMapping("/purchase/{userId}/{date}")
	@ResponseBody
	public List<PurchaseOrder> getPurchaseOrdersByDateAndUserId(@PathVariable int userId, @PathVariable String date){
		return purchaseOrderService.getPurchaseOrdersByDateAndUserId(date, userId);
	}
}
