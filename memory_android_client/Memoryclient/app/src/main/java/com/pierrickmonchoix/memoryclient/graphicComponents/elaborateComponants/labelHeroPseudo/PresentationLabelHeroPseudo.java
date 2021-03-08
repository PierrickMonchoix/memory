package com.pierrickmonchoix.memoryclient.graphicComponents.elaborateComponants.labelHeroPseudo;

import com.pierrickmonchoix.memoryclient.graphicComponents.basicComponants.textOutput.PresentationTextOutput;
import com.pierrickmonchoix.memoryclient.graphicComponents.basicComponants.textOutput.VueTextOutput;
import com.pierrickmonchoix.memoryclient.graphicComponents.superclasses.Presentation;

public class PresentationLabelHeroPseudo extends Presentation {

    private final PresentationTextOutput presentationTextOutput;

    public PresentationLabelHeroPseudo() {

        presentationTextOutput = new PresentationTextOutput("default false pseudo");
        VueTextOutput vueTextOutput = new VueTextOutput(presentationTextOutput);
        presentationTextOutput.setVue(vueTextOutput);

    }

    public PresentationTextOutput getPresentationTextOutput() {
        return presentationTextOutput;
    }

    public void setText(String text) {  
        presentationTextOutput.setUpText(text);  // utilise upgradeFromPresentation ne bout de chaine (basic compo)
    }
}