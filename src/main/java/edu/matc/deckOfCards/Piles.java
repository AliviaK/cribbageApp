package edu.matc.deckOfCards;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Piles{

	@JsonProperty("discard")
	private Discard discard;

	public void setDiscard(Discard discard){
		this.discard = discard;
	}

	public Discard getDiscard(){
		return discard;
	}

	@Override
 	public String toString(){
		return 
			"Piles{" + 
			"discard = '" + discard + '\'' + 
			"}";
		}
}