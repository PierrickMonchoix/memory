package com.pierrickmonchoix.memoryclient.graphicComponents.rootComponants.rootGame;

import com.pierrickmonchoix.memoryclient.graphicComponents.elaborateComponants.board.VueBoard;
import com.pierrickmonchoix.memoryclient.graphicComponents.superclasses.IVue;

import javafx.scene.layout.VBox;

public class VueRootGame  extends VBox implements IVue {

    private final VueBoard vueBoard;

    public VueRootGame(PresentationRootGame presentationRootGame) {

        vueBoard = (VueBoard) presentationRootGame.getPresentationBoard().getVue();

        getChildren().addAll(vueBoard);

        updateFromPresentation();

    }

    @Override
    public void updateFromPresentation() {
        // TODO Auto-generated method stub

    }




    

    
}
