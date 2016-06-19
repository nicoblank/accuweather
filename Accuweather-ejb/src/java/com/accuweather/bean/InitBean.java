/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.accuweather.bean;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.LocalBean;
import javax.ejb.Startup;
import javax.json.JsonArray;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author nico
 */
@Startup
@Singleton
@LocalBean
public class InitBean {
    
    @PersistenceContext
    private EntityManager em;
    
    @PostConstruct
    public void init() {
        
        System.out.println("en iniiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiit");
         
        Client client;
        WebTarget target;
            
        client = ClientBuilder.newClient();
        //example query params: ?q=Turku&cnt=10&mode=json&units=metric
        target = client.target("http://dataservice.accuweather.com/locations/v1/regions?apikey=NRz3StKqlddelC62eyhr6XWrPmFMLdXM");
        
        JsonArray response = target.request(MediaType.APPLICATION_JSON).get(JsonArray.class);
        System.out.println(response);
    }
}
