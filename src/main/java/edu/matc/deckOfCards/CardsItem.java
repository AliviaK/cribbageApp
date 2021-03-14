package edu.matc.deckOfCards;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CardsItem{

	@JsonProperty("image")
	private String image;

	@JsonProperty("images")
	private Images images;

	@JsonProperty("code")
	private String code;

	@JsonProperty("suit")
	private String suit;

	@JsonProperty("value")
	private String value;

	public void setImage(String image){
		this.image = image;
	}

	public String getImage(){
		return image;
	}

	public void setImages(Images images){
		this.images = images;
	}

	public Images getImages(){
		return images;
	}

	public void setCode(String code){
		this.code = code;
	}

	public String getCode(){
		return code;
	}

	public void setSuit(String suit){
		this.suit = suit;
	}

	public String getSuit(){
		return suit;
	}

	public void setValue(String value){
		this.value = value;
	}

	public String getValue(){
		return value;
	}

	@Override
 	public String toString(){
		return 
			"CardsItem{" + 
			"image = '" + image + '\'' + 
			",images = '" + images + '\'' + 
			",code = '" + code + '\'' + 
			",suit = '" + suit + '\'' + 
			",value = '" + value + '\'' + 
			"}";
		}
}