/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aerolinea.entidad;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author fcori
 */
@Entity
@Table(name = "vuelos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vuelos.findAll", query = "SELECT v FROM Vuelos v")
    , @NamedQuery(name = "Vuelos.findByIdvuelo", query = "SELECT v FROM Vuelos v WHERE v.idvuelo = :idvuelo")
    , @NamedQuery(name = "Vuelos.findByFecha", query = "SELECT v FROM Vuelos v WHERE v.fecha = :fecha")
    , @NamedQuery(name = "Vuelos.findByEstado", query = "SELECT v FROM Vuelos v WHERE v.estado = :estado")
    , @NamedQuery(name = "Vuelos.findByPrecio", query = "SELECT v FROM Vuelos v WHERE v.precio = :precio")})
public class Vuelos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idvuelo")
    private Integer idvuelo;
    @Basic(optional = false)
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Column(name = "estado")
    private String estado;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "precio")
    private BigDecimal precio;
    @JoinColumn(name = "idorigen", referencedColumnName = "idaeropuerto")
    @ManyToOne(optional = false)
    private Aeropuertos idorigen;
    @JoinColumn(name = "iddestino", referencedColumnName = "idaeropuerto")
    @ManyToOne(optional = false)
    private Aeropuertos iddestino;
    @JoinColumn(name = "idavion", referencedColumnName = "idavion")
    @ManyToOne(optional = false)
    private Aviones idavion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idvuelo")
    private List<Reservaciones> reservacionesList;

    public Vuelos() {
    }

    public Vuelos(Integer idvuelo) {
        this.idvuelo = idvuelo;
    }

    public Vuelos(Integer idvuelo, Date fecha) {
        this.idvuelo = idvuelo;
        this.fecha = fecha;
    }

    public Integer getIdvuelo() {
        return idvuelo;
    }

    public void setIdvuelo(Integer idvuelo) {
        this.idvuelo = idvuelo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public Aeropuertos getIdorigen() {
        return idorigen;
    }

    public void setIdorigen(Aeropuertos idorigen) {
        this.idorigen = idorigen;
    }

    public Aeropuertos getIddestino() {
        return iddestino;
    }

    public void setIddestino(Aeropuertos iddestino) {
        this.iddestino = iddestino;
    }

    public Aviones getIdavion() {
        return idavion;
    }

    public void setIdavion(Aviones idavion) {
        this.idavion = idavion;
    }

    @XmlTransient
    public List<Reservaciones> getReservacionesList() {
        return reservacionesList;
    }

    public void setReservacionesList(List<Reservaciones> reservacionesList) {
        this.reservacionesList = reservacionesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idvuelo != null ? idvuelo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vuelos)) {
            return false;
        }
        Vuelos other = (Vuelos) object;
        if ((this.idvuelo == null && other.idvuelo != null) || (this.idvuelo != null && !this.idvuelo.equals(other.idvuelo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.aerolinea.entidad.Vuelos[ idvuelo=" + idvuelo + " ]";
    }
    
}
