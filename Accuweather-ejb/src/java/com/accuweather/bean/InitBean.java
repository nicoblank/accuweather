/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.accuweather.bean;

import com.accuweather.domain.Location;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.LocalBean;
import javax.ejb.Startup;
import javax.json.JsonArray;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


/**
 *
 * @author nico
 */
@Startup
@Singleton
@LocalBean
public class InitBean {
    

    
    @PostConstruct
    public void init() {
        
        System.out.println("en iniiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiit");
         
        Client client;
        WebTarget target;
        //Location location;
        String region,regionCode;
        RegionBean regionBean = new RegionBean();
        Gson transformer = new GsonBuilder().create();        
                
        client = ClientBuilder.newClient();
        
        target = client.target("http://dataservice.accuweather.com/locations/v1/regions?apikey=NRz3StKqlddelC62eyhr6XWrPmFMLdXM");
        
        JsonArray responseRegiones = target.request(MediaType.APPLICATION_JSON).get(JsonArray.class);
        //System.out.println(responseRegiones);
        
        
        for(int i = 0 ; i < responseRegiones.size(); i++){
            
            regionBean = transformer.fromJson(responseRegiones.getJsonObject(i).toString(), RegionBean.class);
            //System.out.println(regionBean.getID());      
            regionCode = regionBean.getID();//responseRegiones.getJsonObject(i).get("ID").toString();
            region = regionBean.getLocalizedName();//responseRegiones.getJsonObject(i).get("LocalizedName").toString();
            
            target = client.target("http://dataservice.accuweather.com/locations/v1/countries/" + regionCode + "?apikey=NRz3StKqlddelC62eyhr6XWrPmFMLdXM");
            
            JsonArray responsePaises = target.request(MediaType.APPLICATION_JSON).get(JsonArray.class);
            System.out.println(responsePaises);
           
            //region_code = response.LocalizedName
            //LocationDto locationDto = new LocationDto();
            //locationDto.setArea(area);
            //.setName("José Mauro de Vasconcelos");
            //AuthorDto zeze = authorBean.createAuthor(authorDto);
        }
             
    }
}
