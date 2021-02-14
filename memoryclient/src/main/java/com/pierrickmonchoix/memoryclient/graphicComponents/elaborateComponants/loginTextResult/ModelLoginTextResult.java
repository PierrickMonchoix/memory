package com.pierrickmonchoix.memoryclient.graphicComponents.elaborateComponants.loginTextResult;

import java.util.logging.Logger;

import com.pierrickmonchoix.memoryclient.graphicComponents.elaborateComponants.login.ILoginListener;
import com.pierrickmonchoix.memoryclient.graphicComponents.elaborateComponants.login.ModelLogin;
import com.pierrickmonchoix.memoryclient.websocket.WebsocketHelper;
import com.pierrickmonchoix.memoryclient.websocket.websocketClient.IWebsocketListener;
import com.pierrickmonchoix.memoryclient.websocket.websocketMessage.EMessageType;
import com.pierrickmonchoix.memoryclient.websocket.websocketMessage.WebsocketMessage;

import javafx.application.Platform;

public class ModelLoginTextResult implements ILoginListener, IWebsocketListener { // implements IWebsocketListener

    private PresentationLoginTextResult presentationLoginTextResult;
    private ModelLogin modelLogin; // connait model login

    private static Logger logger = Logger.getLogger(ModelLoginTextResult.class.getName());

   

    private String text;

    public ModelLoginTextResult(PresentationLoginTextResult presentationLoginTextResult, ModelLogin modelLogin) {
        this.presentationLoginTextResult = presentationLoginTextResult;
        this.modelLogin = modelLogin;



        WebsocketHelper.addListener(this);
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
            WebsocketHelper.sendMessageToServer(EMessageType.LOGIN,"yolo");
        }
    }

    @Override
    public void whenReceiveWebsocketMessage(WebsocketMessage websocketMessage) {
        logger.info("jai ete notifié par ws");
        text = text + websocketMessage.getContenu();
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                presentationLoginTextResult.setText(text); // on a ajouté la reponse WS
            }
        });
        
    }

    // when notify by ws

}
