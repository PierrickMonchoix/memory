package com.pierrickmonchoix.memoryclient.graphicComponents.elaborateComponants.board;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import com.pierrickmonchoix.memoryclient.graphicComponents.elaborateComponants.card.ModelCard;
import com.pierrickmonchoix.memoryclient.graphicComponents.elaborateComponants.card.PresentationCard;
import com.pierrickmonchoix.memoryclient.graphicComponents.elaborateComponants.card.VueCard;
import com.pierrickmonchoix.memoryclient.graphicComponents.forJson.CardForJson;
import com.pierrickmonchoix.memoryclient.graphicComponents.forJson.ECardType;
import com.pierrickmonchoix.memoryclient.graphicComponents.forJson.GameForJson;
import com.pierrickmonchoix.memoryclient.graphicComponents.superclasses.Presentation;

/**
 * Plateau de jeu contenant 12 cartes (soit 6 paires)
 * 
 * Architecture:
 * rootGame > board
 */
public class PresentationBoard extends Presentation {

    private static Logger logger = Logger.getLogger(PresentationBoard.class.getName());

    private final List<PresentationCard> listPresentationCards;

    public PresentationBoard() {

        listPresentationCards = new ArrayList<PresentationCard>();
    }

    public void setUpAll(GameForJson gameForJson) {
        listPresentationCards.clear();

        List<CardForJson> listCardForJsons = gameForJson.board.listCards;
        for (CardForJson cardForJson : listCardForJsons) {
            String pathCard = ECardType.toImagePath(cardForJson.typeCarte);
            int xCoord = cardForJson.coordinates.x;
            int yCoord = cardForJson.coordinates.y;
            boolean revealed = cardForJson.revealed;

            if (revealed) {
                logger.info("ah je ne dois PAS cacher la carte de coord: " + xCoord + " , " + yCoord);
            }
            else{
                logger.info("ah je dois cacher la carte de coord: " + xCoord + " , " + yCoord);
            }

            PresentationCard presentationCard = new PresentationCard(pathCard, xCoord, yCoord, revealed);
            VueCard vueCard = new VueCard(presentationCard);
            presentationCard.setVue(vueCard);

            listPresentationCards.add(presentationCard);

            new ModelCard(presentationCard);

        }

        updateVue(); // create delete et placement
    }

    public List<PresentationCard> getListPresentationCards() {
        return this.listPresentationCards;
    }

}
