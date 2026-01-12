/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dao.OuvrageDao;
import java.util.List;
import javax.persistence.EntityTransaction;
import modele.Ouvrage;
import util.JpaUtil;

/**
 *
 * @author fdefillon
 */
public class ServicesImpl implements ServicesOuvrage {
    @Override
    public void referencerOuvrage(Ouvrage o) {
        OuvrageDao dao = new OuvrageDao();
        EntityTransaction tx = null;
        try {
            tx = JpaUtil.getEntityTransaction();
            tx.begin();
            dao.createOuvrage(o);
            tx.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            if(tx != null && tx.isActive()) {
                tx.rollback();
            }
        } finally {
            JpaUtil.closeEntityManager();
        }
    }

    @Override
    public void modifierOuvrage(Ouvrage o) {
        OuvrageDao dao = new OuvrageDao();
        EntityTransaction tx = null;
        try {
            tx = JpaUtil.getEntityTransaction();
            tx.begin();
            dao.updateOuvrage(o);
            tx.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            if(tx != null && tx.isActive()) {
                tx.rollback();
            }
        } finally {
            JpaUtil.closeEntityManager();
        }
    }
    
     @Override
    public void dereferencerOuvrage(Ouvrage o) {
        OuvrageDao dao = new OuvrageDao();
        EntityTransaction tx = null;
        try {
            tx = JpaUtil.getEntityTransaction();
            tx.begin();
            dao.deleteOuvrage(o);
            tx.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            if(tx != null && tx.isActive()) {
                tx.rollback();
            }
        } finally {
            JpaUtil.closeEntityManager();
        }
    }
    
    
    @Override
    public List<Ouvrage> listerTousLesOuvrages() {
        OuvrageDao dao = new OuvrageDao();
        return dao.findAllOuvrage();
    }

    @Override
    public Ouvrage trouverOuvrageParNumero(Long numero) {
        OuvrageDao dao = new OuvrageDao();
        return dao.findOuvrageByID(numero);
    }



   
}
