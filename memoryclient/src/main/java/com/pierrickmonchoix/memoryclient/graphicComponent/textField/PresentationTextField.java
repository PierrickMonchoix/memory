package com.pierrickmonchoix.memoryclient.graphicComponent.textField;

import com.pierrickmonchoix.memoryclient.graphicComponent.Presentation;

public class PresentationTextField extends Presentation {

    private final String defaultText;

    public PresentationTextField(String defaultText) {
        this.defaultText = defaultText;
    }

    public String getDefaultText() {
        return defaultText;
    }

    
    
}
