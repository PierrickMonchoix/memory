package com.pierrickmonchoix.memoryclient.graphicComponents.rootComponants.rootLogin;

import com.pierrickmonchoix.memoryclient.graphicComponents.elaborateComponants.login.ModelLogin;
import com.pierrickmonchoix.memoryclient.graphicComponents.elaborateComponants.loginTextResult.ModelLoginResult;


/**
 * Composé d'un login qui enoie au serveur un msg de tentative de connexion.
 * le serveur répond au loginTextResult si c'est ok ou non
 */
public class ModelRootLogin {

    

    public ModelRootLogin(PresentationRootLogin presentationRootLogin) {

        ModelLogin modelLogin = new ModelLogin(presentationRootLogin.getPresentationLogin());

        ModelLoginResult modelLoginTextResult = new ModelLoginResult( presentationRootLogin.getPresentationLoginTextResult() , modelLogin);

    }

    
     
}
