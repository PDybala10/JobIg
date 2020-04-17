package com.example.ndesigne.job2;

import com.example.ndesigne.job2.entities.Offre;

import java.util.ArrayList;

public class OffreCategorie {
    /**
     * Cette classe permet de regroupe les offres par categorie
     * Elle possede deux attributs:
     *  -titre: designe le nom de la categorie
     *  -data: est une liste des offres de cette categorie
     * */
    private String titre="";
    private ArrayList<Offre> offres = new ArrayList<Offre>();

    public OffreCategorie() {
        /*
        * constructeur par defaut pour les tests devra etre modifier par la suite
        * */
        titre="Default Categorie";
        for(int i=0; i<5; i++){
            offres.add(new Offre());
        }
    }

    public String getTitre() {
        return titre;
    }

    public ArrayList<Offre> getOffres() {
        return offres;
    }
}
