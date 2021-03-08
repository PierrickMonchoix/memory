package com.pierrickmonchoix.memoryclient.graphicComponents.elaborateComponants.howManyPlayers;

import com.pierrickmonchoix.memoryclient.graphicComponents.basicComponants.comboBox.PresentationComboBox;
import com.pierrickmonchoix.memoryclient.graphicComponents.basicComponants.comboBox.VueComboBox;
import com.pierrickmonchoix.memoryclient.graphicComponents.superclasses.Presentation;

public class PresentationHowManyPlayers extends Presentation {

    private final PresentationComboBox presentationComboBox;


    public PresentationHowManyPlayers() {
        presentationComboBox = new PresentationComboBox();
        VueComboBox vueComboBox = new VueComboBox(presentationComboBox);
        presentationComboBox.setVue(vueComboBox);

        presentationComboBox.addUpProposal("2");
        presentationComboBox.addUpProposal("3");
        presentationComboBox.addUpProposal("4");
        
    }


    public PresentationComboBox getPresentationComboBox() {
        return this.presentationComboBox;
    }

    public String getChoice(){
        return presentationComboBox.getChoice();
    }


 
    
}
