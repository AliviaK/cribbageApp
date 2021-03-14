package edu.matc.deckOfCards;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Discard{

	@JsonProperty("remaining")
	private int remaining;

	public void setRemaining(int remaining){
		this.remaining = remaining;
	}

	public int getRemaining(){
		return remaining;
	}

	@Override
 	public String toString(){
		return 
			"Discard{" + 
			"remaining = '" + remaining + '\'' + 
			"}";
		}
}