package com.pierrickmonchoix.memoryclient.graphicComponents.elaborateComponants.board;

import java.util.List;

import com.pierrickmonchoix.memoryclient.graphicComponents.IVue;
import com.pierrickmonchoix.memoryclient.graphicComponents.elaborateComponants.card.PresentationCard;
import com.pierrickmonchoix.memoryclient.graphicComponents.elaborateComponants.card.VueCard;

import javafx.scene.layout.GridPane;

public class VueBoard extends GridPane implements IVue {

    private PresentationBoard presentationBoard;

    public VueBoard(PresentationBoard presentationBoard) {
        super();
        this.presentationBoard = presentationBoard;

        setHgap(10);
        setVgap(10);

        update();
    }

    @Override
    public void update() {
        getChildren().clear();
        List<PresentationCard> listPresentationCards = presentationBoard.getListPresentationCards();

        for (PresentationCard presentationCard : listPresentationCards) {
            VueCard vueCard = new VueCard(presentationCard);
            presentationCard.setVue(vueCard);
            
            int x = presentationCard.getX();
            int y = presentationCard.getY();

            add(vueCard, x, y);  // w = column , y = row
        }
       

    }

}
