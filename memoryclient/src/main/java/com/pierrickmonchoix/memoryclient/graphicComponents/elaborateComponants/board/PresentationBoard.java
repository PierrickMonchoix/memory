package com.pierrickmonchoix.memoryclient.graphicComponents.elaborateComponants.board;

import java.util.ArrayList;
import java.util.List;

import com.pierrickmonchoix.memoryclient.graphicComponents.elaborateComponants.card.ModelCard;
import com.pierrickmonchoix.memoryclient.graphicComponents.elaborateComponants.card.PresentationCard;
import com.pierrickmonchoix.memoryclient.graphicComponents.elaborateComponants.card.VueCard;
import com.pierrickmonchoix.memoryclient.graphicComponents.forJson.CardForJson;
import com.pierrickmonchoix.memoryclient.graphicComponents.forJson.ECardType;
import com.pierrickmonchoix.memoryclient.graphicComponents.forJson.GameForJson;
import com.pierrickmonchoix.memoryclient.graphicComponents.superclasses.Presentation;

public class PresentationBoard extends Presentation {

    private final List<PresentationCard> listPresentationCards;

    public PresentationBoard() {

        listPresentationCards = new ArrayList<PresentationCard>();
    }



    public void setUpAll(GameForJson gameForJson){
        listPresentationCards.clear();

        List<CardForJson> listCardForJsons = gameForJson.board.listCards;
        for (CardForJson cardForJson : listCardForJsons) {
            String pathCard = ECardType.toImagePath(cardForJson.typeCarte);
            int xCoord = cardForJson.coordinates.x;
            int yCoord = cardForJson.coordinates.y;
            boolean revealed = cardForJson.revealed;

            PresentationCard presentationCard = new PresentationCard(pathCard, xCoord, yCoord , revealed);
            VueCard vueCard = new VueCard(presentationCard);
            presentationCard.setVue(vueCard);



            listPresentationCards.add(presentationCard);

            new ModelCard(presentationCard);


        }

        updateVue();  // create delete et placement
    }

    public List<PresentationCard> getListPresentationCards() {
        return this.listPresentationCards;
    }



/*     public void addCardsListener(IChildenListener listener){
        for (PresentationCard presentationCard : listPresentationCards) {
            addCardsListener(listener);
        }
    } */


}
