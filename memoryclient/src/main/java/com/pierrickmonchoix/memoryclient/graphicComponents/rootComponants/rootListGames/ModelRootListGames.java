package com.pierrickmonchoix.memoryclient.graphicComponents.rootComponants.rootListGames;

import java.util.logging.Logger;

import com.pierrickmonchoix.memoryclient.graphicComponents.elaborateComponants.buttonCreateGame.ModeleButtonCreateGame;
import com.pierrickmonchoix.memoryclient.graphicComponents.elaborateComponants.labelHeroPseudo.ModelLabelHeroPseudo;
import com.pierrickmonchoix.memoryclient.graphicComponents.elaborateComponants.listGamesProposals.ModelGamesProposals;

public class ModelRootListGames {

    private ModelLabelHeroPseudo modelLabelHeroPseudo;
    private ModelGamesProposals modelGamesProposals;
    private ModeleButtonCreateGame modeleButtonCreateGame;

    private static Logger logger = Logger.getLogger(ModelRootListGames.class.getName());

    public ModelRootListGames(PresentationRootListGames presentationRootListGames) {

        
        modelLabelHeroPseudo = new ModelLabelHeroPseudo(presentationRootListGames.getPresentationLabelHeroPseudo());
        
        modelGamesProposals = new ModelGamesProposals(presentationRootListGames.getPresentationGamesProposals());

        modeleButtonCreateGame = new ModeleButtonCreateGame(presentationRootListGames.getPresentationButtonCreateGame());
    }

    public void setPseudoLabelOfHero(String pseudoHero){
        modelLabelHeroPseudo.setPseudoLabelOfHero(pseudoHero);
    }

    
    
}
