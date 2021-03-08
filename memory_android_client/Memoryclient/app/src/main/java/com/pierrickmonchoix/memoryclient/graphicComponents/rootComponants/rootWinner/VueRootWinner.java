package com.pierrickmonchoix.memoryclient.graphicComponents.rootComponants.rootWinner;

import android.widget.LinearLayout;

import com.pierrickmonchoix.memoryclient.ContextHelper;
import com.pierrickmonchoix.memoryclient.graphicComponents.elaborateComponants.winner.VueWinner;
import com.pierrickmonchoix.memoryclient.graphicComponents.superclasses.IVue;

public class VueRootWinner extends LinearLayout implements IVue {

    private VueWinner vueWinner;


    public VueRootWinner(PresentationRootWinner presentationRootWinner) {
        super(ContextHelper.getContext());

        vueWinner = (VueWinner) presentationRootWinner.getPresentationWinner().getVue();

        addView(vueWinner);

        updateFromPresentation();
    }


    @Override
    public void updateFromPresentation() {
        // TODO Auto-generated method stub

    }


}
