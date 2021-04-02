package com.revature.service;

import java.util.List;

import com.revature.pojo.PurchaseOrder;

public interface PurchaseOrderService {
	
	public PurchaseOrder getPurchaseOrderById(int purchaseOrderId);
	
	public PurchaseOrder createPurchaseOrder(String date, int cartId);
	
	public List<PurchaseOrder> getPurchaseOrderByUserId(int userId);

	public List<PurchaseOrder> getPurchaseOrders();
	
	public List<PurchaseOrder> getPurchaseOrdersByDate(String date);
	
	public List<PurchaseOrder> getPurchaseOrdersByDateAndUserId(String date, int userId);

}
