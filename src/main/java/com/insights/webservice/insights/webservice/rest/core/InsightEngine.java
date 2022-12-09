package com.insights.webservice.insights.webservice.rest.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.plaf.basic.BasicPasswordFieldUI;

import org.apache.commons.lang3.NotImplementedException;

import com.insights.webservice.insights.webservice.rest.api.WordColorPair;

public class InsightEngine {
	
	private InsightConfig insightConfig;
	private IInsightAnalyseRepository insightAnalyseRepository;
	private InsightAnalyse insightAnalyse;
	private final List<String> colorInInsightAnalyse = Arrays.asList(new String []
	{
			"yellow","blue","red","green","gelb","blau","rot","gruen"
	});
	
	public InsightEngine(InsightConfig insightConfig) {
		this.insightConfig = insightConfig;
		this.insightAnalyseRepository = new InsightAnalyseRepository(insightConfig);
		this.insightAnalyse = new InsightAnalyse(this.insightAnalyseRepository);
	}
	
	public void addWordColorPair(WordColorPair wordColorPair) throws InsightRuleViolatedException {
		
		String color = wordColorPair.getColor();
		String word = wordColorPair.getWord();
		boolean validRequest = true;
		String errorMessage = "";
		
		if(!this.colorInInsightAnalyse.contains(color)) {
			validRequest = false;
			errorMessage = "the color passed does not exist";
		}
		else if (word == "" 
			|| word == null 
			|| word.length() < 2
			|| word.length() > 40
			) {	
			
			validRequest = false;
			errorMessage = "the word passed must not be null"
					+ " or empty and its must not be shorter "
					+ "than two or larger than fourty characters.";
		}
		
		if(validRequest) {
			try {
				this.insightAnalyse.addWordColorPair(wordColorPair);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			throw new InsightRuleViolatedException(errorMessage);
		}
	}
	
	public void deleteWordColorPair(WordColorPair wordColorPair) {
		throw new NotImplementedException();
	}
	
	public ArrayList<WordColorPair> analyzeText(String inputText) throws Exception {
		
		try {
			ArrayList<WordColorPair> wordColorPairList = this.insightAnalyse.createAnalysis(inputText);
			return wordColorPairList;
			//color = wordColorPairList.get(0).getColor();
		} catch (Exception e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new Exception(); 
		}
	}
}
