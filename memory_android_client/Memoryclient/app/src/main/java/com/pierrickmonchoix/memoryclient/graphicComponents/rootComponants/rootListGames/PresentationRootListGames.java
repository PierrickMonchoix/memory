package com.pierrickmonchoix.memoryclient.graphicComponents.rootComponants.rootListGames;

import java.util.logging.Logger;

import com.pierrickmonchoix.memoryclient.graphicComponents.elaborateComponants.createGame.PresentationCreateGame;
import com.pierrickmonchoix.memoryclient.graphicComponents.elaborateComponants.createGame.VueCreateGame;
import com.pierrickmonchoix.memoryclient.graphicComponents.elaborateComponants.labelHeroPseudo.PresentationLabelHeroPseudo;
import com.pierrickmonchoix.memoryclient.graphicComponents.elaborateComponants.labelHeroPseudo.VueLabelHeroPseudo;
import com.pierrickmonchoix.memoryclient.graphicComponents.elaborateComponants.listGamesProposals.PresentationGamesProposals;
import com.pierrickmonchoix.memoryclient.graphicComponents.elaborateComponants.listGamesProposals.VueGamesProposals;
import com.pierrickmonchoix.memoryclient.graphicComponents.superclasses.Presentation;



public class PresentationRootListGames extends Presentation{

    private static Logger logger = Logger.getLogger(PresentationRootListGames.class.getName());

    private final PresentationLabelHeroPseudo presentationLabelHeroPseudo;
    private final PresentationGamesProposals presentationGamesProposals;
    private final PresentationCreateGame presentationCreateGame;

    public PresentationRootListGames() {
        logger.info("creation");

        presentationLabelHeroPseudo = new PresentationLabelHeroPseudo();
        VueLabelHeroPseudo vueLabelHeroPseudo = new VueLabelHeroPseudo(presentationLabelHeroPseudo);
        presentationLabelHeroPseudo.setVue(vueLabelHeroPseudo);

        presentationGamesProposals = new PresentationGamesProposals();
        VueGamesProposals vueGamesProposals = new VueGamesProposals(presentationGamesProposals);
        presentationGamesProposals.setVue(vueGamesProposals);

        presentationCreateGame = new PresentationCreateGame();
        VueCreateGame vueCreateGame = new VueCreateGame(presentationCreateGame);
        presentationCreateGame.setVue(vueCreateGame);


    }

    public PresentationLabelHeroPseudo getPresentationLabelHeroPseudo() {
        return presentationLabelHeroPseudo;
    }


    public PresentationGamesProposals getPresentationGamesProposals() {
        return presentationGamesProposals;
    }


    public PresentationCreateGame getPresentationCreateGame() {
        return presentationCreateGame;
    }



 

    





    
    
}
