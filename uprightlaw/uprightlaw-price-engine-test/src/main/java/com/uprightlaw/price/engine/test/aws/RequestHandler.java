package com.uprightlaw.price.engine.test.aws;

import org.glassfish.jersey.server.ResourceConfig;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import com.jrestless.aws.gateway.GatewayFeature;
import com.jrestless.aws.gateway.handler.GatewayRequestObjectHandler;


public class RequestHandler extends GatewayRequestObjectHandler {

  public RequestHandler() {
        // initialize the container with your resource configuration
        ResourceConfig config = new ResourceConfig()
          .register(GatewayFeature.class)
          .register(JacksonJsonProvider.class)
          .packages("com.uprightlaw.price.engine.test.resources");
        
        init(config);
        // start the container
        start();
  }
}