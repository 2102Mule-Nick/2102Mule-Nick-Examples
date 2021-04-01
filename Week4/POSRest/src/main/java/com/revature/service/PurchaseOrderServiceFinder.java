package com.revature.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.revature.pojo.PurchaseOrder;

@Service
public class PurchaseOrderServiceFinder {

	public PurchaseOrder getPurchaseOrder(int purchaseId) {
		
		//allows a rest client to easily send a rest request
		RestTemplate restTemplate = new RestTemplate();
		
		return restTemplate.getForObject("http://localhost:8080/PurchaseService/purchase/" + purchaseId, PurchaseOrder.class);
		
	}
	
}
