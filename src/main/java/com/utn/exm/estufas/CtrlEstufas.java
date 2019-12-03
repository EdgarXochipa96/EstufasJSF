/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utn.exm.estufas;

import com.utn.exm.estufas.resources.Mensajes;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Edgar Xochipa
 */
@Named
@RequestScoped
public class CtrlEstufas {
    @Inject
    private Mensajes mensajes;
    @Inject
    private DaoEstufas dao;
    private List<Estufa> instancias;
    
    @PostConstruct
    void init(){
        try{
            instancias = dao.consulta();
        }catch(Exception ex){
            mensajes.procesa(ex);
        }
    }
    public List<Estufa>getInstancias(){
        return instancias;
    }
}
