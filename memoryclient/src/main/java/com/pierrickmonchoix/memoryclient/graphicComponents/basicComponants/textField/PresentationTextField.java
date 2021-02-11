package com.pierrickmonchoix.memoryclient.graphicComponents.basicComponants.textField;

import com.pierrickmonchoix.memoryclient.graphicComponents.Presentation;

public class PresentationTextField extends Presentation {

    private final String defaultText;

    public PresentationTextField(String defaultText) {
        this.defaultText = defaultText;
    }

    public String getDefaultText() {
        return defaultText;
    }

    public String getText(){
        VueTextField vueTextField = (VueTextField)vue;
        return vueTextField.getTextInput();
    }

    
    
}
