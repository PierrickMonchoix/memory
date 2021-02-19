package com.pierrickmonchoix.memoryclient.graphicComponents.rootComponants.rootListGames;

import java.util.logging.Logger;

import com.pierrickmonchoix.memoryclient.graphicComponents.Presentation;
import com.pierrickmonchoix.memoryclient.graphicComponents.elaborateComponants.buttonCreateGame.PresentationButtonCreateGame;
import com.pierrickmonchoix.memoryclient.graphicComponents.elaborateComponants.labelHeroPseudo.PresentationLabelHeroPseudo;
import com.pierrickmonchoix.memoryclient.graphicComponents.elaborateComponants.listGamesProposals.PresentationGamesProposals;



public class PresentationRootListGames extends Presentation{

    private static Logger logger = Logger.getLogger(PresentationRootListGames.class.getName());

    private final PresentationLabelHeroPseudo presentationLabelHeroPseudo;
    private final PresentationGamesProposals presentationGamesProposals;
    private final PresentationButtonCreateGame presentationButtonCreateGame;

    public PresentationRootListGames() {

        presentationLabelHeroPseudo = new PresentationLabelHeroPseudo();
        presentationGamesProposals = new PresentationGamesProposals();
        presentationButtonCreateGame = new PresentationButtonCreateGame();


    }

    public PresentationLabelHeroPseudo getPresentationLabelHeroPseudo() {
        return presentationLabelHeroPseudo;
    }


    public PresentationGamesProposals getPresentationGamesProposals() {
        return presentationGamesProposals;
    }


    public PresentationButtonCreateGame getPresentationButtonCreateGame() {
        return presentationButtonCreateGame;
    }



 

    





    
    
}
