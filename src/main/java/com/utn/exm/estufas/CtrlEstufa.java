/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utn.exm.estufas;

import com.utn.exm.estufas.resources.Mensajes;
import java.io.Serializable;
import javax.faces.context.ExternalContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Edgar Xochipa
 */
@Named
@ViewScoped
public class CtrlEstufa implements Serializable {
    private static final long serialVersionUID = 1L;
    @Inject
    private Mensajes mensajes;
    @Inject
    private ExternalContext externalContext;
    @Inject
    private DaoEstufas dao;
    private Integer id;
    private Estufa modeloE;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Estufa getModeloE() {
        return modeloE;
    }
    
    public void init(){
        try{
            leeId();
            this.modeloE = dao.busca(id);
        }catch(NumberFormatException e){
            mensajes.error(null,"id no encontrado.");
        }catch(Exception e){
            mensajes.procesa(e);
        }
    }
    
    private void leeId() throws NumberFormatException {
        final String parametroId =
            externalContext.getRequestParameterMap().get("id");
        id = new Integer(parametroId);
    }
    public String guarda(){
        try{
            dao.modifica(modeloE);
            return "index?faces-redirect=true";
        }catch(Exception ex){
            mensajes.procesa(ex);
            return null;
        }    
    }
    public String elimina(){
        try{
            if(modeloE != null){
                dao.elimina(modeloE);
                return "index?faces-redirect=true";
            }
        }catch(Exception ex){
            mensajes.procesa(ex);
        }
        return null;
    }

    
    
    
    
}
