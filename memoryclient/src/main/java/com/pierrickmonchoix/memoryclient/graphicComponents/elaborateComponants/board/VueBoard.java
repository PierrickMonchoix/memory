package com.pierrickmonchoix.memoryclient.graphicComponents.elaborateComponants.board;

import java.util.List;
import java.util.logging.Logger;

import com.pierrickmonchoix.memoryclient.graphicComponents.elaborateComponants.card.PresentationCard;
import com.pierrickmonchoix.memoryclient.graphicComponents.elaborateComponants.card.VueCard;
import com.pierrickmonchoix.memoryclient.graphicComponents.superclasses.IVue;

import javafx.scene.layout.GridPane;



public class VueBoard extends GridPane implements IVue {

    private static Logger logger = Logger.getLogger(VueBoard.class.getName());

    private final PresentationBoard presentationBoard;

    public VueBoard(PresentationBoard presentationBoard) {
        super();
        this.presentationBoard = presentationBoard;

        setHgap(10);
        setVgap(10);

        updateFromPresentation();
    }

    @Override
    public void updateFromPresentation() {
        rebuildVues();
    }

    public void rebuildVues(){
        getChildren().clear();

        List<PresentationCard> listPresentationCards = presentationBoard.getListPresentationCards();

        for (PresentationCard presentationCard : listPresentationCards) {
            VueCard vueCard = (VueCard) presentationCard.getVue();
            
            int x = presentationCard.getX();
            int y = presentationCard.getY();
            // on ne met pas reavlead ni pathCard car ne concernet pas palcement / delete /create

            logger.info("ajout image coord : " + x +" , "+ y);
            

            add(vueCard, x, y);  // x = column , y = row
        }
    }

}
