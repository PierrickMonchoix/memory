package com.pierrickmonchoix.memoryclient.graphicComponent.rootLogin;

import com.pierrickmonchoix.memoryclient.graphicComponent.Presentation;
import com.pierrickmonchoix.memoryclient.graphicComponent.login.PresentationLogin;

public class PresentationRootLogin extends Presentation{

    private final PresentationLogin presentationLogin;

    public PresentationRootLogin(String defaultPseudo ,  String textCheckBox , boolean defaultCheck) {

        presentationLogin = new PresentationLogin(  defaultPseudo ,   textCheckBox ,  defaultCheck);


    }

    public PresentationLogin getPresentationLogin() {
        return presentationLogin;
    }



    
    
    
    
}
