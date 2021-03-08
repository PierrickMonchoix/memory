package com.pierrickmonchoix.memoryclient.graphicComponents.rootComponants.rootGame;

import android.widget.LinearLayout;

import com.pierrickmonchoix.memoryclient.ContextHelper;
import com.pierrickmonchoix.memoryclient.graphicComponents.elaborateComponants.board.VueBoard;
import com.pierrickmonchoix.memoryclient.graphicComponents.superclasses.IVue;


public class VueRootGame  extends LinearLayout implements IVue {

    private final VueBoard vueBoard;

    public VueRootGame(PresentationRootGame presentationRootGame) {
        super(ContextHelper.getContext());

        vueBoard = (VueBoard) presentationRootGame.getPresentationBoard().getVue();

        addView(vueBoard);

        updateFromPresentation();

    }

    @Override
    public void updateFromPresentation() {
        // TODO Auto-generated method stub

    }




    

    
}
