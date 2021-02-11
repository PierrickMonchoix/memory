package com.pierrickmonchoix.memoryclient.graphicComponents.rootComponants.rootLogin;

import com.pierrickmonchoix.memoryclient.graphicComponents.Presentation;
import com.pierrickmonchoix.memoryclient.graphicComponents.elaborateComponants.login.PresentationLogin;

public class PresentationRootLogin extends Presentation{

    private final PresentationLogin presentationLogin;

    public PresentationRootLogin(String defaultPseudo ,  String textCheckBox , boolean defaultCheck) {

        presentationLogin = new PresentationLogin(  defaultPseudo ,   textCheckBox ,  defaultCheck);


    }

    public PresentationLogin getPresentationLogin() {
        return presentationLogin;
    }



    
    
    
    
}
