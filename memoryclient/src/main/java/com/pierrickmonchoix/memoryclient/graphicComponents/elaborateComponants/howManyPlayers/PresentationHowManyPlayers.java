package com.pierrickmonchoix.memoryclient.graphicComponents.elaborateComponants.howManyPlayers;

import com.pierrickmonchoix.memoryclient.graphicComponents.basicComponants.comboBox.PresentationComboBox;
import com.pierrickmonchoix.memoryclient.graphicComponents.basicComponants.comboBox.VueComboBox;
import com.pierrickmonchoix.memoryclient.graphicComponents.superclasses.Presentation;

/**
 * Combobox caractérisant le nombre de joueurs max que l'on veut 
 * dans la partie que l'on va créer
 * 
 * Architecture:
 * rootListGames > createGame > howManyPlayers
 */
public class PresentationHowManyPlayers extends Presentation {

    private final PresentationComboBox presentationComboBox;


    public PresentationHowManyPlayers() {
        presentationComboBox = new PresentationComboBox();
        VueComboBox vueComboBox = new VueComboBox(presentationComboBox);
        presentationComboBox.setVue(vueComboBox);

        presentationComboBox.addUpProposal("2");
        presentationComboBox.addUpProposal("3");
        presentationComboBox.addUpProposal("4");
        presentationComboBox.addUpProposal("5");
        presentationComboBox.addUpProposal("6");
        presentationComboBox.addUpProposal("7");
        presentationComboBox.addUpProposal("8");
        
    }


    public PresentationComboBox getPresentationComboBox() {
        return this.presentationComboBox;
    }

    public String getChoice(){
        return presentationComboBox.getChoice();
    }


 
    
}
