package com.revature.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.dao.PurchaseOrderDao;
import com.revature.pojo.PurchaseOrder;

@Service
public class PurchaseOrderServiceImpl implements PurchaseOrderService {

	private PurchaseOrderDao purchaseOrderDao;
	
	@Autowired
	public void setPurchaseOrderDao(PurchaseOrderDao purchaseOrderDao) {
		this.purchaseOrderDao = purchaseOrderDao;
	}

	@Override
	public PurchaseOrder getPurchaseOrderById(int purchaseOrderId) {
		return purchaseOrderDao.getPurchaseOrderById(purchaseOrderId);
	}

}
