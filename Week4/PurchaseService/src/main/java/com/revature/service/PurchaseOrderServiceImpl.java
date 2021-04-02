package com.revature.service;

import java.util.List;

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

	@Override
	public PurchaseOrder createPurchaseOrder(String date, int cartId) {

		return purchaseOrderDao.createPurchaseOrder(date, cartId);
	}

	@Override
	public List<PurchaseOrder> getPurchaseOrderByUserId(int userId) {
		return purchaseOrderDao.getPurchaseOrdersByUserId(userId);
	}

	@Override
	public List<PurchaseOrder> getPurchaseOrders() {
		return purchaseOrderDao.getAllPurchaseOrders();
	}

	@Override
	public List<PurchaseOrder> getPurchaseOrdersByDate(String date) {
		return purchaseOrderDao.getPurchaseOrdersByDate(date);
	}

	@Override
	public List<PurchaseOrder> getPurchaseOrdersByDateAndUserId(String date, int userId) {
		return purchaseOrderDao.getPurchaseOrdersByDateAndUserId(date, userId);
	}

}
