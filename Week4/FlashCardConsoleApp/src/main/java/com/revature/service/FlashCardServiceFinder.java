package com.revature.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.revature.pojo.FlashCard;

@Service
public class FlashCardServiceFinder implements FlashCardService {

	private static final String flashCardUrl = "http://localhost:8080/FlashCard/flashCard";
	
	@Override
	public List<FlashCard> retrieveAllFlashCards() {
		
		RestTemplate restTemplate = new RestTemplate();
		
		//ResponseEntity<List<FlashCard>> flashCardList = restTemplate.exchange
		//		(flashCardUrl, HttpMethod.GET, null, new ParameterizedTypeReference <List<FlashCard>> () {});
		
		FlashCard[] flashCards = restTemplate.getForObject(flashCardUrl, FlashCard[].class);
		
		//return flashCardList.getBody();
		
		return Arrays.asList(flashCards);
		
	}

}
