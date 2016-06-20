/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.accuweather.bean;

import com.accuweather.domain.Location;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


/**
 *
 * @author nico
 */
@Stateless
@LocalBean
public class LocationBean {
    
    @PersistenceContext
    private EntityManager em;
    
    public void createLocation(LocationDto dto) {
        
        //System.out.println(dto.getId());
        System.out.println(dto.getPais());
        Location location = toEntity(dto);
        em.persist(location);
        //return toDto(location);
    }
    
    /*
    private LocationDto toDto(Location entity) {
        LocationDto dto = new LocationDto();
        dto.setId(entity.getId());
        //dto.setName(entity.getName());
        
        return dto;
    }
    */
    private Location toEntity(LocationDto dto) {
        Location entity = new Location();
        
        entity.setRegion_code(dto.getRegion_code());
        entity.setRegion(dto.getRegion());
        entity.setPais_code(dto.getPais_code());
        entity.setPais(dto.getPais());
        entity.setArea_code(dto.getArea_code());
        entity.setArea(dto.getArea());
        
        return entity;
    }
    
    
}
