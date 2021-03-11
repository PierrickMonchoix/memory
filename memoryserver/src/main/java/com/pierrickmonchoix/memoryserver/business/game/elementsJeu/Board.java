package com.pierrickmonchoix.memoryserver.business.game.elementsJeu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

import com.pierrickmonchoix.memoryserver.business.game.elementsJeu.carte.Card;
import com.pierrickmonchoix.memoryserver.business.game.elementsJeu.carte.Coordinates;
import com.pierrickmonchoix.memoryserver.business.game.elementsJeu.carte.ECardType;

/**
 * Plateau de cartes
 */
public class Board {
    private static Logger logger = Logger.getLogger(Board.class.getName());

    private List<Card> listCards;
    private int tailleX = 4;
    //private int tailleY = 3; //useless


    //CONSTRUCTOR
    public Board() {
        listCards = new ArrayList<Card>();
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
            idCoordinate ++;
        }
        logger.info("nouveau plateau créé : " + listCards);
    }


    //PUBLIC DROW CARD
    public Card drawCardOfCoordinates(Coordinates coordinates){
        Card cardToDraw = getCardFromCoordinates(coordinates);
        cardToDraw.setRevealed(true);
        logger.info("une carte a étée révélée : " + cardToDraw.getCoordinates());
        return cardToDraw;
    }
    private Card getCardFromCoordinates(Coordinates coordinates){
        for (Card card : listCards) {
            if(card.getCoordinates().equals(coordinates)){
                return card;
            }
        }
        logger.warning("aucune carte a cet emplacement");
        return null;
    }

    //PUBLIC IS EMPTY
    public boolean isEmpty(){
        return listCards.isEmpty();
    }

    //PUBLIC REMOVE REVEALED CARDS
    public void removeRevealedCards(){
        listCards.removeIf( c -> ( c.isRevealed() ));
    }

    //PUBLIC RETURN REVEALED CARDS
    public void returnRevealedCards(){
        for (Card card : listCards) {
            card.setRevealed(false);
        }
    }

    // POUR LE GSON
    public List<Card> getListCards() {
        return this.listCards;
    }

    public void setListCards(List<Card> listCards) {
        this.listCards = listCards;
    }

    public int getTailleX() {
        return this.tailleX;
    }

    public void setTailleX(int tailleX) {
        this.tailleX = tailleX;
    }


}
