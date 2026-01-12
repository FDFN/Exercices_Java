/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 *
 * @author fdefillon
 */
@Entity
public class Emprunteur implements Serializable {
    /*
    ATTRIBUTS
    */
    
    private static final long serialVersionUID = 1L; //pour versionnage de classe
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String nom;

    private String adresse;

    @OneToOne(mappedBy="emprunteur")
    private Ouvrage emprunt;

    /*
    CONSTRUCTEURS
    */
    
    public Emprunteur() {
    }

    public Emprunteur(String nom, String adresse) {
        this.nom = nom;
        this.adresse = adresse;
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
    
    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
    
    public Ouvrage getEmprunt() {
        return emprunt;
    }

    public void setEmprunt(Ouvrage emprunt) {
        this.emprunt = emprunt;
    }

    /*
    RESTE
    */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Emprunteur)) {
            return false;
        }
        Emprunteur other = (Emprunteur) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Emprunteur{" + "id=" + id + ", nom=" + nom + ", adresse=" + adresse + '}';
    }

    
}
