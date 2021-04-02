package edu.matc.deckOfCards;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Deck {

	@JsonProperty("success")
	private boolean success;

	@JsonProperty("deck_id")
	private String deckId;

	@JsonProperty("remaining")
	private int remaining;

	@JsonProperty("shuffled")
	private boolean shuffled;


	public void setSuccess(boolean success){
		this.success = success;
	}

	public boolean isSuccess(){
		return success;
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

	public void setShuffled(boolean shuffled){
		this.shuffled = shuffled;
	}

	public boolean getShuffled(){
		return shuffled;
	}

	@Override
 	public String toString(){
		return 
			"Deck{" +
			",success = '" + success + '\'' +
			",deck_id = '" + deckId + '\'' + 
			",remaining = '" + remaining + '\'' +
			",shuffled = '" + shuffled + '\'' +
			"}";
		}
}