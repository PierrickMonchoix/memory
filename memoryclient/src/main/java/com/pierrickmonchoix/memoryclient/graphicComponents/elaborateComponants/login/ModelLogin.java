package com.pierrickmonchoix.memoryclient.graphicComponents.elaborateComponants.login;

import java.util.ArrayList;
import java.util.List;

import com.pierrickmonchoix.memoryclient.graphicComponents.basicComponants.EComponantBasicEvent;
import com.pierrickmonchoix.memoryclient.graphicComponents.basicComponants.IComponantListener;
import com.pierrickmonchoix.memoryclient.websocket.WebsocketHelper;
import com.pierrickmonchoix.memoryclient.websocket.websocketClient.IWebsocketListener;
import com.pierrickmonchoix.memoryclient.websocket.websocketMessage.WebsocketMessage;

public class ModelLogin implements IComponantListener{

    private final PresentationLogin presentationLogin;

    private final List<ILoginListener> listListeners;

    public ModelLogin(PresentationLogin presentationLogin) {
        this.presentationLogin = presentationLogin;

        presentationLogin.addButtonListener(this);

        listListeners = new ArrayList<ILoginListener>();

    }

    public String getUsername() {
        return presentationLogin.getUsername();
    }

    public Boolean isNewUser() {
        return presentationLogin.isNewUser();
    }

    @Override
    public void whenNotifiedByComponant(EComponantBasicEvent typeEvent) {
        if (typeEvent == EComponantBasicEvent.BUTTON_PRESSED) {
            if (!getUsername().equals("")) { // si le nom d'utilisateur est bien remplit!
              //  WebsocketHelper.setPseudo(getUsername());
                notifyListenersOfSignInOrUp();

                /*
                 * LOGS:
                 */
                if (isNewUser()) { // se connecrte a WS et envoie reponse a textResult
                    System.out.println("Tentative de premiere connexion en tant que : " + getUsername());
                } else {
                    System.out.println("Tentative de connexion habituelle en tant que : " + getUsername());
                }

            }
        }

    }




    public void addListener(ILoginListener listener) {
        listListeners.add(listener);
    }

    public void notifyListenersOfSignInOrUp() {
        for (ILoginListener listener : listListeners) {
            listener.whenNotifiedOfSignInOrUp();
        }
    }


}
