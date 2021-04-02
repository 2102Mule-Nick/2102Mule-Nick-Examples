package com.revature.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.revature.pojo.PurchaseOrder;
import com.revature.wrapper.PurchaseOrderList;

@Service
public class PurchaseOrderServiceFinder {

	public PurchaseOrder getPurchaseOrder(int purchaseId) {

		// allows a rest client to easily send a rest request
		RestTemplate restTemplate = new RestTemplate();

		return restTemplate.getForObject("http://localhost:8080/PurchaseService/purchase/" + purchaseId,
				PurchaseOrder.class);

	}

	public PurchaseOrder createPurchaseOrder(String date, int cartId) {

		RestTemplate restTemplate = new RestTemplate();

		PurchaseOrder purchaseOrder = new PurchaseOrder();
		purchaseOrder.setDate(date);
		purchaseOrder.setCartId(cartId);
		
		return restTemplate.postForObject("http://localhost:8080/PurchaseService/purchase", purchaseOrder,
				PurchaseOrder.class);
	}
	
	public List<PurchaseOrder> getPurchaseOrdersByUserId(int id){
		RestTemplate restTemplate = new RestTemplate();
		
		PurchaseOrderList response =  restTemplate.getForObject("http://localhost:8080/PurchaseService/purchase/user/"
		+ id, PurchaseOrderList.class);
		
		List<PurchaseOrder> purchaseOrders = response.getPurchaseOrderLists();
		
		return purchaseOrders;
	}
	
}
