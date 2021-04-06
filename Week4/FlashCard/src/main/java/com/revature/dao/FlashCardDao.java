package com.revature.dao;

import java.util.List;

import com.revature.pojo.FlashCard;

public interface FlashCardDao {

	public FlashCard addFlashCard(FlashCard flashCard);
	
	public void removeFlashCard(FlashCard flashCard);
	
	public FlashCard updateFlashCard(FlashCard flashCard);
	
	public List<FlashCard> getAllFlashCards();
	
	public FlashCard getFlashCardById(int flashCardId);
	
	public List<FlashCard> getAllFlashCardsByCategory(String category);
	
}
