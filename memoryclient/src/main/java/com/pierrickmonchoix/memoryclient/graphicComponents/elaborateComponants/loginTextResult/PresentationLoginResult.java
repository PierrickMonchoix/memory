package com.pierrickmonchoix.memoryclient.graphicComponents.elaborateComponants.loginTextResult;

import com.pierrickmonchoix.memoryclient.graphicComponents.Presentation;
import com.pierrickmonchoix.memoryclient.graphicComponents.basicComponants.textOutput.PresentationTextOutput;

public class PresentationLoginResult extends Presentation{

    private final PresentationTextOutput presentationTextOutput;

    public PresentationLoginResult(String text) {

        presentationTextOutput = new PresentationTextOutput(text);
        

    }

    public PresentationTextOutput getPresentationTextOutput() {
        return presentationTextOutput;
    }

    public void setText(String text){
        presentationTextOutput.setText(text);
    }




  

    

    

}
