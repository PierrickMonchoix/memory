package com.pierrickmonchoix.memoryclient.graphicComponents.rootComponants.rootListGames;

import com.pierrickmonchoix.memoryclient.graphicComponents.Presentation;
import com.pierrickmonchoix.memoryclient.graphicComponents.elaborateComponants.labelHeroPseudo.PresentationLabelHeroPseudo;
import com.pierrickmonchoix.memoryclient.graphicComponents.elaborateComponants.listGames.PresentationListGames;

public class PresentationRootListGames extends Presentation{

    private final PresentationLabelHeroPseudo presentationLabelHeroPseudo;

    private final PresentationListGames presentationListGames;

    public PresentationRootListGames() {

        presentationLabelHeroPseudo = new PresentationLabelHeroPseudo();

        presentationListGames = new PresentationListGames();
    }

    public PresentationLabelHeroPseudo getPresentationLabelHeroPseudo() {
        return presentationLabelHeroPseudo;
    }

    public PresentationListGames getPresentationListGames() {
        return presentationListGames;
    }





    
    
}
