package com.pierrickmonchoix.memoryclient.graphicComponents.elaborateComponants.listGamesProposals;

import java.util.ArrayList;
import java.util.List;

import com.pierrickmonchoix.memoryclient.graphicComponents.IVue;
import com.pierrickmonchoix.memoryclient.graphicComponents.elaborateComponants.gameProposal.PresentationGameProposal;
import com.pierrickmonchoix.memoryclient.graphicComponents.elaborateComponants.gameProposal.VueGameProposal;

import javafx.scene.layout.VBox;

public class VueGamesProposals extends VBox implements IVue {

    private final List<VueGameProposal> listVuesGameProposal;

    public VueGamesProposals(PresentationGamesProposals presentationGamesProposals){
        super(10);
        
        listVuesGameProposal = new ArrayList<VueGameProposal>();
        
        for (PresentationGameProposal presentationGameProposal : presentationGamesProposals.getListPresentationsGameProposal()) {
            VueGameProposal vueGameProposal = new VueGameProposal(presentationGameProposal);
            presentationGameProposal.setVue(vueGameProposal);
        
            getChildren().addAll(vueGameProposal);

        }
        update();

    }


    @Override
    public void update() {
        for (VueGameProposal vueGameProposal : listVuesGameProposal) {
            vueGameProposal.update();
        }

    }


    
}
