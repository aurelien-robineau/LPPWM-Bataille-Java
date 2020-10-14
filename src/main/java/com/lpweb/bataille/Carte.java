package com.lpweb.bataille;

import java.util.ArrayList;
import java.util.Arrays;

public class Carte
{
    private String couleur;

    private String valeur;

    static final ArrayList<String> COULEURS = new ArrayList<>(
        Arrays.asList("piques", "trèfle", "coeur", "carreau")
    );

    static final ArrayList<String> VALEURS = new ArrayList<>(
        Arrays.asList("2", "3", "4", "5", "6", "7", "8", "9", "10", "valet", "dame", "roi", "as")
    );

    public Carte(String couleur, String valeur) {
        this.couleur = couleur;
        this.valeur = valeur;
    }

    public String getValeur() {
        return this.valeur;
    }

    public boolean bat(Carte carte) {
        return Carte.VALEURS.indexOf(this.valeur) > Carte.VALEURS.indexOf(carte.getValeur());
    }

    @Override
    public String toString() {
        return this.valeur + " de " + this.couleur;
    }
}
