package com.pierrickmonchoix.memoryclient.graphicComponents.elaborateComponants.labelHeroPseudo;

public class ModelLabelHeroPseudo {

    private PresentationLabelHeroPseudo presentationAffichagePseudo;

    public ModelLabelHeroPseudo(PresentationLabelHeroPseudo presentationAffichagePseudo) {
        this.presentationAffichagePseudo = presentationAffichagePseudo;
    }

    public void setPseudoLabelOfHero(String pseudoHero){
        presentationAffichagePseudo.setText(pseudoHero);
    }



    
}
