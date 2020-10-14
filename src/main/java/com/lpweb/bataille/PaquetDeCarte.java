package com.lpweb.bataille;

import java.util.ArrayList;
import java.util.Collections;

public class PaquetDeCarte
{
    private ArrayList<Carte> cartes = new ArrayList<>();

    public PaquetDeCarte(boolean initialiser) {
        if (initialiser) {
            for (String couleur : Carte.COULEURS) {
                for (String valeur : Carte.VALEURS) {
                    this.cartes.add(new Carte(couleur, valeur));
                }
            }
        }
    }

    public ArrayList<Carte> getCartes() {
        return this.cartes;
    }

    public void melanger() {
        Collections.shuffle(this.cartes);
    }

    public void distribuer(Joueur joueur1, Joueur joueur2) {
        Carte carte = null;
        while (this.cartes.size() > 1) {
            carte = this.cartes.remove(this.cartes.size() - 1);
            joueur1.getPaquet().ajouterAuDessus(carte);

            carte = this.cartes.remove(this.cartes.size() - 1);
            joueur2.getPaquet().ajouterAuDessus(carte);
        }
    }

    public void ajouterAuDessus(Carte carte) {
        this.cartes.add(carte);
    }

    public void ajouterAuDessus(ArrayList<Carte> cartes) {
        for (Carte carte : cartes) {
            this.cartes.add(carte);
        }
    }

    public void ajouterEnDessous(Carte carte) {
        this.cartes.add(0, carte);
    }

    public void ajouterEnDessous(ArrayList<Carte> cartes) {
        for (Carte carte : cartes) {
            this.cartes.add(0, carte);
        }
    }

    public Carte enleverCarte(Carte carte) {
        int indexCarte = this.cartes.indexOf(carte);
        return this.cartes.remove(indexCarte);
    }

    public Carte carteDuDessus() {
        return this.cartes.get(this.cartes.size() - 1);
    }

    public int size() {
        return this.cartes.size();
    }

    @Override
    public String toString() {
        return
         "Paquet de " + this.cartes.size() + " cartes :\n" + this.cartes;
    }
}
