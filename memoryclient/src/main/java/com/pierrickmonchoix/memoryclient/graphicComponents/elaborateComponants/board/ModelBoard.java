package com.pierrickmonchoix.memoryclient.graphicComponents.elaborateComponants.board;

import com.pierrickmonchoix.memoryclient.graphicComponents.basicComponants.EComponantBasicEvent;
import com.pierrickmonchoix.memoryclient.graphicComponents.basicComponants.IComponantListener;
import com.pierrickmonchoix.memoryclient.websocket.IWebsocketListener;
import com.pierrickmonchoix.memoryclient.websocket.WebsocketClientHelper;
import com.pierrickmonchoix.memoryclient.websocket.websocketMessage.WebsocketMessage;

public class ModelBoard implements IWebsocketListener, IComponantListener {

    private final PresentationBoard presentationBoard;
    
    public ModelBoard(PresentationBoard presentationBoard) {
        this.presentationBoard = presentationBoard;

        addCardsListener();  // je m'abonne a toutes mes cartes

        addWebsocketListener();  // jje m'abonne a wsHelper


    }





    @Override
    public void whenNotifiedByComponant(EComponantBasicEvent typeEvent) {
        // TODO Auto-generated method stub

    }

    @Override
    public void whenReceiveWebsocketMessage(WebsocketMessage websocketMessage) {
        // TODO Auto-generated method stub

    }

    private void addCardsListener(){
        presentationBoard.addCardsListener(this);
    }

    private void addWebsocketListener(){
        WebsocketClientHelper.addListener(this);
    }



    
}
