/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import modele.Emprunteur;
import modele.Ouvrage;

/**
 *
 * @author fdefillon
 */
public interface ServicesEmprunteur {
    public void referencerEmprunteur(Emprunteur e);
    public void preterOuvrage(Emprunteur e, Ouvrage o);
}
