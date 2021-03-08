package com.pierrickmonchoix.memoryclient.graphicComponents.elaborateComponants.labelHeroPseudo;

import android.widget.LinearLayout;

import com.pierrickmonchoix.memoryclient.ContextHelper;
import com.pierrickmonchoix.memoryclient.graphicComponents.basicComponants.textOutput.VueTextOutput;
import com.pierrickmonchoix.memoryclient.graphicComponents.superclasses.IVue;


public class VueLabelHeroPseudo extends LinearLayout implements IVue {

    private final VueTextOutput vueTextOutput;

    public VueLabelHeroPseudo(PresentationLabelHeroPseudo presentationLabelHeroPseudo) {
        super(ContextHelper.getContext());

        vueTextOutput = (VueTextOutput) presentationLabelHeroPseudo.getPresentationTextOutput().getVue();

        addView(vueTextOutput);


        updateFromPresentation();
    }

    @Override
    public void updateFromPresentation() {
        // nothing to MOVE
    }
}