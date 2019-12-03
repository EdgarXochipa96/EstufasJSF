/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utn.exm.estufas;

import com.utn.exm.estufas.resources.Mensajes;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Edgar Xochipa
 */
@Named
@ViewScoped
public class CtrlEstufaNuevo implements Serializable{
    private static final long serialVersionUID = 1L;
  @Inject
  private Mensajes mensajes;
  @Inject
  private DaoEstufas dao;
  private Estufa modelo;
  @PostConstruct
  void init() {
    modelo = new Estufa();
  }
  public Estufa getModelo() {
    return modelo;
  }
  
  public String guarda() {
    try {
      dao.agrega(modelo);
      return "index?faces-redirect=true";
    } catch (Exception ex) {
      mensajes.procesa(ex);
      return null;
    }
  }
}
