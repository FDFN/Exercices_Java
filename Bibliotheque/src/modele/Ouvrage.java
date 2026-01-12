/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 *
 * @author fdefillon
 */
@Entity
public class Ouvrage implements Serializable {
    /*
    ATTRIBUTS
    */
    private static final long serialVersionUID = 1L; //pour versionnage de classe
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    
    private Long id;
    private String titre;
    private int anneeDeParution;
    
    @ManyToOne (cascade = CascadeType.PERSIST)
    private Auteur auteur;
    
    @OneToOne
    @JoinColumn(name="EMPRUNTEUR_ID", nullable=true)
    private Emprunteur emprunteur;

    /*
    CONSTRUCTEURS
    */
    public Ouvrage() {
    }

    public Ouvrage(String titre, int anneeDeParution) {
        this.titre = titre;
        this.anneeDeParution = anneeDeParution;
    }
    
    public Ouvrage(String titre, int anneeDeParution, Auteur auteur) {
        this.titre = titre;
        this.anneeDeParution = anneeDeParution;
        this.auteur = auteur;
    }
    /*
    GETTERS ET SETTERS
    */
    
    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public int getAnneeDeParution() {
        return anneeDeParution;
    }

    public void setAnneeDeParution(int anneeDeParution) {
        this.anneeDeParution = anneeDeParution;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public Auteur getAuteur() {
        return auteur;
    }

    public void setAuteur(Auteur auteur) {
        this.auteur = auteur;
    }
    
    public Emprunteur getEmprunteur() {
        return emprunteur;
    }

    public void setEmprunteur(Emprunteur emprunteur) {
        this.emprunteur = emprunteur;
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
        if (!(object instanceof Ouvrage)) {
            return false;
        }
        Ouvrage other = (Ouvrage) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Ouvrage{" + 
                "id=" + id +
                ", titre=" + titre + 
                ", anneeDeParution=" + anneeDeParution + 
                ", auteur=" + auteur + 
                ", emprunteur=" + (emprunteur==null?"disponible":emprunteur.getNom()) + '}';
    }

       
}
