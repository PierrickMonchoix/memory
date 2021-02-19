package com.pierrickmonchoix.memoryclient.graphicComponents.elaborateComponants.buttonCreateGame;

import java.util.logging.Logger;

import com.pierrickmonchoix.memoryclient.graphicComponents.basicComponants.button.PresentationButton;
import com.pierrickmonchoix.memoryclient.graphicComponents.basicComponants.button.VueButton;
import com.pierrickmonchoix.memoryclient.graphicComponents.superclasses.EChildEvent;
import com.pierrickmonchoix.memoryclient.graphicComponents.superclasses.IChildenListener;
import com.pierrickmonchoix.memoryclient.graphicComponents.superclasses.PresentationNotifier;

public class PresentationButtonCreateGame extends PresentationNotifier implements IChildenListener {

    private static Logger logger = Logger.getLogger(PresentationButtonCreateGame.class.getName());

    private final PresentationButton presentationButton;

    public PresentationButtonCreateGame() {
        super(EChildEvent.ASK_FOR_CREATE_GAME);

        presentationButton = new PresentationButton("creer");
        VueButton vueButton = new VueButton(presentationButton);
        presentationButton.setVue(vueButton);

        listenAllChildren();
    }

    // OVERIDES

    @Override
    public void listenAllChildren() {
        presentationButton.attributeParentListener(this);
    }

    @Override
    public void whenNotifiedByChild(EChildEvent typeEvent) {
        if (typeEvent == EChildEvent.BUTTON_PRESSED) {
            notifyParent();
        }
        else{
            logger.info("mon/mes enfants ne m'on pas bien notifiés");
        }
    }

    // GETTERS des presentations for vue

    public PresentationButton getPresentationButton() {
        return presentationButton;
    }

    // GETTER SETTER from childrens

    public void setEnable(boolean enable) {
        presentationButton.setUpEnable(enable);
    }

}
