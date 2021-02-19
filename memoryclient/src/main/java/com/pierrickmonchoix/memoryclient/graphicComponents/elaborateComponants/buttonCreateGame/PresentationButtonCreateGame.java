package com.pierrickmonchoix.memoryclient.graphicComponents.elaborateComponants.buttonCreateGame;

import java.util.logging.Logger;

import com.pierrickmonchoix.memoryclient.graphicComponents.Presentation;
import com.pierrickmonchoix.memoryclient.graphicComponents.basicComponants.IComponantListener;
import com.pierrickmonchoix.memoryclient.graphicComponents.basicComponants.button.PresentationButton;

public class PresentationButtonCreateGame extends Presentation {

    private static Logger logger = Logger.getLogger(PresentationButtonCreateGame.class.getName());

    private final PresentationButton presentationButton;


    public PresentationButtonCreateGame() {
        presentationButton = new PresentationButton("creer");
    }

    public PresentationButton getPresentationButton() {
        return presentationButton;
    }

    public void addButtonListener(IComponantListener listener){
        presentationButton.addListener(listener);
    }


    public void setEnable(boolean enable){
        logger.info(" vue button : " + presentationButton.getVue());  // PAS NULL
        presentationButton.setEnable(enable);
    }

}
