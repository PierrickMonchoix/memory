package com.pierrickmonchoix.memoryclient.graphicComponents.rootComponants.rootLogin;

import com.pierrickmonchoix.memoryclient.graphicComponents.Presentation;
import com.pierrickmonchoix.memoryclient.graphicComponents.elaborateComponants.login.PresentationLogin;
import com.pierrickmonchoix.memoryclient.graphicComponents.elaborateComponants.loginTextResult.PresentationLoginResult;

public class PresentationRootLogin extends Presentation{

    private final PresentationLogin presentationLogin;

    private final PresentationLoginResult presentationLoginTextResult;

    public PresentationRootLogin(String defaultPseudo ,  String textCheckBox , boolean defaultCheck) {

        presentationLogin = new PresentationLogin(  defaultPseudo ,   textCheckBox ,  defaultCheck);

        presentationLoginTextResult = new PresentationLoginResult("hellooo");


    }

    public PresentationLogin getPresentationLogin() {
        return presentationLogin;
    }

    public PresentationLoginResult getPresentationLoginTextResult() {
        return presentationLoginTextResult;
    }

    

    



    
    
    
    
}
