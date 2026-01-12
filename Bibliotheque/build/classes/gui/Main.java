/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.io.IOException;
import services.ServicesImpl;
import modele.Ouvrage;

/**
 *
 * @author fdefillon
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        Ouvrage Memoires = new Ouvrage("Mémoires d'Outre-Tombe", 1848);
        Ouvrage LOTR = new Ouvrage("The Lord of the Rings", 1954);
        Ouvrage Fondation = new Ouvrage("Fondation", 1950);
        Ouvrage Karamazov = new Ouvrage("Les Frères Karamazov", 1882);
        
        Karamazov.setAnneeDeParution(1881);
        
        ServicesImpl services =new ServicesImpl();
        services.referencerOuvrage(Memoires);
        services.referencerOuvrage(LOTR);
        services.referencerOuvrage(Fondation);
        services.referencerOuvrage(Karamazov);
        
        System.out.println(services.listerTousLesOuvrages());
        
        Ouvrage o = services.trouverOuvrageParNumero(new Long(3));
        System.out.println(o);
        services.dereferencerOuvrage(o);
        
        LOTR.setAnneeDeParution(1953);
        services.modifierOuvrage(LOTR);
        
        System.out.println(services.listerTousLesOuvrages());
        
    }
    
}
