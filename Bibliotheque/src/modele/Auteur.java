/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author fdefillon
 */
@Entity
public class Auteur implements Serializable {
    /*
    ATTRIBUTS
    */
    private static final long serialVersionUID = 1L; //pour versionnage de classe
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    
    private Long id;
    private String nom;
    
    @OneToMany(mappedBy = "auteur", cascade = CascadeType.PERSIST)
    private List<Ouvrage> oeuvre = new ArrayList<Ouvrage>();

    /*
    CONSTRUCTEURS
    */
    
    public Auteur() {
    }

    public Auteur(String nom) {
        this.nom = nom;
    }
    
    /*
    GETTERS ET SETTERS
    */
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    
    public List<Ouvrage> getOeuvre() {
        return oeuvre;
    }

    public void setOeuvre(List<Ouvrage> oeuvre) {
        this.oeuvre = oeuvre;
    }
    /*
    RESTE
    */
    
    public void addOuvrage(Ouvrage o) {
        o.setAuteur(this);
        oeuvre.add(o);
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
        if (!(object instanceof Auteur)) {
            return false;
        }
        Auteur other = (Auteur) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Auteur{" + "nom=" + nom + '}';
    }   
}
