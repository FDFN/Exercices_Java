/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.util.List;
import modele.Auteur;
import modele.Ouvrage;

/**
 *
 * @author fdefillon
 */
public interface ServicesAuteur {
    public void referencerAuteur(Auteur a);
    public List<Auteur> ListerTousLesAuteurs();
    public List<Ouvrage> ListerLesOuvragesDunAuteur(Auteur a);
    public List<Ouvrage> ListerLesOuvragesDunAuteur(String a);
}
