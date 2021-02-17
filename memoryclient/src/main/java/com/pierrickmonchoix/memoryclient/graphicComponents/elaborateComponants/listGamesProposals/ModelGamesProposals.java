package com.pierrickmonchoix.memoryclient.graphicComponents.elaborateComponants.listGamesProposals;

import java.util.List;
import java.util.logging.Logger;

import com.pierrickmonchoix.memoryclient.websocket.IWebsocketListener;
import com.pierrickmonchoix.memoryclient.websocket.WebsocketClientHelper;
import com.pierrickmonchoix.memoryclient.websocket.websocketMessage.EMessageType;
import com.pierrickmonchoix.memoryclient.websocket.websocketMessage.WebsocketMessage;

public class ModelGamesProposals implements IWebsocketListener {

    private static Logger logger = Logger.getLogger(ModelGamesProposals.class.getName());


    private final PresentationGamesProposals presentationGamesProposals;

    public ModelGamesProposals(PresentationGamesProposals presentationGamesProposals) {
        logger.info("fait 1");
        this.presentationGamesProposals = presentationGamesProposals;
        WebsocketClientHelper.addListener(this);
    }

    @Override
    public void whenReceiveWebsocketMessage(WebsocketMessage message) {
        if(message.getType() == EMessageType.UPDATE_LIST_GAMES){
            logger.info("message recu pour games proposals: " +  message.getContenu());
            GameManagerForJson gameManagerForJson = GameManagerForJson.fromJson(message.getContenu());
            List<ShownGameForJson> listGameManagerForJsons = gameManagerForJson.listJsonGames;
            for (ShownGameForJson shownGameForJson : listGameManagerForJsons) {
                String pseudoHost = shownGameForJson.pseudoHost;
                logger.info("ajout new game");
                presentationGamesProposals.addGameOfPseudo(pseudoHost);
            }
            presentationGamesProposals.updateVue();
        }

    }


    
}
