package com.pierrickmonchoix.memoryclient.graphicComponents.elaborateComponants.listGamesProposals;

import java.util.List;
import java.util.logging.Logger;

import com.pierrickmonchoix.memoryclient.graphicComponents.IVue;
import com.pierrickmonchoix.memoryclient.graphicComponents.elaborateComponants.gameProposal.PresentationGameProposal;
import com.pierrickmonchoix.memoryclient.graphicComponents.elaborateComponants.gameProposal.VueGameProposal;

import javafx.scene.layout.VBox;

public class VueGamesProposals extends VBox implements IVue {

    private static Logger logger = Logger.getLogger(VueGamesProposals.class.getName());


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
        getChildren().clear();
        List<PresentationGameProposal> listPresentationGameProposal = presentationGamesProposals.getListPresentationsGameProposal();
        
        for (PresentationGameProposal presentationGameProposal : listPresentationGameProposal) {
            VueGameProposal vueGameProposal = new VueGameProposal(presentationGameProposal);
            logger.info("vueGameProposal : " + vueGameProposal);
            presentationGameProposal.setVue(vueGameProposal);  //update auto a la construction
            getChildren().addAll(vueGameProposal);

        }

    }


    
}
