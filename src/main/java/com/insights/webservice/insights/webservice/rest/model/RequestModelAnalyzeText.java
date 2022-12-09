package com.insights.webservice.insights.webservice.rest.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RequestModelAnalyzeText {

	private String ticket;
	private String authtoken;
	private String inputText;
	
	public RequestModelAnalyzeText() {
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
	@JsonProperty
	public String getInputText() {
		return inputText;
	}
	@JsonProperty
	public void setInputText(String inputText) {
		this.inputText = inputText;
	}

}


