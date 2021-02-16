package com.pierrickmonchoix.memoryclient.graphicComponents.elaborateComponants.listGamesProposals;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import com.pierrickmonchoix.memoryclient.graphicComponents.Presentation;
import com.pierrickmonchoix.memoryclient.graphicComponents.elaborateComponants.gameProposal.PresentationGameProposal;



public class PresentationGamesProposals extends Presentation{
    
    private static Logger logger = Logger.getLogger(PresentationGamesProposals.class.getName());
    private final List<PresentationGameProposal> listPresentationsGameProposal;

    public PresentationGamesProposals(){

        listPresentationsGameProposal = new ArrayList<PresentationGameProposal>();
        
        listPresentationsGameProposal.add(new PresentationGameProposal("jack"));
        listPresentationsGameProposal.add(new PresentationGameProposal("queen"));
        listPresentationsGameProposal.add(new PresentationGameProposal("king"));

    }

    public List<PresentationGameProposal> getListPresentationsGameProposal() {
        return listPresentationsGameProposal;
    }

    


}
