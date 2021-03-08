package com.pierrickmonchoix.memoryclient.graphicComponents.elaborateComponants.buttonCreateGame;

import android.widget.LinearLayout;

import java.util.logging.Logger;

import com.pierrickmonchoix.memoryclient.ContextHelper;
import com.pierrickmonchoix.memoryclient.graphicComponents.basicComponants.button.VueButton;
import com.pierrickmonchoix.memoryclient.graphicComponents.superclasses.IVue;


public class VueButtonCreateGame extends LinearLayout implements IVue {

    private static Logger logger = Logger.getLogger(VueButtonCreateGame.class.getName());

    private final VueButton vueButton;


    public VueButtonCreateGame(PresentationButtonCreateGame presentationButtonCreateGame) {
        super(ContextHelper.getContext());
        vueButton = (VueButton) presentationButtonCreateGame.getPresentationButton().getVue();
        logger.info("creation");

        addView(vueButton);

        updateFromPresentation();
    }

    @Override
    public void updateFromPresentation() {
        // notinng to move or create/delete
    }


}