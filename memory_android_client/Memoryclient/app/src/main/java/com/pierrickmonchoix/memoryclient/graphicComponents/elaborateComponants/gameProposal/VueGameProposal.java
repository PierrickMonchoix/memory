package com.pierrickmonchoix.memoryclient.graphicComponents.elaborateComponants.gameProposal;

import android.graphics.Color;
import android.provider.CalendarContract;
import android.widget.LinearLayout;

import java.util.logging.Logger;

import com.pierrickmonchoix.memoryclient.ContextHelper;
import com.pierrickmonchoix.memoryclient.graphicComponents.basicComponants.button.VueButton;
import com.pierrickmonchoix.memoryclient.graphicComponents.basicComponants.textOutput.VueTextOutput;
import com.pierrickmonchoix.memoryclient.graphicComponents.superclasses.IVue;


public class VueGameProposal extends LinearLayout implements IVue {

    private final VueTextOutput vueTextOutput;
    private final VueButton vueButton;

    private static Logger logger = Logger.getLogger(VueGameProposal.class.getName());

    public VueGameProposal(PresentationGameProposal presentationGameProposal) {
        super(ContextHelper.getContext());
        logger.info("creation");

        vueTextOutput = (VueTextOutput) presentationGameProposal.getPresentationTextOutput().getVue();
        vueButton = (VueButton) presentationGameProposal.getPresentationButton().getVue();

        addView(vueTextOutput);
        addView(vueButton);


        setOrientation(HORIZONTAL);

        setBackgroundColor(Color.LTGRAY);

        updateFromPresentation();

    }

    @Override
    public void updateFromPresentation() {
        // nothing to move
    }

}
