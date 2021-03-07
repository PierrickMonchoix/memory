package com.pierrickmonchoix.memoryclient.graphicComponents.basicComponants.comboBox;

import java.util.List;

import com.pierrickmonchoix.memoryclient.graphicComponents.superclasses.IVue;

import javafx.scene.control.ComboBox;

public class VueComboBox extends ComboBox<String> implements IVue{

    private final PresentationComboBox presentationComboBox; 


    public VueComboBox(PresentationComboBox presentationComboBox) {
        super();
        this.presentationComboBox = presentationComboBox;

        updateFromPresentation();
    }



    @Override
    public void updateFromPresentation() {
        this.getItems().clear();

        List<String> listProposal = presentationComboBox.getListProposals();

        for (String proposal : listProposal) {
            this.getItems().add(proposal);
        }

        if(listProposal.size() >= 1){
            setValue(listProposal.get(0));
        }
        
        
    }

    public String getChoice(){
        return this.getValue();
    }


    
}
