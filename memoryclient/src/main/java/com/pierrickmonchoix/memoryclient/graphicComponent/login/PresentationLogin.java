package com.pierrickmonchoix.memoryclient.graphicComponent.login;

import com.pierrickmonchoix.memoryclient.graphicComponent.Presentation;
import com.pierrickmonchoix.memoryclient.graphicComponent.button.PresentationButton;
import com.pierrickmonchoix.memoryclient.graphicComponent.button.VueButton;
import com.pierrickmonchoix.memoryclient.graphicComponent.checkBox.PresentationCheckBox;
import com.pierrickmonchoix.memoryclient.graphicComponent.checkBox.VueCheckBox;
import com.pierrickmonchoix.memoryclient.graphicComponent.textField.PresentationTextField;
import com.pierrickmonchoix.memoryclient.graphicComponent.textField.VueTextField;

public class PresentationLogin extends Presentation {

    private final PresentationCheckBox presentationCheckBox;
    private final PresentationTextField presentationTextField;
    private final PresentationButton presentationButton;

    public PresentationLogin( String defaultPseudo ,  String textCheckBox , boolean defaultCheck) {
        
        presentationCheckBox = new PresentationCheckBox(textCheckBox,defaultCheck);

        presentationTextField = new PresentationTextField(defaultPseudo);

        presentationButton = new PresentationButton("Login");
        
    }

    public PresentationCheckBox getPresentationCheckBox() {
        return presentationCheckBox;
    }

    public PresentationTextField getPresentationTextField() {
        return presentationTextField;
    }

    public PresentationButton getPresentationButton() {
        return presentationButton;
    }
    

    

    



    



    
    
}
