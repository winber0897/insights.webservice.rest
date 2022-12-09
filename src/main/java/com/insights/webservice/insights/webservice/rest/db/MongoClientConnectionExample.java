package com.insights.webservice.insights.webservice.rest.db;

import org.bson.Document;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class MongoClientConnectionExample {
    public static String testConnection() {
    	MongoClient mongoClient = MongoClients.create(
    		"mongodb://localhost/"
    	);
    	
    	MongoDatabase db = mongoClient.getDatabase("languageSchool");

    	MongoCollection col = db.getCollection("courses");
    	
    	Document sample = new Document();
    	
    	sample.put("title", "Englisch"+(int)(Math.random()*100));
    	
    	col.insertOne(sample);

    	return "";
    	//mongoClient.getDatabaseNames().forEach(System.out::println);
    }
}