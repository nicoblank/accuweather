/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.accuweather.bean;

import java.io.Serializable;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author vero
 */
@Stateless
@LocalBean
public class LocationDto implements Serializable{

    private Long id;
    private String region;
    private String region_code;
    private String pais;
    private String pais_code;
    private String area;
    private String area_code;
    private Long location_key;

    public Long getId() {
        return id;
    }

    public String getRegion() {
        return region;
    }

    public String getRegion_code() {
        return region_code;
    }

    public String getPais() {
        return pais;
    }

    public String getPais_code() {
        return pais_code;
    }

    public String getArea() {
        return area;
    }

    public String getArea_code() {
        return area_code;
    }

    public Long getLocation_key() {
        return location_key;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public void setRegion_code(String region_code) {
        this.region_code = region_code;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public void setPais_code(String pais_code) {
        this.pais_code = pais_code;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public void setArea_code(String area_code) {
        this.area_code = area_code;
    }

    public void setLocation_key(Long location_key) {
        this.location_key = location_key;
    }
    
    
    
}
