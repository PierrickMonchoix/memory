package com.pierrickmonchoix.memoryclient.graphicComponents.elaborateComponants.buttonCreateGame;

import com.pierrickmonchoix.memoryclient.graphicComponents.Presentation;
import com.pierrickmonchoix.memoryclient.graphicComponents.basicComponants.IComponantListener;
import com.pierrickmonchoix.memoryclient.graphicComponents.basicComponants.button.PresentationButton;

public class PresentationButtonCreateGame extends Presentation {

    private final PresentationButton presentationButton;


    public PresentationButtonCreateGame() {
        presentationButton = new PresentationButton("GO!");
    }

    public PresentationButton getPresentationButton() {
        return presentationButton;
    }

    public void addButtonListener(IComponantListener listener){
        presentationButton.addListener(listener);
    }

}
