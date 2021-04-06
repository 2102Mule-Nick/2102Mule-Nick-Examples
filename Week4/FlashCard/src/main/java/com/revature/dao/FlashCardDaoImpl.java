package com.revature.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.revature.dao.mapper.FlashCardRowMapper;
import com.revature.pojo.FlashCard;

@Repository
public class FlashCardDaoImpl implements FlashCardDao {

	private JdbcTemplate jdbcTemplate;
	
	private FlashCardRowMapper flashCardRowMapper;
	
	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@Autowired
	public void setFlashCardRowMapper(FlashCardRowMapper flashCardRowMapper) {
		this.flashCardRowMapper = flashCardRowMapper;
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

		String sql = "select fc.flash_card_id, fc.question, fc.answer, fc.difficulty, c.category_name "
				+ "from flash_card fc join category c on fc.category_id = c.category_id";
		
		List<FlashCard> flashCardList = jdbcTemplate.query(sql, flashCardRowMapper);
		
		return flashCardList;
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
