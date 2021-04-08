package edu.matc.deckOfCards;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class CpuHand{

	@JsonProperty("success")
	private boolean success;

	@JsonProperty("piles")
	private Piles piles;

	@JsonProperty("deck_id")
	private String deckId;

	@JsonProperty("remaining")
	private int remaining;

	@JsonProperty("cards")
	private List<CardsItem> cards;

	public void setCards(List<CardsItem> cards){
		this.cards = cards;
	}

	public List<CardsItem> getCards(){
		return cards;
	}

	public void setRemaining(int remaining){
		this.remaining = remaining;
	}

	public int getRemaining(){
		return remaining;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public Piles getPiles() {
		return piles;
	}

	public void setPiles(Piles piles) {
		this.piles = piles;
	}

	public String getDeckId() {
		return deckId;
	}

	public void setDeckId(String deckId) {
		this.deckId = deckId;
	}
}