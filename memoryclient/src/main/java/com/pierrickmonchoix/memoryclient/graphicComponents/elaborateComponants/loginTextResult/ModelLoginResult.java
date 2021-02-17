package com.pierrickmonchoix.memoryclient.graphicComponents.elaborateComponants.loginTextResult;

import java.util.logging.Logger;

import com.pierrickmonchoix.memoryclient.graphicComponents.RootManager;
import com.pierrickmonchoix.memoryclient.graphicComponents.elaborateComponants.login.ILoginListener;
import com.pierrickmonchoix.memoryclient.graphicComponents.elaborateComponants.login.ModelLogin;
import com.pierrickmonchoix.memoryclient.websocket.IWebsocketListener;
import com.pierrickmonchoix.memoryclient.websocket.WebsocketClientHelper;
import com.pierrickmonchoix.memoryclient.websocket.websocketMessage.EMessageType;
import com.pierrickmonchoix.memoryclient.websocket.websocketMessage.WebsocketMessage;

import javafx.application.Platform;

/**
 * Recoit le resultat du serveur : si la connexion est accépté ou non. i.e si le
 * signIn marche car il y avais bien ce pseudo en stock ou inversement pour le
 * signUp Il affiche ce resultat par le bais d'un TextviewOutput
 */
public class ModelLoginResult implements ILoginListener, IWebsocketListener { // implements IWebsocketListener

    private PresentationLoginResult presentationLoginTextResult;
    private ModelLogin modelLogin; // connait model login

    private static Logger logger = Logger.getLogger(ModelLoginResult.class.getName());

    private String text;

    public ModelLoginResult(PresentationLoginResult presentationLoginTextResult, ModelLogin modelLogin) {
        this.presentationLoginTextResult = presentationLoginTextResult;
        this.modelLogin = modelLogin;

        WebsocketClientHelper.addListener(this);
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

        }
    }

    @Override
    public void whenReceiveWebsocketMessage(WebsocketMessage message) {
        if ((message.getType() == EMessageType.SIGN_IN) || (message.getType() == EMessageType.SIGN_UP)) {
            logger.info("jai ete notifié par ws");
            text = text + message.getContenu();
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    if (message.getContenu().substring(0, 2).equals("ok")) {
                        WebsocketClientHelper.setPseudo(message.getPseudo());
                        RootManager.setHeroPseudo(message.getPseudo());
                        RootManager.setVueRootListGames();
                    }
                    presentationLoginTextResult.setText(text); // on a ajouté la reponse WS
                }
            });
        }

    }

    // when notify by ws

}
