package edu.matc.deckOfCards;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class DrawnCards{

	@JsonProperty("cards")
	private List<CardsItem> cards;

	@JsonProperty("success")
	private boolean success;

	@JsonProperty("deck_id")
	private String deckId;

	@JsonProperty("remaining")
	private int remaining;

	public void setCards(List<CardsItem> cards){
		this.cards = cards;
	}

	public List<CardsItem> getCards(){
		return cards;
	}

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
}