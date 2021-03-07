package com.pierrickmonchoix.memoryclient.graphicComponents.elaborateComponants.loginTextResult;

import android.content.Context;
import android.widget.LinearLayout;

import com.pierrickmonchoix.memoryclient.ContextHelper;
import com.pierrickmonchoix.memoryclient.graphicComponents.basicComponants.textOutput.VueTextOutput;
import com.pierrickmonchoix.memoryclient.graphicComponents.superclasses.IVue;


public class VueLoginResult extends LinearLayout implements IVue {

    private final VueTextOutput vueTextOutput;

    public VueLoginResult(PresentationLoginResult presentationLoginTextResult) {
        super(ContextHelper.getContext());

        vueTextOutput = (VueTextOutput)presentationLoginTextResult.getPresentationTextOutput().getVue();

        addView(vueTextOutput);

        updateFromPresentation();
    }

    @Override
    public void updateFromPresentation() {
        // nothing to MOVE
    }

    
    
}
