package edu.matc.deckOfCards;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PileCreation{

	@JsonProperty("success")
	private boolean success;

	@JsonProperty("piles")
	private Piles piles;

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

	public void setPiles(Piles piles){
		this.piles = piles;
	}

	public Piles getPiles(){
		return piles;
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
}