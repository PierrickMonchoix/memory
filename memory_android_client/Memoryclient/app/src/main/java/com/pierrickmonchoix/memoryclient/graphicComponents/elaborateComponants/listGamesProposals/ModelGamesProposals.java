package com.pierrickmonchoix.memoryclient.graphicComponents.elaborateComponants.listGamesProposals;


import java.util.logging.Logger;

import com.pierrickmonchoix.memoryclient.graphicComponents.forJson.GameManagerForJson;
import com.pierrickmonchoix.memoryclient.websocket.IWebsocketListener;
import com.pierrickmonchoix.memoryclient.websocket.WebsocketClientHelper;
import com.pierrickmonchoix.memoryclient.websocket.websocketMessage.EMessageType;
import com.pierrickmonchoix.memoryclient.websocket.websocketMessage.WebsocketMessage;

public class ModelGamesProposals implements IWebsocketListener {

    private static Logger logger = Logger.getLogger(ModelGamesProposals.class.getName());

    private final PresentationGamesProposals presentationGamesProposals;

    public ModelGamesProposals(PresentationGamesProposals presentationGamesProposals) {
        this.presentationGamesProposals = presentationGamesProposals;
        listenWebsocketHelper();
        
    }

    @Override
    public void listenWebsocketHelper() {
        WebsocketClientHelper.addListener(this);
    }

    @Override
    public void whenReceiveWebsocketMessage(WebsocketMessage message) {
        if (message.getType() == EMessageType.UPDATE_LIST_GAMES) {
            logger.info("msg recu par ws");
            logger.info("message recu pour games proposals: " + message.getContenu());
            GameManagerForJson gameManagerForJson = GameManagerForJson.fromJson(message.getContenu());
            presentationGamesProposals.setUpAll(gameManagerForJson);
        }
    }




}
