package com.revature.wrapper;

import java.util.ArrayList;
import java.util.List;

import com.revature.pojo.PurchaseOrder;

public class PurchaseOrderList {
	private List<PurchaseOrder> purchaseOrderLists;

	public PurchaseOrderList() {
		purchaseOrderLists = new ArrayList<>();
	}

	public List<PurchaseOrder> getPurchaseOrderLists() {
		return purchaseOrderLists;
	}

	public void setPurchaseOrderLists(List<PurchaseOrder> purchaseOrderLists) {
		this.purchaseOrderLists = purchaseOrderLists;
	}
	
}
