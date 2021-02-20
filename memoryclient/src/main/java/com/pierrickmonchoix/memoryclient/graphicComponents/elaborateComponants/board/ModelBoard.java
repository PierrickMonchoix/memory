package com.pierrickmonchoix.memoryclient.graphicComponents.elaborateComponants.board;

import java.util.logging.Logger;

import com.pierrickmonchoix.memoryclient.graphicComponents.forJson.GameForJson;
import com.pierrickmonchoix.memoryclient.websocket.IWebsocketListener;
import com.pierrickmonchoix.memoryclient.websocket.WebsocketClientHelper;
import com.pierrickmonchoix.memoryclient.websocket.websocketMessage.EMessageType;
import com.pierrickmonchoix.memoryclient.websocket.websocketMessage.WebsocketMessage;

public class ModelBoard implements IWebsocketListener {

    private static Logger logger = Logger.getLogger(ModelBoard.class.getName());

    private final PresentationBoard presentationBoard;
    
    public ModelBoard(PresentationBoard presentationBoard) {
        this.presentationBoard = presentationBoard;
        


        listenWebsocketHelper();
    }

    @Override
    public void listenWebsocketHelper() {
        WebsocketClientHelper.addListener(this);

    }

    @Override
    public void whenReceiveWebsocketMessage(WebsocketMessage websocketMessage) {
        if( websocketMessage.getType() == EMessageType.DRAW_FIRST_CARD ){
            GameForJson gameForJson = GameForJson.fromJson( websocketMessage.getContenu() );
            presentationBoard.setUpAll(gameForJson);
        }
    }












    
}
