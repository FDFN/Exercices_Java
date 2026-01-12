/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dao.AuteurDao;
import dao.EmprunteurDao;
import dao.OuvrageDao;
import java.util.List;
import javax.persistence.EntityTransaction;
import modele.Auteur;
import modele.Emprunteur;
import modele.Ouvrage;
import util.JpaUtil;

/**
 *
 * @author fdefillon
 */
public class ServicesImpl implements ServicesOuvrage,ServicesAuteur,ServicesEmprunteur {
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

    @Override
    public void referencerAuteur(Auteur a) {
        AuteurDao dao = new AuteurDao();
        EntityTransaction tx = null;
        try {
            tx = JpaUtil.getEntityTransaction();
            tx.begin();
            dao.createAuteur(a);
            tx.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
        } finally {
            JpaUtil.closeEntityManager();
        }
    }

    @Override
    public List<Auteur> ListerTousLesAuteurs() {
        AuteurDao dao = new AuteurDao();
        return dao.findAllAuteur();
    }

    @Override
    public List<Ouvrage> ListerLesOuvragesDunAuteur(Auteur a) {
        OuvrageDao dao = new OuvrageDao();
        return dao.findOuvrageByAuteur(a);
    }

    @Override
    public List<Ouvrage> ListerLesOuvragesDunAuteur(String a) {
        OuvrageDao dao = new OuvrageDao();
        return dao.findOuvrageByAuteur(a);
    }
    
    @Override
    public void referencerEmprunteur(Emprunteur e) {
        EmprunteurDao dao = new EmprunteurDao();
        EntityTransaction tx = null;
        try {
            tx = JpaUtil.getEntityTransaction();
            tx.begin();
            dao.createEmprunteur(e);
            tx.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
        } finally {
            JpaUtil.closeEntityManager();
        }
    }

    @Override
    public void preterOuvrage(Emprunteur e, Ouvrage o) {
        OuvrageDao dao = new OuvrageDao();
        EmprunteurDao daoe = new EmprunteurDao();
        EntityTransaction tx = null;
        try {
            tx = JpaUtil.getEntityTransaction();
            tx.begin();
            e.setEmprunt(o);
            o.setEmprunteur(e);
            dao.updateOuvrage(o);
            daoe.updateEmprunteur(e);
            tx.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
        } finally {
            JpaUtil.closeEntityManager();
        }
    }
}
