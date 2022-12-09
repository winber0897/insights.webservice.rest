package com.insights.webservice.insights.webservice.rest.resources;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

import com.codahale.metrics.annotation.Timed;
import com.insights.webservice.insights.webservice.rest.api.ResponseModelAnalyzeText;
import com.insights.webservice.insights.webservice.rest.api.Saying;
import com.insights.webservice.insights.webservice.rest.api.WordColorPair;
import com.insights.webservice.insights.webservice.rest.core.InsightConfig;
import com.insights.webservice.insights.webservice.rest.core.InsightEngine;
import com.insights.webservice.insights.webservice.rest.core.InsightRuleViolatedException;
import com.insights.webservice.insights.webservice.rest.model.RequestModelAddWordColorPair;
import com.insights.webservice.insights.webservice.rest.model.RequestModelAnalyzeText;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

@Path("/insight")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class InsightAnalyseResource {
    private String inputText = "";
    private List<String> newWordColorPair;
    private List<String> [] toDeleteWordColorPair;

    @GET
    @Timed
    @Path("sayHello")
    public Saying sayHello(RequestModelAddWordColorPair test) {

        return new Saying(-1, "add color: ");
    }
    
    @GET
    @Timed
    @Path("addWordColorPair")
    public Saying addWordColorPair(RequestModelAddWordColorPair requestModel) {

    	// take it over to the analyse engine
    	try {
			new InsightEngine(new InsightConfig()).addWordColorPair(new WordColorPair(requestModel.getWord(), requestModel.getColor()));
		} catch (InsightRuleViolatedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new Saying(0, e.getMessage());
		}

        return new Saying(0, "word was added");
    }
    
    @GET
    @Timed
    @Path("analyzeText")
    public ResponseModelAnalyzeText analyzeText(RequestModelAnalyzeText requestModel) {

    	// take it over to the analyse engine
    	ArrayList<WordColorPair> wordColorPairList = new ArrayList<WordColorPair>();
		try {
			wordColorPairList = new InsightEngine(new InsightConfig()).analyzeText(requestModel.getInputText());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        return new ResponseModelAnalyzeText(wordColorPairList, "1");
    }
    
    
}