package com.insights.webservice.insights.webservice.rest.core;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

public class InsightConfig {

	public String databaseUrl = "localhost";
	public String databasename = "insight";
	public String collectionWordColorPair = "wordColorPair";
	public String user = "";
	public String pass = "";
	public MongoClient mongoClient = null;
	
	public InsightConfig() {

	}
	
	public MongoClient getMongoClient() throws Exception {
		
		if(this.databaseUrl == "") throw new Exception("no localhost given");
		
		if(this.mongoClient == null) {
			this.mongoClient = MongoClients.create(
        		"mongodb://"+databaseUrl+"/"
	        );
		}
		
		return this.mongoClient;
		
	}
}
