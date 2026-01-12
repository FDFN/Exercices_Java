/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import javax.persistence.EntityManager;
import modele.Emprunteur;
import util.JpaUtil;

/**
 *
 * @author fdefillon
 */
public class EmprunteurDao {
    public void createEmprunteur(Emprunteur e) {
        EntityManager em=JpaUtil.getEntityManager();
        em.persist(e);
    }
    
    public void updateEmprunteur(Emprunteur e) {
        EntityManager em=JpaUtil.getEntityManager();
        em.merge(e);
    }
    
}
