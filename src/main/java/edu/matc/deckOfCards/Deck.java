package edu.matc.deckOfCards;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Deck {

	@JsonProperty("cards")
	private List<CardsItem> cards;

	@JsonProperty("success")
	private boolean success;

	@JsonProperty("piles")
	private Piles piles;

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

	@Override
 	public String toString(){
		return 
			"Deck{" +
			"cards = '" + cards + '\'' +
			",piles = '" + piles + '\'' +
			",success = '" + success + '\'' +
			",deck_id = '" + deckId + '\'' + 
			",remaining = '" + remaining + '\'' + 
			"}";
		}
}