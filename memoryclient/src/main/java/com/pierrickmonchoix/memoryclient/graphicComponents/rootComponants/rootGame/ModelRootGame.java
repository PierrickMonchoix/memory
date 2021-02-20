package com.pierrickmonchoix.memoryclient.graphicComponents.rootComponants.rootGame;

import com.pierrickmonchoix.memoryclient.graphicComponents.elaborateComponants.board.ModelBoard;

public class ModelRootGame {

    public ModelRootGame(PresentationRootGame presentationRootGame) {

        new ModelBoard(presentationRootGame.getPresentationBoard());

    }


    
    
}
