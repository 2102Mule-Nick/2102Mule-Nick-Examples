package com.revature.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.pojo.PurchaseOrder;
import com.revature.service.PurchaseOrderService;

@RestController
public class PurchaseController {
	
	private PurchaseOrderService purchaseOrderService;
	
	@Autowired
	public void setPurchaseOrderService(PurchaseOrderService purchaseOrderService) {
		this.purchaseOrderService = purchaseOrderService;
	}

	@GetMapping("/example")
	public String example() {
		return "working";
	}
	
	@GetMapping("/purchase/{purchaseId}")
	public PurchaseOrder getPurchase(@PathVariable int purchaseId) {
		
		return purchaseOrderService.getPurchaseOrderById(purchaseId);
		
	}
	
	@PostMapping("/purchase")
	public PurchaseOrder createPurchaseOrder(@RequestBody PurchaseOrder purchaseOrder) {
		return purchaseOrderService.createPurchaseOrder(purchaseOrder.getDate(), purchaseOrder.getCartId());
	}
	
	@GetMapping("/purchase/user/{userId}")
	public List<PurchaseOrder> getPurchaseOrdersByUserId(@PathVariable int userId) {
		
		return purchaseOrderService.getPurchaseOrderByUserId(userId);
		
	}
	
}
