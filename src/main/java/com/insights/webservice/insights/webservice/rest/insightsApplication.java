package com.insights.webservice.insights.webservice.rest;

import com.insights.webservice.insights.webservice.rest.db.MongoClientConnectionExample;
import com.insights.webservice.insights.webservice.rest.health.TemplateHealthCheck;
import com.insights.webservice.insights.webservice.rest.resources.HelloWorldResource;
import com.insights.webservice.insights.webservice.rest.resources.InsightAnalyseResource;

import io.dropwizard.core.Application;
import io.dropwizard.core.setup.Bootstrap;
import io.dropwizard.core.setup.Environment;

public class insightsApplication extends Application<insightsConfiguration> {

    public static void main(final String[] args) throws Exception {
        new insightsApplication().run(args); // args contains id and templat
    }

    @Override
    public String getName() {
    	return MongoClientConnectionExample.testConnection();
        //return "Hello World";
    }

    @Override
    public void initialize(final Bootstrap<insightsConfiguration> bootstrap) {
        // TODO: application initialization
    }

    @Override
    public void run(insightsConfiguration configuration,
                    Environment environment) {
        final HelloWorldResource resource = new HelloWorldResource(
            configuration.getTemplate(),
            configuration.getDefaultName()
        );
        final InsightAnalyseResource insightAnalyse = new InsightAnalyseResource ();
        final TemplateHealthCheck healthCheck =
            new TemplateHealthCheck(configuration.getTemplate());
        environment.healthChecks().register("template", healthCheck);
        environment.jersey().register(resource);
        environment.jersey().register(insightAnalyse);
    }

}
