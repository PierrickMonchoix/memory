package com.pierrickmonchoix.memoryclient.graphicComponents.elaborateComponants.loginTextResult;

import com.pierrickmonchoix.memoryclient.graphicComponents.elaborateComponants.login.ILoginListener;
import com.pierrickmonchoix.memoryclient.graphicComponents.elaborateComponants.login.ModelLogin;



public class ModelLoginTextResult implements ILoginListener {  // implements IWebsocketListener

    private PresentationLoginTextResult presentationLoginTextResult;
    private ModelLogin modelLogin;  //connait model login

    private String text;

    
    public ModelLoginTextResult(PresentationLoginTextResult presentationLoginTextResult , ModelLogin modelLogin) {
        this.presentationLoginTextResult = presentationLoginTextResult;
        this.modelLogin = modelLogin;

        modelLogin.addListener(this);
    }


    @Override
    public void whenNotifiedOfSignInOrUp() {
        if( ! modelLogin.getUsername().equals("") ){   // si le nom d'utilisateur est bien remplit!
                if(modelLogin.isNewUser()){  // se connecrte a WS et envoie reponse a textResult
                    text = "Tentative de premiere connexion en tant que : " + modelLogin.getUsername();
                    presentationLoginTextResult.setText(text);  // on ajoutera la reponse WS
                }
                else{
                    text = "Tentative de connexion habituelle en tant que : " + modelLogin.getUsername();
                    presentationLoginTextResult.setText(text);   // on ajoutera la reponse WS
                }
            }
    }


    // when notify by ws

    
}
