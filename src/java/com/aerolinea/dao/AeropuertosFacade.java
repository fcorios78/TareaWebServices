/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aerolinea.dao;

import com.aerolinea.entidad.Aeropuertos;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author fcori
 */
@Stateless
public class AeropuertosFacade extends AbstractFacade<Aeropuertos> {

    @PersistenceContext(unitName = "WebServicesPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AeropuertosFacade() {
        super(Aeropuertos.class);
    }
    
}
