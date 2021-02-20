package com.pierrickmonchoix.memoryclient.graphicComponents.rootComponants.rootWinner;

import com.pierrickmonchoix.memoryclient.graphicComponents.elaborateComponants.winner.PresentationWinner;
import com.pierrickmonchoix.memoryclient.graphicComponents.elaborateComponants.winner.VueWinner;
import com.pierrickmonchoix.memoryclient.graphicComponents.superclasses.Presentation;

public class PresentationRootWinner extends Presentation {

    private PresentationWinner presentationWinner;



    public PresentationRootWinner() {
        presentationWinner = new PresentationWinner();
        VueWinner vueWinner = new VueWinner(presentationWinner);
        presentationWinner.setVue(vueWinner);
    }


    public PresentationWinner getPresentationWinner() {
        return this.presentationWinner;
    }



    
}
