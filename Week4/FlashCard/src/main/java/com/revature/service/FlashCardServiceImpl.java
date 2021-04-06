package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revature.dao.FlashCardDao;
import com.revature.jms.JMSMessageSender;
import com.revature.pojo.FlashCard;

@Service
public class FlashCardServiceImpl implements FlashCardService {
	
	private JMSMessageSender jMSMessageSender;

	private FlashCardDao flashCardDao;
	
	@Autowired
	public void setFlashCardDao(FlashCardDao flashCardDao) {
		this.flashCardDao = flashCardDao;
	}
	
	@Autowired
	public void setjMSMessageSender(JMSMessageSender jMSMessageSender) {
		this.jMSMessageSender = jMSMessageSender;
	}



	@Override
	@Transactional
	public List<FlashCard> retrieveAllFlashCards() {

		/*	THIS IS WHERE YOUR BUISNESS LOGIC WOULD GO	*/
		
		List<FlashCard> flashCardList = flashCardDao.getAllFlashCards();
		
		jMSMessageSender.sendMessage(flashCardList.size() + " flash cards have been accessed");
		
		return flashCardList;
	}

}
