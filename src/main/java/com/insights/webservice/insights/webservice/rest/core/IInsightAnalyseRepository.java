package com.insights.webservice.insights.webservice.rest.core;

public interface IInsightAnalyseRepository {

	String findColorByWord(String word);
	
	boolean addColorWordPair(String word, String color);

	boolean deleteColorWordPair(String word);
	
	boolean updateColorWordPair(String word, String color);
}
