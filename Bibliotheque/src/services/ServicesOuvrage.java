/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.util.List;
import modele.Ouvrage;

/**
 *
 * @author fdefillon
 */
public interface ServicesOuvrage {
    public void referencerOuvrage(Ouvrage o);
    public Ouvrage trouverOuvrageParNumero(Long numero);
    public List<Ouvrage> listerTousLesOuvrages();
    public void modifierOuvrage(Ouvrage o);
    public void dereferencerOuvrage(Ouvrage o);
    
}
