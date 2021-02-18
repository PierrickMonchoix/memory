package com.pierrickmonchoix.memoryclient.graphicComponents.elaborateComponants.board;

import java.util.ArrayList;
import java.util.List;

import com.pierrickmonchoix.memoryclient.graphicComponents.Presentation;
import com.pierrickmonchoix.memoryclient.graphicComponents.basicComponants.IComponantListener;
import com.pierrickmonchoix.memoryclient.graphicComponents.elaborateComponants.card.PresentationCard;

public class PresentationBoard extends Presentation {
    
    private final List<PresentationCard>  listPresentationCards;


    public PresentationBoard() {
        listPresentationCards = new ArrayList<PresentationCard>();
        
    }


    public List<PresentationCard> getListPresentationCards() {
        return this.listPresentationCards;
    }

    public void addCardsListener(IComponantListener listener){
        for (PresentationCard presentationCard : listPresentationCards) {
            addCardsListener(listener);
        }
    }


}
