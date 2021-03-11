package com.pierrickmonchoix.memoryserver.business.game.elementsJeu.carte;

/**
 * carte de jeu
 */
public class Card {
    private Coordinates coordinates;
    private ECardType typeCarte;
    private boolean revealed;



    public Card(ECardType typeCarte) {
        this.typeCarte = typeCarte;
        this.revealed = false;
    }

    public Coordinates getCoordinates() {
        return this.coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public ECardType getTypeCarte() {
        return this.typeCarte;
    }

    public void setTypeCarte(ECardType typeCarte) {
        this.typeCarte = typeCarte;
    }

    public boolean isRevealed() {
        return this.revealed;
    }

    public boolean getRevealed() {
        return this.revealed;
    }

    public void setRevealed(boolean revealed) {
        this.revealed = revealed;
    }
   



 
 

}
