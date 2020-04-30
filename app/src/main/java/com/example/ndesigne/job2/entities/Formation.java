package com.example.ndesigne.job2.entities;

public class Formation {
    public String date, nom, etablissement="";

    public Formation(String date, String nom, String etablissement) {
        this.date = date;
        this.nom = nom;
        this.etablissement = etablissement;
    }
}
