/*
 * JBoss, Home of Professional Open Source
 * Copyright 2015, Red Hat, Inc. and/or its affiliates, and individual
 * contributors by the @authors tag. See the copyright.txt in the
 * distribution for a full listing of individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.marx;

import java.util.List;
import java.util.concurrent.Future;
import java.util.logging.Logger;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.InvocationCallback;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.jboss.as.quickstarts.jaxrsclient.model.Contact;
import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;
import org.junit.Assert;
import org.junit.Test;

public class MarxTest {

	//add comment ha ha
    private static final String REST_TARGET_URL = "http://localhost:8080/jboss-jaxrs-client/rest/contacts";
    
    
    private static final String CONTACT_NAME = "New Contact";
    private static final String CONTACT_PHONE = "+55-61-5555-1234";

    private static Logger log = Logger.getLogger(MarxTest.class.getName());


    public static void main(String args[]) {
        log.info("### CRUD tests ###");
       
        // 1 - drop all contacts
        log.info("dropping all contacts");
         //Response response = ClientBuilder.newClient().target(REST_TARGET_URL).request().delete();
        //Assert.assertEquals("All contacts should be dropped", Response.ok().build().getStatus(), response.getStatus());

        // 2 - Create a new contact
//        log.info("creating a new contact");
//        Contact c = new Contact();
//        c.setName(CONTACT_NAME);
//        c.setPhoneNumber(CONTACT_PHONE);
//        log.info("Contact=" + c + "\n");
//        
//        String REST_TARGET_URL2 = "http://localhost:8080/jboss-helloworld-rs/rest/json";
//        try {
//			String resultString = (String) ClientBuilder.newClient().target(REST_TARGET_URL2).request().post(null, String.class);
//			log.info("resultString=" + resultString + "\n");
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

//      It's OK 2019/01/22        
    	ResteasyClient client = new ResteasyClientBuilder().build();
    	ResteasyWebTarget target = client.target("http://localhost:8080/jboss-helloworld-rs/rest/json");
    	//ResteasyWebTarget target = client.target(REST_TARGET_URL); //NG
    	Response response = target.request().get();
    	String value = (String) response.readEntity(String.class);
    	System.out.println(value);
    	response.close(); 
        
    }
}
