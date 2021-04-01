package com.revature.pojo;

public class PurchaseOrder {
	
	private int purchaseOrderId;
	
	private int cartId;
	
	private String date;

	public int getPurchaseOrderId() {
		return purchaseOrderId;
	}

	public void setPurchaseOrderId(int purchaseOrderId) {
		this.purchaseOrderId = purchaseOrderId;
	}

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public PurchaseOrder(int purchaseOrderId, int cartId, String date) {
		super();
		this.purchaseOrderId = purchaseOrderId;
		this.cartId = cartId;
		this.date = date;
	}

	public PurchaseOrder() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "PurchaseOrder [purchaseOrderId=" + purchaseOrderId + ", cartId=" + cartId + ", date=" + date + "]";
	}
	
}
