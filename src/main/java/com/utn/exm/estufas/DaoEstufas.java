/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utn.exm.estufas;

import java.util.List;
import javax.ejb.Stateless;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.persistence.EntityManager;

/**
 *
 * @author Edgar Xochipa
 */
@Stateless
@Dependent
public class DaoEstufas {
    @Inject
    private EntityManager em;
    public List<Estufa> consulta() {
        return em.createQuery("SELECT e FROM Estufa e ORDER BY e.marca",
        Estufa.class).getResultList();
  }
  public Estufa busca(Integer id) {
    return em.find(Estufa.class, id);
  }
  public void agrega(Estufa modeloE) {
    em.persist(modeloE); 
  }
  public void modifica(Estufa modeloE) {
    em.merge(modeloE);
  }
  public void elimina(Estufa modeloE) {
    final Estufa anterior = em.find(Estufa.class, modeloE.getId());
    if (anterior != null) {
        em.remove(anterior);
    }
  }
}
