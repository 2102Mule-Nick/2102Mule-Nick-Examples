package com.revature.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.revature.pojo.FlashCard;

@Component
public class FlashCardRowMapper implements RowMapper<FlashCard> {

	private FlashCardExtractor flashCardExtractor;
	
	@Autowired
	public void setFlashCardExtractor(FlashCardExtractor flashCardExtractor) {
		this.flashCardExtractor = flashCardExtractor;
	}

	@Override
	public FlashCard mapRow(ResultSet rs, int rowNum) throws SQLException {
		return flashCardExtractor.extractData(rs);
	}

}
