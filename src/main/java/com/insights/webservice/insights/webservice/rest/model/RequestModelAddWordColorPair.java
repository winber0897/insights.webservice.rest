package com.insights.webservice.insights.webservice.rest.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RequestModelAddWordColorPair {

	private String ticket;
	private String authtoken;
	private String word;
	private String color;
	
	public RequestModelAddWordColorPair() {
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
	
	@JsonProperty
	public String getTicket() {
		return ticket;
	}
	@JsonProperty
	public void setTicket(String ticket) {
		this.ticket = ticket;
	}
	@JsonProperty
	public String getAuthtoken() {
		return authtoken;
	}
	@JsonProperty
	public void setAuthtoken(String authtoken) {
		this.authtoken = authtoken;
	}

}


