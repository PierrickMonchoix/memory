package com.pierrickmonchoix.memoryclient.graphicComponent2.login;

import com.pierrickmonchoix.memoryclient.graphicComponent2.Presentation;
import com.pierrickmonchoix.memoryclient.graphicComponent2.button.PresentationButton;
import com.pierrickmonchoix.memoryclient.graphicComponent2.checkBox.PresentationCheckBox;
import com.pierrickmonchoix.memoryclient.graphicComponent2.textField.PresentationTextField;

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

    



    



    
    

