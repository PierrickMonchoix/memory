package com.pierrickmonchoix.memoryclient.graphicComponents.rootComponants.rootLogin;

import com.pierrickmonchoix.memoryclient.graphicComponents.Presentation;
import com.pierrickmonchoix.memoryclient.graphicComponents.elaborateComponants.login.PresentationLogin;
import com.pierrickmonchoix.memoryclient.graphicComponents.elaborateComponants.loginTextResult.PresentationLoginTextResult;

public class PresentationRootLogin extends Presentation{

    private final PresentationLogin presentationLogin;

    private final PresentationLoginTextResult presentationLoginTextResult;

    public PresentationRootLogin(String defaultPseudo ,  String textCheckBox , boolean defaultCheck) {

        presentationLogin = new PresentationLogin(  defaultPseudo ,   textCheckBox ,  defaultCheck);

        presentationLoginTextResult = new PresentationLoginTextResult("hellooo");


    }

    public PresentationLogin getPresentationLogin() {
        return presentationLogin;
    }

    public PresentationLoginTextResult getPresentationLoginTextResult() {
        return presentationLoginTextResult;
    }

    

    



    
    
    
    
}
