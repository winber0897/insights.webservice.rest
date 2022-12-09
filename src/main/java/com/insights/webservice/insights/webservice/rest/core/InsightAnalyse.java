package com.insights.webservice.insights.webservice.rest.core;

import java.util.ArrayList;

import com.insights.webservice.insights.webservice.rest.api.WordColorPair;

public class InsightAnalyse {
	
	private ArrayList<WordColorPair> wordColorPair = new ArrayList<WordColorPair>();
	private IInsightAnalyseRepository insightAnalyseRepository;


	public InsightAnalyse(IInsightAnalyseRepository insightAnalyseRepository) {
		this.insightAnalyseRepository = insightAnalyseRepository;
	}
	
	public ArrayList<WordColorPair> createAnalysis(String inputText) throws Exception {
		
		if(inputText == null || inputText == "") {
			throw new Exception("no valid input text");
		}
		
		//String inputText = "Ich zeige dir eine schöne Präsentation";
		
		// remove all dots and other special chars
		String inputTextWithoutSpecialChars = inputText.replaceAll("[-+.^:,]","");
		String[] splittedWordsFromInputText = inputTextWithoutSpecialChars.split(" ");

		// check for every word if there is a color in database
		for(String word : splittedWordsFromInputText) {
			wordColorPair.add(new WordColorPair(
				word, 
				checkColorByWord(word)
			));
		}

		return wordColorPair;
	}

	/* 
	 * if the method returns null we take it nevertheless
	 * because the ratio could be interesting
	 */
	private String checkColorByWord(String word) {	
		return insightAnalyseRepository.findColorByWord(word);
	}
	
	public ArrayList<WordColorPair> getWordColorPair() throws Exception {

		return wordColorPair;
	}
	
	public void addWordColorPair(WordColorPair wordColorPair) throws Exception {

		insightAnalyseRepository.addColorWordPair(wordColorPair.getWord(), wordColorPair.getColor());
	}
	
	 
}
