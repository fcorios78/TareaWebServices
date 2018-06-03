/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aerolinea.entidad;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author fcori
 */
@Entity
@Table(name = "aviones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Aviones.findAll", query = "SELECT a FROM Aviones a")
    , @NamedQuery(name = "Aviones.findByIdavion", query = "SELECT a FROM Aviones a WHERE a.idavion = :idavion")
    , @NamedQuery(name = "Aviones.findByCapacidad", query = "SELECT a FROM Aviones a WHERE a.capacidad = :capacidad")
    , @NamedQuery(name = "Aviones.findByDescripcion", query = "SELECT a FROM Aviones a WHERE a.descripcion = :descripcion")})
public class Aviones implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idavion")
    private Integer idavion;
    @Basic(optional = false)
    @Column(name = "capacidad")
    private int capacidad;
    @Basic(optional = false)
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idavion")
    private List<Vuelos> vuelosList;

    public Aviones() {
    }

    public Aviones(Integer idavion) {
        this.idavion = idavion;
    }

    public Aviones(Integer idavion, int capacidad, String descripcion) {
        this.idavion = idavion;
        this.capacidad = capacidad;
        this.descripcion = descripcion;
    }

    public Integer getIdavion() {
        return idavion;
    }

    public void setIdavion(Integer idavion) {
        this.idavion = idavion;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public List<Vuelos> getVuelosList() {
        return vuelosList;
    }

    public void setVuelosList(List<Vuelos> vuelosList) {
        this.vuelosList = vuelosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idavion != null ? idavion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Aviones)) {
            return false;
        }
        Aviones other = (Aviones) object;
        if ((this.idavion == null && other.idavion != null) || (this.idavion != null && !this.idavion.equals(other.idavion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.aerolinea.entidad.Aviones[ idavion=" + idavion + " ]";
    }
    
}
