package edu.matc.deckOfCards;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Images{

	@JsonProperty("svg")
	private String svg;

	@JsonProperty("png")
	private String png;

	public void setSvg(String svg){
		this.svg = svg;
	}

	public String getSvg(){
		return svg;
	}

	public void setPng(String png){
		this.png = png;
	}

	public String getPng(){
		return png;
	}

	@Override
 	public String toString(){
		return 
			"Images{" + 
			"svg = '" + svg + '\'' + 
			",png = '" + png + '\'' + 
			"}";
		}
}