package com.pierrickmonchoix.memoryclient.graphicComponents.elaborateComponants.winner;

import java.util.logging.Logger;

import com.pierrickmonchoix.memoryclient.websocket.IWebsocketListener;
import com.pierrickmonchoix.memoryclient.websocket.WebsocketClientHelper;
import com.pierrickmonchoix.memoryclient.websocket.websocketMessage.EMessageType;
import com.pierrickmonchoix.memoryclient.websocket.websocketMessage.WebsocketMessage;

public class ModeleWinner implements IWebsocketListener {

    private PresentationWinner presentationWinner;

    private static Logger logger = Logger.getLogger(PresentationWinner.class.getName());

    public ModeleWinner(PresentationWinner presentationWinner) {
        this.presentationWinner = presentationWinner;
        listenWebsocketHelper();
    }



    @Override
    public void listenWebsocketHelper() {
        WebsocketClientHelper.addListener(this);

    }

    @Override
    public void whenReceiveWebsocketMessage(WebsocketMessage websocketMessage) {
        if(websocketMessage.getType() == EMessageType.WINNER){

            logger.info("je doit atribuer un winner");
            String pseudoWinner = websocketMessage.getContenu();
            setWinner(pseudoWinner);
        }
    }


    public void setWinner(String pseudoWinner) {
        presentationWinner.setText("Le gagnant est : " + pseudoWinner);
    }
    
}
