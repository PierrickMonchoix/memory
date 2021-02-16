package com.pierrickmonchoix.memoryclient.graphicComponents.rootComponants.rootListGames;

import com.pierrickmonchoix.memoryclient.graphicComponents.Presentation;
import com.pierrickmonchoix.memoryclient.graphicComponents.elaborateComponants.gameProposal.PresentationGameProposal;
import com.pierrickmonchoix.memoryclient.graphicComponents.elaborateComponants.labelHeroPseudo.PresentationLabelHeroPseudo;
import com.pierrickmonchoix.memoryclient.graphicComponents.elaborateComponants.listGames.PresentationListGames;
import com.pierrickmonchoix.memoryclient.graphicComponents.elaborateComponants.listGamesProposals.PresentationGamesProposals;



public class PresentationRootListGames extends Presentation{

    private final PresentationLabelHeroPseudo presentationLabelHeroPseudo;
    private final PresentationGamesProposals presentationGamesProposals;

    public PresentationRootListGames() {

        presentationLabelHeroPseudo = new PresentationLabelHeroPseudo();
        presentationGamesProposals = new PresentationGamesProposals();

    }

    public PresentationLabelHeroPseudo getPresentationLabelHeroPseudo() {
        return presentationLabelHeroPseudo;
    }


    public PresentationGamesProposals getPresentationGamesProposals() {
        return presentationGamesProposals;
    }

 

    





    
    
}
