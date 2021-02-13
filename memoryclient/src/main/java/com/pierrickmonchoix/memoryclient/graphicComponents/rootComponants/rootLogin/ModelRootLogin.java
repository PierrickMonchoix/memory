package com.pierrickmonchoix.memoryclient.graphicComponents.rootComponants.rootLogin;

import com.pierrickmonchoix.memoryclient.graphicComponents.elaborateComponants.login.ModelLogin;
import com.pierrickmonchoix.memoryclient.graphicComponents.elaborateComponants.loginTextResult.ModelLoginTextResult;
import com.pierrickmonchoix.memoryclient.websocketClient.WebsocketClient;

public class ModelRootLogin {

    private final ModelLogin modelLogin;

    private final ModelLoginTextResult modelLoginTextResult;

    private final PresentationRootLogin presentationRootLogin;

    public ModelRootLogin(PresentationRootLogin presentationRootLogin , WebsocketClient websocketClient) {
        this.presentationRootLogin = presentationRootLogin;

        modelLogin = new ModelLogin(presentationRootLogin.getPresentationLogin());

        modelLoginTextResult = new ModelLoginTextResult( presentationRootLogin.getPresentationLoginTextResult() , modelLogin , websocketClient);

    }

    
     
}
