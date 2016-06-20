/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.accuweather.bean;

import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author vero
 */
@Stateless
@LocalBean
public class CiudadBean {
    
    private String ID;
    private String LocalizedName;
    private String EnglishName;
    private String Level;
    private String LocalizedType;
    private String EnglishType;
    private String CountryID;
    
   
    public String getID() {
        return ID;
    }

    public String getLocalizedName() {
        return LocalizedName;
    }

    public String getEnglishName() {
        return EnglishName;
    }

    public String getLevel() {
        return Level;
    }

    public String getLocalizedType() {
        return LocalizedType;
    }

    public String getEnglishType() {
        return EnglishType;
    }

    public String getCountryID() {
        return CountryID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setLocalizedName(String LocalizedName) {
        this.LocalizedName = LocalizedName;
    }

    public void setEnglishName(String EnglishName) {
        this.EnglishName = EnglishName;
    }

    public void setLevel(String Level) {
        this.Level = Level;
    }

    public void setLocalizedType(String LocalizedType) {
        this.LocalizedType = LocalizedType;
    }

    public void setEnglishType(String EnglishType) {
        this.EnglishType = EnglishType;
    }

    public void setCountryID(String CountryID) {
        this.CountryID = CountryID;
    }

}
