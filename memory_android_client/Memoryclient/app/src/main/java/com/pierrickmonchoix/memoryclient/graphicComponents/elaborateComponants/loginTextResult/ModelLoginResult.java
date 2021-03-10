package com.pierrickmonchoix.memoryclient.graphicComponents.elaborateComponants.loginTextResult;

import android.util.Log;

import java.util.logging.Logger;

import com.pierrickmonchoix.memoryclient.graphicComponents.RootManager;
import com.pierrickmonchoix.memoryclient.graphicComponents.elaborateComponants.login.ModelLogin;
import com.pierrickmonchoix.memoryclient.websocket.IWebsocketListener;
import com.pierrickmonchoix.memoryclient.websocket.WebsocketClientHelper;
import com.pierrickmonchoix.memoryclient.websocket.websocketMessage.EMessageType;
import com.pierrickmonchoix.memoryclient.websocket.websocketMessage.WebsocketMessage;

/**
 * Recoit le resultat du serveur : si la connexion est accépté ou non. i.e si le
 * signIn marche car il y avais bien ce pseudo en stock ou inversement pour le
 * signUp Il affiche ce resultat par le bais d'un TextviewOutput
 */
public class ModelLoginResult implements IWebsocketListener {

    private PresentationLoginResult presentationLoginTextResult;

    private static Logger logger = Logger.getLogger(ModelLoginResult.class.getName());


    public ModelLoginResult(PresentationLoginResult presentationLoginTextResult, ModelLogin modelLogin) {
        this.presentationLoginTextResult = presentationLoginTextResult;

        listenWebsocketHelper();
    }



    @Override
    public void listenWebsocketHelper() {
        WebsocketClientHelper.getInstance().addListener(this);
    }

    @Override
    public void whenReceiveWebsocketMessage(WebsocketMessage message) {
        if ((message.getType() == EMessageType.SIGN_IN) || (message.getType() == EMessageType.SIGN_UP)) {
            logger.info("msg recu par ws");
            String text = message.getContenu();

            if (message.getContenu().substring(0, 2).equals("ok")) {
                WebsocketClientHelper.getInstance().setPseudo(message.getPseudo());
                Log.i("ModelLoginResult","mon pseudo attribué est: " + WebsocketClientHelper.getInstance().getPseudo());
                RootManager.getInstance().setHeroPseudoOnListGames(message.getPseudo()); // TOCHANGE
                RootManager.getInstance().setVueRootListGames();
            }
            presentationLoginTextResult.setText(text); // on a ajouté la reponse WS

        }

    }





}
