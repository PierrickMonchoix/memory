package com.pierrickmonchoix.memoryclient.graphicComponent.login;

import com.pierrickmonchoix.memoryclient.graphicComponent.Presentation;
import com.pierrickmonchoix.memoryclient.graphicComponent.checkBox.PresentationCheckBox;
import com.pierrickmonchoix.memoryclient.graphicComponent.checkBox.VueCheckBox;

public class PresentationLogin extends Presentation {

    private PresentationCheckBox presentationCheckBox;

    public PresentationLogin(String text , boolean defaultCheck) {
        
        presentationCheckBox = new PresentationCheckBox(text,defaultCheck);
        System.out.println("# presentationCheckBox : " + presentationCheckBox);
        VueCheckBox vueCheckBox = new VueCheckBox(presentationCheckBox);
        System.out.println("# vueCheckBox : " + vueCheckBox);
        presentationCheckBox.setVue(vueCheckBox);
        
    }

    public PresentationCheckBox getPresentationCheckBox() {
        return presentationCheckBox;
    }

    public void setPresentationCheckBox(PresentationCheckBox presentationCheckBox) {
        this.presentationCheckBox = presentationCheckBox;
    }

    



    



    
    
}
