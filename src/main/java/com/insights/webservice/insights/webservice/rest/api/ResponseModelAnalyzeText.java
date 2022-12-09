package com.insights.webservice.insights.webservice.rest.api;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResponseModelAnalyzeText {

	private String ticket;
    private ArrayList<WordColorPair> wordColorPairList;

    public ResponseModelAnalyzeText() {
        
    }
    
    public ResponseModelAnalyzeText(ArrayList<WordColorPair> wordColorPairList, String ticket) {
        this.wordColorPairList = wordColorPairList;
        this.ticket = ticket;
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
	public ArrayList<WordColorPair> getWordColorPairList() {
		return wordColorPairList;
	}

    @JsonProperty
	public void setWordColorPairList(ArrayList<WordColorPair> wordColorPairList) {
		this.wordColorPairList = wordColorPairList;
	}

}
