package com.pierrickmonchoix.memoryclient.graphicComponents.elaborateComponants.loginTextResult;

import com.pierrickmonchoix.memoryclient.graphicComponents.basicComponants.textOutput.PresentationTextOutput;
import com.pierrickmonchoix.memoryclient.graphicComponents.basicComponants.textOutput.VueTextOutput;
import com.pierrickmonchoix.memoryclient.graphicComponents.superclasses.Presentation;

/**
 * Affiche les causes des erreurs de connexion
  * 
 * Architecture:
 * rootLogin > loginTextResult
 */
public class PresentationLoginResult extends Presentation{

    private final PresentationTextOutput presentationTextOutput;

    public PresentationLoginResult(String text) {

        presentationTextOutput = new PresentationTextOutput(text);
        VueTextOutput vueTextOutput = new VueTextOutput(presentationTextOutput);
        presentationTextOutput.setVue(vueTextOutput);
    }

    public PresentationTextOutput getPresentationTextOutput() {
        return presentationTextOutput;
    }

    public void setText(String text){
        presentationTextOutput.setUpText(text);
    }




  

    

    

}
