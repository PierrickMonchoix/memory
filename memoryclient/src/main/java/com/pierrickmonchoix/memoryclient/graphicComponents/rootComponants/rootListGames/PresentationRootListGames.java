package com.pierrickmonchoix.memoryclient.graphicComponents.rootComponants.rootListGames;

import java.util.logging.Logger;

import com.pierrickmonchoix.memoryclient.graphicComponents.elaborateComponants.buttonCreateGame.PresentationButtonCreateGame;
import com.pierrickmonchoix.memoryclient.graphicComponents.elaborateComponants.buttonCreateGame.VueButtonCreateGame;
import com.pierrickmonchoix.memoryclient.graphicComponents.elaborateComponants.labelHeroPseudo.PresentationLabelHeroPseudo;
import com.pierrickmonchoix.memoryclient.graphicComponents.elaborateComponants.labelHeroPseudo.VueLabelHeroPseudo;
import com.pierrickmonchoix.memoryclient.graphicComponents.elaborateComponants.listGamesProposals.PresentationGamesProposals;
import com.pierrickmonchoix.memoryclient.graphicComponents.elaborateComponants.listGamesProposals.VueGamesProposals;
import com.pierrickmonchoix.memoryclient.graphicComponents.superclasses.Presentation;



public class PresentationRootListGames extends Presentation{

    private static Logger logger = Logger.getLogger(PresentationRootListGames.class.getName());

    private final PresentationLabelHeroPseudo presentationLabelHeroPseudo;
    private final PresentationGamesProposals presentationGamesProposals;
    private final PresentationButtonCreateGame presentationButtonCreateGame;

    public PresentationRootListGames() {
        logger.info("creation");

        presentationLabelHeroPseudo = new PresentationLabelHeroPseudo();
        VueLabelHeroPseudo vueLabelHeroPseudo = new VueLabelHeroPseudo(presentationLabelHeroPseudo);
        presentationLabelHeroPseudo.setVue(vueLabelHeroPseudo);

        presentationGamesProposals = new PresentationGamesProposals();
        VueGamesProposals vueGamesProposals = new VueGamesProposals(presentationGamesProposals);
        presentationGamesProposals.setVue(vueGamesProposals);

        presentationButtonCreateGame = new PresentationButtonCreateGame();
        VueButtonCreateGame vueButtonCreateGame = new VueButtonCreateGame(presentationButtonCreateGame);
        presentationButtonCreateGame.setVue(vueButtonCreateGame);


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
