package com.pierrickmonchoix.memoryclient.graphicComponents.elaborateComponants.listGamesProposals;

import com.pierrickmonchoix.memoryclient.graphicComponents.IVue;
import com.pierrickmonchoix.memoryclient.graphicComponents.elaborateComponants.gameProposal.PresentationGameProposal;
import com.pierrickmonchoix.memoryclient.graphicComponents.elaborateComponants.gameProposal.VueGameProposal;

import javafx.scene.layout.VBox;

public class VueGamesProposals extends VBox implements IVue {


    private final PresentationGamesProposals presentationGamesProposals;

    public VueGamesProposals(PresentationGamesProposals presentationGamesProposals){
        super(10);
        this.presentationGamesProposals = presentationGamesProposals;

        
/*         for (PresentationGameProposal presentationGameProposal : presentationGamesProposals.getListPresentationsGameProposal()) {
            VueGameProposal vueGameProposal = new VueGameProposal(presentationGameProposal);
            presentationGameProposal.setVue(vueGameProposal);
        
            getChildren().addAll(vueGameProposal);

        } */
        update();

    }


    @Override
    public void update() {
        getChildren().removeAll();
        for (PresentationGameProposal presentationGameProposal : presentationGamesProposals.getListPresentationsGameProposal()) {
            VueGameProposal vueGameProposal = new VueGameProposal(presentationGameProposal);
            presentationGameProposal.setVue(vueGameProposal);
        
            getChildren().addAll(vueGameProposal);

        }

    }


    
}
