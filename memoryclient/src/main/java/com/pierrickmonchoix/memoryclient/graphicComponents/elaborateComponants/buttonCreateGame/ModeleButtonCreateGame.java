package com.pierrickmonchoix.memoryclient.graphicComponents.elaborateComponants.buttonCreateGame;

import com.pierrickmonchoix.memoryclient.graphicComponents.basicComponants.EComponantBasicEvent;
import com.pierrickmonchoix.memoryclient.graphicComponents.basicComponants.IComponantListener;
import com.pierrickmonchoix.memoryclient.websocket.WebsocketClientHelper;
import com.pierrickmonchoix.memoryclient.websocket.websocketMessage.EMessageType;

public class ModeleButtonCreateGame implements IComponantListener {

    private final PresentationButtonCreateGame presentationButtonCreateGame;

    public ModeleButtonCreateGame(PresentationButtonCreateGame presentationButtonCreateGame) {
        this.presentationButtonCreateGame = presentationButtonCreateGame;

        presentationButtonCreateGame.addButtonListener(this);

    }

    @Override
    public void whenNotifiedByComponant(EComponantBasicEvent typeEvent) {
        if (typeEvent == EComponantBasicEvent.BUTTON_PRESSED) {
            WebsocketClientHelper.sendMessageToServer(EMessageType.CREATE_GAME, "");
        }

    }


}
