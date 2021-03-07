package com.pierrickmonchoix.memoryclient.graphicComponent2.rootLogin;

import com.pierrickmonchoix.memoryclient.graphicComponent2.Presentation;
import com.pierrickmonchoix.memoryclient.graphicComponent2.login.PresentationLogin;

public class PresentationRootLogin extends Presentation{

    private final PresentationLogin presentationLogin;

    public PresentationRootLogin(String defaultPseudo ,  String textCheckBox , boolean defaultCheck) {

        presentationLogin = new PresentationLogin(  defaultPseudo ,   textCheckBox ,  defaultCheck);


    }

    public PresentationLogin getPresentationLogin() {
        return presentationLogin;
    }



    
    
    
    
}
