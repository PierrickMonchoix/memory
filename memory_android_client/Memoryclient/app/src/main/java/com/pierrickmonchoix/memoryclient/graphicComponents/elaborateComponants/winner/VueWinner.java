package com.pierrickmonchoix.memoryclient.graphicComponents.elaborateComponants.winner;

import android.widget.LinearLayout;

import com.pierrickmonchoix.memoryclient.ContextHelper;
import com.pierrickmonchoix.memoryclient.graphicComponents.basicComponants.textOutput.VueTextOutput;
import com.pierrickmonchoix.memoryclient.graphicComponents.superclasses.IVue;


public class VueWinner extends LinearLayout implements IVue {

    private final VueTextOutput vueTextOutput;

    public VueWinner(PresentationWinner presentationWinner) {
        super(ContextHelper.getContext());

        vueTextOutput = (VueTextOutput) presentationWinner.getPresentationTextOutput().getVue();

        addView(vueTextOutput);
        updateFromPresentation();
    }

    @Override
    public void updateFromPresentation() {
        // nothing to MOVE
    }
}