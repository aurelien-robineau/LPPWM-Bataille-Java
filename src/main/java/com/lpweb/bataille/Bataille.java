package com.lpweb.bataille;

public class Bataille 
{
    private static final boolean AFFICHER_MANCHES = true;

    public static void main( String[] args )
    {
        Joueur joueur1 = new Joueur("Didier");
        Joueur joueur2 = new Joueur("Gérard");

        PaquetDeCarte paquet = new PaquetDeCarte(true);
        paquet.melanger();
        paquet.distribuer(joueur1, joueur2);

        int nombreDeManches = 0;
        // Jouer tant qu'il n'y a pas de gagnant (ie. que les deux joueurs ont des cartes)
        while (joueur1.getPaquet().size() != 0 && joueur2.getPaquet().size() != 0) {
            nombreDeManches++;

            print("\n--- Manche " + nombreDeManches + " -------");
            jouerUneManche(joueur1, joueur2);
        }

        afficherGagnant(joueur1, joueur2, nombreDeManches);
    }

    private static void jouerUneManche(Joueur joueur1, Joueur joueur2) {
        PaquetDeCarte cartesSurTable = new PaquetDeCarte(false);
        
        Joueur gagnant = null;
        // Jouer la manche tant qu'elle n'a pas de gagnants (ie. qu'il y a bataille)
        while (gagnant == null) {
            Carte carteJoueur1 = joueur1.jouerProchaineCarte();
            Carte carteJoueur2 = joueur2.jouerProchaineCarte();
            cartesSurTable.ajouterAuDessus(carteJoueur1);
            cartesSurTable.ajouterAuDessus(carteJoueur2);

            // On trouve le gagant s'il y en un
            if (carteJoueur1.bat(carteJoueur2)) {
                gagnant = joueur1;
            }
            else if (carteJoueur2.bat(carteJoueur1)) {
                gagnant = joueur2;
            }
            
            // S'il y a un gagnant, il récupère toutes les cartes jouées pendant la manche
            if (gagnant != null) {
                print("Gagnant: " + gagnant + " (" + joueur1 + ": " + carteJoueur1 + ", " + joueur2 + ": " + carteJoueur2 + ")");
                // On mélange afin d'éviter la création de patterns qui peuvent conduire à une partie infinie
                cartesSurTable.melanger();
                gagnant.getPaquet().fussionnerParDessous(cartesSurTable);
                print("Nombre de cartes: " + joueur1 + " " + joueur1.getPaquet().size() + ", " + joueur2 + " " + joueur2.getPaquet().size());
            }
            // Sinon c'est qu'il y a bataille
            else {
                print("Bataille ! (" + joueur1 + ": " + carteJoueur1 + ", " + joueur2 + ": " + carteJoueur2 + ")");

                // Si un des deux joueurs n'a plus assez de carte pour la bataille (minimum 2), il perd la manche
                if (joueur1.getPaquet().size() < 2 || joueur2.getPaquet().size() < 2) {
                    gagnant = joueur1.getPaquet().size() >= 2 ? joueur1 : joueur2;
                    gagnant.getPaquet().fussionnerParDessous(cartesSurTable);
                }
                // Sinon chaque joueur ajoute une nouvelle carte sur la table
                else {
                    cartesSurTable.ajouterAuDessus(joueur1.jouerProchaineCarte());
                    cartesSurTable.ajouterAuDessus(joueur2.jouerProchaineCarte());
                }
            }
        }
    }

    private static void afficherGagnant(Joueur joueur1, Joueur joueur2, int nombreDeManches) {
        Joueur gagnant = joueur1.getPaquet().size() > joueur2.getPaquet().size() ? joueur1 : joueur2;
        System.out.println("\n!!! " + gagnant + " gagne en " + nombreDeManches + " manches !!!" );
    }

    private static void print(String message) {
        if (AFFICHER_MANCHES) {
            System.out.println(message);
        }
    }
}
