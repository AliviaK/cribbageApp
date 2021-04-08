package edu.matc.deckOfCards;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Piles{

	@JsonProperty("CpuHand")
	private CpuHand cpuHand;

	@JsonProperty("Crib")
	private Crib crib;

	@JsonProperty("PlayerHand")
	private PlayerHand playerHand;

	public PlayerHand getPlayerHand() {
		return playerHand;
	}

	public void setPlayerHand(PlayerHand playerHand) {
		this.playerHand = playerHand;
	}

	public void setCpuHand(CpuHand cpuHand){
		this.cpuHand = cpuHand;
	}

	public CpuHand getCpuHand(){
		return cpuHand;
	}

	public void setCrib(Crib crib){
		this.crib = crib;
	}

	public Crib getCrib(){
		return crib;
	}
}