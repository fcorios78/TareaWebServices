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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "aeropuertos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Aeropuertos.findAll", query = "SELECT a FROM Aeropuertos a")
    , @NamedQuery(name = "Aeropuertos.findByIdaeropuerto", query = "SELECT a FROM Aeropuertos a WHERE a.idaeropuerto = :idaeropuerto")
    , @NamedQuery(name = "Aeropuertos.findByAeropuerto", query = "SELECT a FROM Aeropuertos a WHERE a.aeropuerto = :aeropuerto")
    , @NamedQuery(name = "Aeropuertos.findByCiudad", query = "SELECT a FROM Aeropuertos a WHERE a.ciudad = :ciudad")})
public class Aeropuertos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idaeropuerto")
    private Integer idaeropuerto;
    @Basic(optional = false)
    @Column(name = "aeropuerto")
    private String aeropuerto;
    @Basic(optional = false)
    @Column(name = "ciudad")
    private String ciudad;
    @JoinColumn(name = "idpais", referencedColumnName = "idpais")
    @ManyToOne(optional = false)
    private Paises idpais;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idorigen")
    private List<Vuelos> vuelosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iddestino")
    private List<Vuelos> vuelosList1;

    public Aeropuertos() {
    }

    public Aeropuertos(Integer idaeropuerto) {
        this.idaeropuerto = idaeropuerto;
    }

    public Aeropuertos(Integer idaeropuerto, String aeropuerto, String ciudad) {
        this.idaeropuerto = idaeropuerto;
        this.aeropuerto = aeropuerto;
        this.ciudad = ciudad;
    }

    public Integer getIdaeropuerto() {
        return idaeropuerto;
    }

    public void setIdaeropuerto(Integer idaeropuerto) {
        this.idaeropuerto = idaeropuerto;
    }

    public String getAeropuerto() {
        return aeropuerto;
    }

    public void setAeropuerto(String aeropuerto) {
        this.aeropuerto = aeropuerto;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public Paises getIdpais() {
        return idpais;
    }

    public void setIdpais(Paises idpais) {
        this.idpais = idpais;
    }

    @XmlTransient
    public List<Vuelos> getVuelosList() {
        return vuelosList;
    }

    public void setVuelosList(List<Vuelos> vuelosList) {
        this.vuelosList = vuelosList;
    }

    @XmlTransient
    public List<Vuelos> getVuelosList1() {
        return vuelosList1;
    }

    public void setVuelosList1(List<Vuelos> vuelosList1) {
        this.vuelosList1 = vuelosList1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idaeropuerto != null ? idaeropuerto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Aeropuertos)) {
            return false;
        }
        Aeropuertos other = (Aeropuertos) object;
        if ((this.idaeropuerto == null && other.idaeropuerto != null) || (this.idaeropuerto != null && !this.idaeropuerto.equals(other.idaeropuerto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.aerolinea.entidad.Aeropuertos[ idaeropuerto=" + idaeropuerto + " ]";
    }
    
}
