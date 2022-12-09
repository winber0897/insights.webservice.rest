package com.insights.webservice.insights.webservice.rest.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WordColorPair {

	private String word;
	private String color;
	
	public WordColorPair(String word, String color) {
		super();
		this.word = word;
		this.color = color;
	}

	@JsonProperty
	public String getWord() {
		return word;
	}
	@JsonProperty
	public void setWord(String word) {
		this.word = word;
	}
	@JsonProperty
	public String getColor() {
		return color;
	}
	@JsonProperty
	public void setColor(String color) {
		this.color = color;
	}
	
}
