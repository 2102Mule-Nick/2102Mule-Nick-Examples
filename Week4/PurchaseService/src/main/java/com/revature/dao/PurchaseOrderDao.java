package com.revature.dao;

import java.util.List;

import com.revature.pojo.PurchaseOrder;

public interface PurchaseOrderDao {
	
	public PurchaseOrder getPurchaseOrderById(int purchaseOrderId);
	
	public PurchaseOrder createPurchaseOrder(String date, int cartId);
	
	public List<PurchaseOrder> getPurchaseOrdersByUserId(int userId);

}
