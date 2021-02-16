package com.pierrickmonchoix.memoryserver.business.game.elementJeu;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;
import java.lang.Math;

public class Board {
    private static Logger logger = Logger.getLogger(Board.class.getName());

    
    private List<Card> listCards;

    private int tailleX = 3;
    private int tailleY = 4;

    public Board() {
        listCards.add(new Card(ECardType.UN));
        listCards.add(new Card(ECardType.UN));
        listCards.add(new Card(ECardType.DEUX));
        listCards.add(new Card(ECardType.DEUX));
        listCards.add(new Card(ECardType.TROIS));
        listCards.add(new Card(ECardType.TROIS));
        listCards.add(new Card(ECardType.QUATRE));
        listCards.add(new Card(ECardType.QUATRE));
        listCards.add(new Card(ECardType.CINQ));
        listCards.add(new Card(ECardType.CINQ));
        listCards.add(new Card(ECardType.SIX));
        listCards.add(new Card(ECardType.SIX));

        Collections.shuffle(listCards);

        int idCoordinate = 0;
        for (Card card : listCards) {
            card.setCoordinates(new Coordinates(idCoordinate % tailleX , idCoordinate / tailleX));
        }

        logger.info("nouveau plateau créé : " + listCards);

    }

    public Card getCardFromCoordinates(Coordinates coordinates){
        for (Card card : listCards) {
            if(card.getCoordinates().equals(coordinates)){
                return card;
            }
        }
        logger.warning("aucune carte a cet emplacement");
        return null;
    }


    

    /* public Plateau(int taille) {
        int tailleX = minDivisorSqrt(taille);
        int tailleY = taille / tailleX;
    }

    

    public void generateListCards(int taille) throws Exception {
        if(taille % 2 != 0){
            throw(new Exception("taille du paquet invalide"));
        }
        
        List<Card> listCards = new ArrayList<Card>();

        List<Card> orginisedListCards = new ArrayList<Card>();



        




    }

    
    retourne le diviseur le plus proche de la racine carrée de x (inférieur a la racine)
    
    public int minDivisorSqrt(int x){
        Double dX = Double.valueOf(x);
        Double dRacineX = Math.sqrt(dX);
        int racineX = dRacineX.intValue();
        int iterator = racineX;
        while(x % iterator != 0 ){
            iterator = iterator - 1;
        }
        return iterator;
    } */



}
