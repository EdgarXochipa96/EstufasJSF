/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utn.exm.estufas;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Edgar Xochipa
 */
@Entity
@Table(name="estufas")
public class Estufa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ESTUFA_ID")
    private Integer id;
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "ESTUFA_MARCA")
    private String marca;
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "ESTUFA_MODELO")
    private String modelo;
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "ESTUFA_NQUEMADORES")
    private String nquemadores;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getNquemadores() {
        return nquemadores;
    }

    public void setNquemadores(String nquemadores) {
        this.nquemadores = nquemadores;
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
        if (!(object instanceof Estufa)) {
            return false;
        }
        Estufa other = (Estufa) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.utn.exm.estufas.estufa[ id=" + id + " ]";
    }
    
}
