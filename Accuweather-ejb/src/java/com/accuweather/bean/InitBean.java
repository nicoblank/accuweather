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
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javax.ejb.EJB;


/**
 *
 * @author nico
 */
@Startup
@Singleton
@LocalBean
public class InitBean {
    
    @EJB
    private LocationBean locationBean;
    
    @PostConstruct
    public void init() {
        
        System.out.println("en iniiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiit");
         
        Client client;
        WebTarget target;
        LocationDto locationDto;
        String region,regionCode,pais,paisCode,ciudad,ciudadCode;
        RegionBean regionBean = new RegionBean();
        PaisBean paisBean = new PaisBean();
        CiudadBean ciudadBean = new CiudadBean();
        Gson transformer = new GsonBuilder().create(); 
            
        client = ClientBuilder.newClient();
        //System.out.println("0000000000000000000");
        target = client.target("http://dataservice.accuweather.com/locations/v1/regions?apikey=UgipgbtgQCzFDQvsCHCpmlE3s0UDH5nG");
        
        JsonArray responseRegiones = target.request(MediaType.APPLICATION_JSON).get(JsonArray.class);
        //System.out.println(responseRegiones);
        
        //System.out.println("111111111111111111");
        
        for(int i = 0 ; i < /*responseRegiones.size()*/1; i++){
            
            regionBean = transformer.fromJson(responseRegiones.getJsonObject(i).toString(), RegionBean.class);
            
            regionCode = "NAM";//regionBean.getID();
            region = "North America";//regionBean.getLocalizedName();
            
            target = client.target("http://dataservice.accuweather.com/locations/v1/countries/" + regionCode + "?apikey=UgipgbtgQCzFDQvsCHCpmlE3s0UDH5nG");
            
            JsonArray responsePaises = target.request(MediaType.APPLICATION_JSON).get(JsonArray.class);
            
            //System.out.println("2222222222222222");

            for(int j = 0 ; j < responsePaises.size(); j++){
                paisBean = transformer.fromJson(responsePaises.getJsonObject(j).toString(), PaisBean.class);

                paisCode = paisBean.getID();
                pais = paisBean.getLocalizedName();

                target = client.target("http://dataservice.accuweather.com/locations/v1/adminareas/" + paisCode + "?apikey=UgipgbtgQCzFDQvsCHCpmlE3s0UDH5nG");

                JsonArray responseCiudades = target.request(MediaType.APPLICATION_JSON).get(JsonArray.class);
                //System.out.println("33333333333333333");

                for(int k = 0 ; k < responseCiudades.size(); k++){
                    ciudadBean = transformer.fromJson(responseCiudades.getJsonObject(k).toString(), CiudadBean.class);

                    ciudadCode = ciudadBean.getID();
                    ciudad = ciudadBean.getLocalizedName();
                    
                    locationDto = new LocationDto();
                    
                    locationDto.setRegion_code(regionCode);
                    locationDto.setRegion(region);
                    locationDto.setPais_code(paisCode);
                    locationDto.setPais(pais);
                    locationDto.setArea_code(ciudadCode);
                    locationDto.setArea(ciudad);
                    
                    //System.out.println("44444444444444444444");

                    System.out.println(locationDto.getArea());
                    locationBean.createLocation(locationDto);          
                    //System.out.println(locationDto.getArea());
                    
                }
                
                
            }
      
        }
             
    }
}
