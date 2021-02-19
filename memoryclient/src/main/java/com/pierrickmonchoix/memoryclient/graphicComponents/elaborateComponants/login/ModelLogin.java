package com.pierrickmonchoix.memoryclient.graphicComponents.elaborateComponants.login;

import java.util.logging.Logger;

import com.pierrickmonchoix.memoryclient.graphicComponents.superclasses.EChildEvent;
import com.pierrickmonchoix.memoryclient.graphicComponents.superclasses.IChildenListener;
import com.pierrickmonchoix.memoryclient.websocket.WebsocketClientHelper;
import com.pierrickmonchoix.memoryclient.websocket.websocketMessage.EMessageType;

/**
 * Ce login enoie un msg au serveur lors de l'appui sur le bouton de connexion.
 * Il prévient le serveur que le client tente de se connecter avec le psueod
 * dans son textfield, et s'il souhaite se connecter en signIn ou signUp
 */
public class ModelLogin implements IChildenListener {

    private static Logger logger = Logger.getLogger(ModelLogin.class.getName());

    private final PresentationLogin presentationLogin;

    public ModelLogin(PresentationLogin presentationLogin) {
        this.presentationLogin = presentationLogin;
        
        listenAllChildren();
    }

    @Override
    public void listenAllChildren() {
        presentationLogin.attributeParentListener(this);
    }

    @Override
    public void whenNotifiedByChild(EChildEvent typeEvent) {
        if (typeEvent == EChildEvent.ASK_FOR_LOGIN) {
            if (!getUsername().equals("")) { // si le nom d'utilisateur est bien remplit!
                // WebsocketHelper.setPseudo(getUsername());
                /*
                 * LOGS:
                 */
                if (isNewUser()) { // se connecrte a WS et envoie reponse a textResult
                    System.out.println("Tentative de premiere connexion en tant que : " + getUsername());
                    WebsocketClientHelper.sendMessageToServer(EMessageType.SIGN_UP, getUsername());
                } else {
                    System.out.println("Tentative de connexion habituelle en tant que : " + getUsername());
                    WebsocketClientHelper.sendMessageToServer(EMessageType.SIGN_IN, getUsername());
                }

            }

        }
        else{
            logger.warning("mes enfants ne m'as pas bien notifié");
        }

    }

    public String getUsername() {
        return presentationLogin.getUsername();
    }

    public Boolean isNewUser() {
        return presentationLogin.isNewUser();
    }

}
