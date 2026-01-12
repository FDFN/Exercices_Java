/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import modele.Auteur;
import modele.Emprunteur;
import modele.Ouvrage;
import services.ServicesImpl;

public class Main {
    public static void main(String[] args) {
        Auteur a1=new Auteur("Victor Hugo");
        Auteur a2=new Auteur("Emile Zola");
        
        Ouvrage o1 = new Ouvrage("Notre-Dame de Paris", 1831);
        Ouvrage o2 = new Ouvrage("Germinal", 1885, a2);
        Ouvrage o3 = new Ouvrage("Les Misérables", 1862);
        Ouvrage o4 = new Ouvrage("La Petite Fadette", 1849, new Auteur("George Sand"));
        
        a1.addOuvrage(o1);
        a1.addOuvrage(o3);
        
        ServicesImpl services =new ServicesImpl();
        services.referencerAuteur(a1);
        services.referencerOuvrage(o2);
        services.referencerOuvrage(o4);
        
        System.out.println(services.ListerTousLesAuteurs());
        System.out.println(services.ListerLesOuvragesDunAuteur(a1));
        System.out.println(services.ListerLesOuvragesDunAuteur(a2));
        System.out.println(services.ListerLesOuvragesDunAuteur("George Sand"));
        
        Emprunteur e1=new Emprunteur("Jean", "22 rue ici");
        Emprunteur e2=new Emprunteur("Stéphanie", "35 rue là");
        Emprunteur e3=new Emprunteur("Clémentine", "27 rue par ici");
        
        services.referencerEmprunteur(e1);
        services.referencerEmprunteur(e2);
        
        services.preterOuvrage(e2, o4);
        services.preterOuvrage(e3, o2);
        services.preterOuvrage(new Emprunteur("Claire", "12 rue en bas"), o1);
        
        System.out.println(services.listerTousLesOuvrages());
    }
    
    
}

/*
//CI-DESSOUS : CODE DES EXEMPLES 1 ET 2


import java.io.IOException;
import services.ServicesImpl;
import modele.Ouvrage;


public class Main {
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
*/
