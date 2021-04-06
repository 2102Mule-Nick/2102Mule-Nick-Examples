package com.revature.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.revature.pojo.FlashCard;

@Repository
public class FlashCardDaoImpl implements FlashCardDao {

	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public FlashCard addFlashCard(FlashCard flashCard) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeFlashCard(FlashCard flashCard) {
		// TODO Auto-generated method stub

	}

	@Override
	public FlashCard updateFlashCard(FlashCard flashCard) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FlashCard> getAllFlashCards() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FlashCard getFlashCardById(int flashCardId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FlashCard> getAllFlashCardsByCategory(String category) {
		// TODO Auto-generated method stub
		return null;
	}

}
