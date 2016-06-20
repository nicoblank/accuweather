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
 * @author nico
 */
@Stateless
@LocalBean
public class PaisBean {
    
    private String ID;
    private String LocalizedName;
    private String EnglishName;

    public String getID() {
        return ID;
    }

    public String getLocalizedName() {
        return LocalizedName;
    }

    public String getEnglishName() {
        return EnglishName;
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

    
    

}
