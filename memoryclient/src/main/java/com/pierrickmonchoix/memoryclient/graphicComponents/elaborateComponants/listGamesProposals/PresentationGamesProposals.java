package com.pierrickmonchoix.memoryclient.graphicComponents.elaborateComponants.listGamesProposals;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import com.pierrickmonchoix.memoryclient.graphicComponents.Presentation;
import com.pierrickmonchoix.memoryclient.graphicComponents.elaborateComponants.gameProposal.PresentationGameProposal;
import com.pierrickmonchoix.memoryclient.graphicComponents.forJson.GameManagerForJson;
import com.pierrickmonchoix.memoryclient.graphicComponents.forJson.ShownGameForJson;

public class PresentationGamesProposals extends Presentation {

    private static Logger logger = Logger.getLogger(PresentationGamesProposals.class.getName());
    private final List<PresentationGameProposal> listPresentationsGameProposal;

    public PresentationGamesProposals() {

        listPresentationsGameProposal = new ArrayList<PresentationGameProposal>();

    }

    public PresentationGameProposal getPresentationGameProposalWithPseudo(String pseudo) {
        for (PresentationGameProposal presentationGameProposal : listPresentationsGameProposal) {
            if (presentationGameProposal.getPseudo().equals(pseudo)) {
                return presentationGameProposal;
            }
        }
        logger.warning("aucune game avec ce pseudo trouvée ...");
        return null;
    }

/*     public void addGameOfPseudo(String pseudo) {
        PresentationGameProposal presentationGameProposal = new PresentationGameProposal(pseudo , "1/?");
        listPresentationsGameProposal.add(presentationGameProposal);
        // updateVue();
    } */



    public List<PresentationGameProposal> getListPresentationsGameProposal() {
        return listPresentationsGameProposal;
    }

}
