package com.pierrickmonchoix.memoryclient.graphicComponents.rootComponants.rootGame;

import com.pierrickmonchoix.memoryclient.graphicComponents.elaborateComponants.board.PresentationBoard;
import com.pierrickmonchoix.memoryclient.graphicComponents.elaborateComponants.board.VueBoard;
import com.pierrickmonchoix.memoryclient.graphicComponents.superclasses.Presentation;

public class PresentationRootGame extends Presentation {

    private final PresentationBoard presentationBoard;


    public PresentationRootGame() {
        presentationBoard = new PresentationBoard();
        VueBoard vueBoard = new VueBoard(presentationBoard);
        presentationBoard.setVue(vueBoard);
    }


    public PresentationBoard getPresentationBoard() {
        return this.presentationBoard;
    }


    
    
}
