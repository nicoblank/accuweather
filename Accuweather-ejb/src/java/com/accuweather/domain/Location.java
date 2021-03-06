/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.accuweather.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author nico
 */
@Entity
public class Location implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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

    public void setId(Long id) {
        this.id = id;
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

    
    
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Location)) {
            return false;
        }
        Location other = (Location) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ejb.Location[ id=" + id + " ]";
    }
    
}
