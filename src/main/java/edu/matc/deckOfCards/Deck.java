package edu.matc.deckOfCards;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Deck{

	@JsonProperty("success")
	private boolean success;

	@JsonProperty("shuffled")
	private boolean shuffled;

	@JsonProperty("deck_id")
	private String deckId;

	@JsonProperty("remaining")
	private int remaining;

	public void setSuccess(boolean success){
		this.success = success;
	}

	public boolean isSuccess(){
		return success;
	}

	public void setShuffled(boolean shuffled){
		this.shuffled = shuffled;
	}

	public boolean isShuffled(){
		return shuffled;
	}

	public void setDeckId(String deckId){
		this.deckId = deckId;
	}

	public String getDeckId(){
		return deckId;
	}

	public void setRemaining(int remaining){
		this.remaining = remaining;
	}

	public int getRemaining(){
		return remaining;
	}

	@Override
 	public String toString(){
		return 
			"Deck{" + 
			"success = '" + success + '\'' + 
			",shuffled = '" + shuffled + '\'' + 
			",deck_id = '" + deckId + '\'' + 
			",remaining = '" + remaining + '\'' + 
			"}";
		}
}