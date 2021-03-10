package com.pierrickmonchoix.memoryclient.graphicComponents.rootComponants.rootLogin;

import com.pierrickmonchoix.memoryclient.graphicComponents.elaborateComponants.login.PresentationLogin;
import com.pierrickmonchoix.memoryclient.graphicComponents.elaborateComponants.login.VueLogin;
import com.pierrickmonchoix.memoryclient.graphicComponents.elaborateComponants.loginTextResult.PresentationLoginResult;
import com.pierrickmonchoix.memoryclient.graphicComponents.elaborateComponants.loginTextResult.VueLoginResult;
import com.pierrickmonchoix.memoryclient.graphicComponents.superclasses.Presentation;

public class PresentationRootLogin extends Presentation{

    private final PresentationLogin presentationLogin;

    private final PresentationLoginResult presentationLoginTextResult;

    public PresentationRootLogin(String defaultPseudo ,  String textCheckBox , boolean defaultCheck) {

        presentationLogin = new PresentationLogin(  defaultPseudo ,   textCheckBox ,  defaultCheck);
        VueLogin vueLogin = new VueLogin(presentationLogin);
        presentationLogin.setVue(vueLogin);

        presentationLoginTextResult = new PresentationLoginResult("Bienvenue sur ce memory tout mignon tout plein");
        VueLoginResult vueLoginResult = new VueLoginResult(presentationLoginTextResult);
        presentationLoginTextResult.setVue(vueLoginResult);


    }

    public PresentationLogin getPresentationLogin() {
        return presentationLogin;
    }

    public PresentationLoginResult getPresentationLoginTextResult() {
        return presentationLoginTextResult;
    }

    

    



    
    
    
    
}
