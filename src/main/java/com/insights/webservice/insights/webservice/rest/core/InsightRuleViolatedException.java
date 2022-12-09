package com.insights.webservice.insights.webservice.rest.core;

public class InsightRuleViolatedException extends Exception {
    public InsightRuleViolatedException(String errorMessage) {
        super(errorMessage);
    }
}
