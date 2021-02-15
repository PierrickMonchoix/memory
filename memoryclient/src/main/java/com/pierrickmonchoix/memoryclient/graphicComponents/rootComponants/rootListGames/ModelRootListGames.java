package com.pierrickmonchoix.memoryclient.graphicComponents.rootComponants.rootListGames;

import com.pierrickmonchoix.memoryclient.graphicComponents.elaborateComponants.labelHeroPseudo.ModelLabelHeroPseudo;

public class ModelRootListGames {

    private ModelLabelHeroPseudo modelLabelHeroPseudo;

    public ModelRootListGames(PresentationRootListGames presentationRootListGames) {
        
        modelLabelHeroPseudo = new ModelLabelHeroPseudo(presentationRootListGames.getPresentationLabelHeroPseudo());

    }

    public void setPseudoLabelOfHero(String pseudoHero){
        modelLabelHeroPseudo.setPseudoLabelOfHero(pseudoHero);
    }

    
    
}
