/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import modele.Auteur;
import util.JpaUtil;

/**
 *
 * @author fdefillon
 */
public class AuteurDao {
    public void createAuteur(Auteur a){
        EntityManager em = JpaUtil.getEntityManager();
        em.persist(a);
    }
   
    public List<Auteur> findAllAuteur(){
        EntityManager em=JpaUtil.getEntityManager();
        Query query = em.createQuery("select a from Auteur as a");
        List<Auteur> liste = query.getResultList();
        return liste;
    }
}
