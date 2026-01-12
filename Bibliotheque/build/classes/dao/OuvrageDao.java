/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import util.JpaUtil;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import modele.Ouvrage;

/**
 *
 * @author fdefillon
 */
public class OuvrageDao {    
    public void createOuvrage(Ouvrage o) {
        EntityManager em = JpaUtil.getEntityManager();
        em.persist(o);
    }
   
    public void updateOuvrage(Ouvrage o) {
        EntityManager em = JpaUtil.getEntityManager();
        em.merge(o);
    }
    
    public void deleteOuvrage(Ouvrage o) {
        EntityManager em = JpaUtil.getEntityManager();
        em.remove(em.merge(o));
    }
    
    public List<Ouvrage> findAllOuvrage() {
        EntityManager em=JpaUtil.getEntityManager();
        Query query = em.createQuery("select o from Ouvrage as o");
        List<Ouvrage> liste = query.getResultList();
        return liste;
}
    
    public Ouvrage findOuvrageByID(Long id) {
        EntityManager em=JpaUtil.getEntityManager();
        return em.find(Ouvrage.class, id);
    }
}
