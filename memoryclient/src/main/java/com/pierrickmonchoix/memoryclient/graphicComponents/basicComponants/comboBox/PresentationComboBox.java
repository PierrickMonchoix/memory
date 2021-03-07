package com.pierrickmonchoix.memoryclient.graphicComponents.basicComponants.comboBox;

import java.util.ArrayList;
import java.util.List;

import com.pierrickmonchoix.memoryclient.graphicComponents.superclasses.Presentation;

public class PresentationComboBox extends Presentation{

    private List<String> listProposals = new ArrayList<String>();

    public void addUpProposal(String proposal){
        listProposals.add(proposal);
        updateVue();
    }


    public List<String> getListProposals() {
        return this.listProposals;
    }



    public String getChoice(){
        VueComboBox vueComboBox = (VueComboBox)vue;
        return vueComboBox.getChoice();
    }

    
}
