package com.lpweb.bataille;

public class Joueur
{
    private String nom;

    private PaquetDeCarte paquet;

    public Joueur(String nom) {
        this.nom = nom;
        this.paquet = new PaquetDeCarte(false);
    }

    public PaquetDeCarte getPaquet() {
        return this.paquet;
    }

    public Carte jouerProchaineCarte() {
        Carte carte = this.paquet.carteDuDessus();
        this.paquet.enleverCarte(carte);
        return carte;
    }

    @Override
    public String toString() {
        return this.nom;
    }
}
