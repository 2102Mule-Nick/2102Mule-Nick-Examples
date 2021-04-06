package com.revature.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

import com.revature.pojo.FlashCard;

@Component
public class FlashCardExtractor implements ResultSetExtractor<FlashCard> {

	@Override
	public FlashCard extractData(ResultSet rs) throws SQLException, DataAccessException {
		
		int flashCardId = rs.getInt("flash_card_id");
		
		String question = rs.getString("question");
		
		String answer = rs.getString("answer");
		
		String category = rs.getString("category_name");
		
		int difficulty = rs.getInt("difficulty");
		
		return new FlashCard(flashCardId, question, answer, difficulty, category);
	}

}
