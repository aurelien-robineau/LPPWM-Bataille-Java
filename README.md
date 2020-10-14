# LPPWM - JAVA - Jeu de bataille
Jeu de bataille réalisé en JAVA dans le cadre d'un TP à la licence professionelle Projet Web et Mobile de Sorbonne Université.

## Règles retenues
Les règles retenues pour le jeu de la bataille sont les suivantes (tirées de [wikipédia](https://fr.wikipedia.org/wiki/Bataille_%28jeu%29#R%C3%A8gle_actuelle)):
* On distribue l'ensemble d'un jeu de 52 cartes aux deux joueurs
* À chaque tour, chaque joueur joue la carte du haut de sa main
* Celui qui a la carte de la plus haute valeur (selon la hiérarchie as, roi, dame, valet, dix… jusqu'au deux) fait la levée, qu'il place sous son tas
* En cas d'égalité de valeurs (bataille), les joueurs placent une première carte face cachée puis une seconde carte face visible pour décider qui fera la levée
* En cas de nouvelle égalité, la procédure est répétée. À la fin, le joueur gagnant remporte toutes les cartes, qu'il place sous son tas
* Si un joueur n'a plus assez de cartes pour finir la bataille (au moins deux cartes), il perd la manche et donc la partie
* La partie se termine lorsqu'un joueur possède toutes les cartes. C'est alors le gagnant

## Changements par rapport aux consignes
### Classe PaquetDeCarte
Afin de faciliter la lecture l'implémentation et la lecture du code, j'ai ajouté une classe `PaquetDeCarte`.
Cela permet de moins utiliser d'`ArrayList<Carte>` et de factoriser certaines opérations redondantes.

### Points
Comme constaté dans les règles retenues, la gestion des points se fait par le nombre de cartes restantes pour un joueur.
Je n'ai donc pas implémenté de système de point et j'utilise `joueur.getPaquet().size()`.

## Logs
À chaque manche, un récapitulatif est affiché.
```
--- Manche 168 -------
Gagnant: Gérard (Didier: 4 de coeur, Gérard: valet de coeur)
Nombre de cartes: Didier 14, Gérard 38
```
Il est possible d'activer/désactiver l'affichage des manches via l'attribut `private static final boolean AFFICHER_MANCHES` de la classe `Bataille`.
