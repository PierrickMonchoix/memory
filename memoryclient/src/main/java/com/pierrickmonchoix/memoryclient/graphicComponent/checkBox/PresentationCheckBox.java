package com.pierrickmonchoix.memoryclient.graphicComponent.checkBox;

import com.pierrickmonchoix.memoryclient.graphicComponent.Presentation;

public class PresentationCheckBox extends Presentation {


    private final String text;
    private final boolean defaultCheck;


    public PresentationCheckBox(String text , boolean defaultCheck ) {
        this.text = text;
        this.defaultCheck = defaultCheck;
    }

    public String getText() {
        return text;
    }

    public boolean isDefaultChecked() {
        return defaultCheck;
    }

    public boolean isChecked(){
        VueCheckBox vueCheckBox = (VueCheckBox)vue;
        return vueCheckBox.isCheckedInput();
    }






    



    
    
}
