package com.pierrickmonchoix.memoryclient.graphicComponents.elaborateComponants.loginTextResult;

import com.pierrickmonchoix.memoryclient.graphicComponents.elaborateComponants.login.ILoginListener;
import com.pierrickmonchoix.memoryclient.graphicComponents.elaborateComponants.login.ModelLogin;
import com.pierrickmonchoix.memoryclient.websocketClient.IWebsocketClientListener;
import com.pierrickmonchoix.memoryclient.websocketClient.WebsocketClient;
import com.pierrickmonchoix.memoryclient.websocketMessage.WebsocketMessage;

public class ModelLoginTextResult implements ILoginListener, IWebsocketClientListener { // implements IWebsocketListener

    private PresentationLoginTextResult presentationLoginTextResult;
    private ModelLogin modelLogin; // connait model login

    private WebsocketClient websocketClient;

    private String text;

    public ModelLoginTextResult(PresentationLoginTextResult presentationLoginTextResult, ModelLogin modelLogin , WebsocketClient websocketClient) {
        this.presentationLoginTextResult = presentationLoginTextResult;
        this.modelLogin = modelLogin;

        this.websocketClient = websocketClient;


        websocketClient.addListener(this);
        modelLogin.addListener(this);
    }

    @Override
    public void whenNotifiedOfSignInOrUp() {
        if (!modelLogin.getUsername().equals("")) { // si le nom d'utilisateur est bien remplit!
            if (modelLogin.isNewUser()) { // se connecrte a WS et envoie reponse a textResult
                text = "Tentative de premiere connexion en tant que : " + modelLogin.getUsername() + "\n";
                presentationLoginTextResult.setText(text); // on ajoutera la reponse WS
            } else {
                text = "Tentative de connexion habituelle en tant que : " + modelLogin.getUsername() + "\n";
                presentationLoginTextResult.setText(text); // on ajoutera la reponse WS
            }
            websocketClient.sendMessage();
        }
    }

    @Override
    public void whenReceiveWebsocketMessage(WebsocketMessage websocketMessage) {
        text = text + websocketMessage.getContenu();
        presentationLoginTextResult.setText(text); // on a ajouté la reponse WS
    }

    // when notify by ws

}
