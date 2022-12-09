package com.insights.webservice.insights.webservice.rest.core;

import org.bson.Document;
import org.bson.conversions.Bson;
import static com.mongodb.client.model.Filters.eq;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Projections;
import com.mongodb.client.model.Sorts;

public class InsightAnalyseRepository implements IInsightAnalyseRepository {

	private InsightConfig insightConfig;
	private MongoClient mongoClient;
	
	public InsightAnalyseRepository(InsightConfig insightConfig) {
		super();
		this.insightConfig = insightConfig;
		try {
			this.mongoClient = this.insightConfig.getMongoClient();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public String findColorByWord(String word) {
		
    	MongoDatabase db = mongoClient.getDatabase("insight");

    	MongoCollection col = db.getCollection("wordColorPair");
    	
        Document doc = (Document) col.find(eq("word",word))
                .first();
        
        if(doc == null) return null;
        
        String color = doc.get("color").toString();

		return color;
	}

	@Override
	public boolean addColorWordPair(String word, String color) {
		if(checkForExistingColorWordPair(word, color)) return false;
		
    	MongoDatabase db = mongoClient.getDatabase("insight");

    	MongoCollection col = db.getCollection("wordColorPair");
    	
    	Document sample = new Document();
    	
    	sample.put("color", color);
    	sample.put("word", word);
    	
    	col.insertOne(sample);
    	
    	// check if something going wrong
    	
		return true;
	}
	
	public boolean checkForExistingColorWordPair(String word, String color) {
    	MongoDatabase db = mongoClient.getDatabase("insight");

    	MongoCollection col = db.getCollection("wordColorPair");
    	
        Document doc = (Document) col.find(eq("word",word))
                .first();
        
        if(doc == null) return false;
		return true;
	}

	@Override
	public boolean deleteColorWordPair(String word) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateColorWordPair(String word, String color) {
		// TODO Auto-generated method stub
		return false;
	}

}
