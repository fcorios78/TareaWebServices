/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aerolinea.entidad;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author fcori
 */
@Entity
@Table(name = "reservaciones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Reservaciones.findAll", query = "SELECT r FROM Reservaciones r")
    , @NamedQuery(name = "Reservaciones.findByIdreservacion", query = "SELECT r FROM Reservaciones r WHERE r.idreservacion = :idreservacion")
    , @NamedQuery(name = "Reservaciones.findByNboletos", query = "SELECT r FROM Reservaciones r WHERE r.nboletos = :nboletos")})
public class Reservaciones implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idreservacion")
    private Integer idreservacion;
    @Basic(optional = false)
    @Column(name = "nboletos")
    private int nboletos;
    @JoinColumn(name = "idusuario", referencedColumnName = "idusuario")
    @ManyToOne(optional = false)
    private Usuarios idusuario;
    @JoinColumn(name = "idvuelo", referencedColumnName = "idvuelo")
    @ManyToOne(optional = false)
    private Vuelos idvuelo;

    public Reservaciones() {
    }

    public Reservaciones(Integer idreservacion) {
        this.idreservacion = idreservacion;
    }

    public Reservaciones(Integer idreservacion, int nboletos) {
        this.idreservacion = idreservacion;
        this.nboletos = nboletos;
    }

    public Integer getIdreservacion() {
        return idreservacion;
    }

    public void setIdreservacion(Integer idreservacion) {
        this.idreservacion = idreservacion;
    }

    public int getNboletos() {
        return nboletos;
    }

    public void setNboletos(int nboletos) {
        this.nboletos = nboletos;
    }

    public Usuarios getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Usuarios idusuario) {
        this.idusuario = idusuario;
    }

    public Vuelos getIdvuelo() {
        return idvuelo;
    }

    public void setIdvuelo(Vuelos idvuelo) {
        this.idvuelo = idvuelo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idreservacion != null ? idreservacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reservaciones)) {
            return false;
        }
        Reservaciones other = (Reservaciones) object;
        if ((this.idreservacion == null && other.idreservacion != null) || (this.idreservacion != null && !this.idreservacion.equals(other.idreservacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.aerolinea.entidad.Reservaciones[ idreservacion=" + idreservacion + " ]";
    }
    
}
