package com.revature.pojo;

public class FlashCard {

	public int flashCardId;
	
	public String question;
	
	public String answer;
	
	public int difficulty;
	
	public String category;

	public int getFlashCardId() {
		return flashCardId;
	}

	public void setFlashCardId(int flashCardId) {
		this.flashCardId = flashCardId;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public int getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(int difficulty) {
		this.difficulty = difficulty;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public FlashCard(int flashCardId, String question, String answer, int difficulty, String category) {
		super();
		this.flashCardId = flashCardId;
		this.question = question;
		this.answer = answer;
		this.difficulty = difficulty;
		this.category = category;
	}

	public FlashCard() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "FlashCard [flashCardId=" + flashCardId + ", question=" + question + ", answer=" + answer
				+ ", difficulty=" + difficulty + ", category=" + category + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((answer == null) ? 0 : answer.hashCode());
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + difficulty;
		result = prime * result + flashCardId;
		result = prime * result + ((question == null) ? 0 : question.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FlashCard other = (FlashCard) obj;
		if (answer == null) {
			if (other.answer != null)
				return false;
		} else if (!answer.equals(other.answer))
			return false;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (difficulty != other.difficulty)
			return false;
		if (flashCardId != other.flashCardId)
			return false;
		if (question == null) {
			if (other.question != null)
				return false;
		} else if (!question.equals(other.question))
			return false;
		return true;
	}
	
}
