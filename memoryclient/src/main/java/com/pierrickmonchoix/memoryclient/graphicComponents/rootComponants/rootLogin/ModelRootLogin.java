package com.pierrickmonchoix.memoryclient.graphicComponents.rootComponants.rootLogin;

import com.pierrickmonchoix.memoryclient.graphicComponents.elaborateComponants.login.ModelLogin;
import com.pierrickmonchoix.memoryclient.graphicComponents.elaborateComponants.loginTextResult.ModelLoginTextResult;

public class ModelRootLogin {

    private final ModelLogin modelLogin;

    private final ModelLoginTextResult modelLoginTextResult;

    private final PresentationRootLogin presentationRootLogin;

    public ModelRootLogin(PresentationRootLogin presentationRootLogin) {
        this.presentationRootLogin = presentationRootLogin;

        modelLogin = new ModelLogin(presentationRootLogin.getPresentationLogin());

        modelLoginTextResult = new ModelLoginTextResult( presentationRootLogin.getPresentationLoginTextResult() , modelLogin);

    }

    
     
}
