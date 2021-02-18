package com.pierrickmonchoix.memoryclient.graphicComponents.elaborateComponants.gameProposal;

import com.pierrickmonchoix.memoryclient.graphicComponents.basicComponants.EComponantBasicEvent;
import com.pierrickmonchoix.memoryclient.graphicComponents.basicComponants.IComponantListener;
import com.pierrickmonchoix.memoryclient.websocket.WebsocketClientHelper;
import com.pierrickmonchoix.memoryclient.websocket.websocketMessage.EMessageType;

public class ModelGameProposal implements IComponantListener {

    final PresentationGameProposal presentationGameProposal;

    private boolean actived;


    public ModelGameProposal(PresentationGameProposal presentationGameProposal) {
        this.presentationGameProposal = presentationGameProposal;
        actived = true;

        presentationGameProposal.addButtonListener(this);
    }

    @Override
    public void whenNotifiedByComponant(EComponantBasicEvent typeEvent) {
        if ( actived || ( typeEvent == EComponantBasicEvent.BUTTON_PRESSED )) {
            WebsocketClientHelper.sendMessageToServer(EMessageType.JOIN_GAME, presentationGameProposal.getPseudo());
        }
    }

    public void unActive(){
        actived = false;
    }

    
}
