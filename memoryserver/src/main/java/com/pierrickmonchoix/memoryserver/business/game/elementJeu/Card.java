package com.pierrickmonchoix.memoryserver.business.game.elementJeu;

public class Card {
    private Coordinates coordinates;
    private ECardType typeCarte;


    public Card(ECardType typeCarte) {
        this.typeCarte = typeCarte;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public ECardType getTypeCarte() {
        return typeCarte;
    }

    public void setTypeCarte(ECardType typeCarte) {
        this.typeCarte = typeCarte;
    }


 
 

}
