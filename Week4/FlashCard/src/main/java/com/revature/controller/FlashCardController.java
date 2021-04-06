package com.revature.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.pojo.FlashCard;
import com.revature.service.FlashCardService;

@RestController
public class FlashCardController {

	FlashCardService flashCardService;

	@Autowired
	public void setFlashCardService(FlashCardService flashCardService) {
		this.flashCardService = flashCardService;
	}
	
	@GetMapping("/flashCard")
	public List<FlashCard> getFlashCards() {
		return flashCardService.retrieveAllFlashCards();
	}
	
}
