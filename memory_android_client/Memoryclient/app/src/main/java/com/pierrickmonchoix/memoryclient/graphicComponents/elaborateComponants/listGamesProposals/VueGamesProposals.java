package com.pierrickmonchoix.memoryclient.graphicComponents.elaborateComponants.listGamesProposals;

import android.widget.LinearLayout;

import java.util.List;
import java.util.logging.Logger;

import com.pierrickmonchoix.memoryclient.ContextHelper;
import com.pierrickmonchoix.memoryclient.graphicComponents.elaborateComponants.gameProposal.PresentationGameProposal;
import com.pierrickmonchoix.memoryclient.graphicComponents.elaborateComponants.gameProposal.VueGameProposal;
import com.pierrickmonchoix.memoryclient.graphicComponents.superclasses.IVue;


public class VueGamesProposals extends LinearLayout implements IVue {

    private static Logger logger = Logger.getLogger(VueGamesProposals.class.getName());

    private final PresentationGamesProposals presentationGamesProposals;

    public VueGamesProposals(PresentationGamesProposals presentationGamesProposals) {
        super(ContextHelper.getContext());
        logger.info("creation");


        this.presentationGamesProposals = presentationGamesProposals;

        setOrientation(VERTICAL);

        updateFromPresentation();

    }

    @Override
    public void updateFromPresentation() {
        rebuildVues();   // on doit remetre a joue les vues créées/deleted
    }

    private void rebuildVues(){
        removeAllViews();
        List<PresentationGameProposal> listPresentationGameProposal = presentationGamesProposals
                .getListPresentationsGameProposal();

        for (PresentationGameProposal presentationGameProposal : listPresentationGameProposal) {
            VueGameProposal vueGameProposal = (VueGameProposal) presentationGameProposal.getVue();
            addView(vueGameProposal);
        }
    }

}

// DELEED TO REPLACE:
/*
 * VueGameProposal vueGameProposal = new
 * VueGameProposal(presentationGameProposal); logger.info("vueGameProposal : " +
 * vueGameProposal); presentationGameProposal.setVue(vueGameProposal); //update
 * auto a la construction getChildren().addAll(vueGameProposal);
 */