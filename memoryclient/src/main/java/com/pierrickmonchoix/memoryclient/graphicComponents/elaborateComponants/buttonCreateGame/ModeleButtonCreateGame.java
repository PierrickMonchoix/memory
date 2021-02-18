package com.pierrickmonchoix.memoryclient.graphicComponents.elaborateComponants.buttonCreateGame;

import java.util.List;
import java.util.logging.Logger;

import com.pierrickmonchoix.memoryclient.graphicComponents.basicComponants.EComponantBasicEvent;
import com.pierrickmonchoix.memoryclient.graphicComponents.basicComponants.IComponantListener;
import com.pierrickmonchoix.memoryclient.graphicComponents.forJson.GameManagerForJson;
import com.pierrickmonchoix.memoryclient.graphicComponents.forJson.ShownGameForJson;
import com.pierrickmonchoix.memoryclient.websocket.IWebsocketListener;
import com.pierrickmonchoix.memoryclient.websocket.WebsocketClientHelper;
import com.pierrickmonchoix.memoryclient.websocket.websocketMessage.EMessageType;
import com.pierrickmonchoix.memoryclient.websocket.websocketMessage.WebsocketMessage;

public class ModeleButtonCreateGame implements IComponantListener, IWebsocketListener {

    private final PresentationButtonCreateGame presentationButtonCreateGame;

    private static Logger logger = Logger.getLogger(ModeleButtonCreateGame.class.getName());

    public ModeleButtonCreateGame(PresentationButtonCreateGame presentationButtonCreateGame) {
        this.presentationButtonCreateGame = presentationButtonCreateGame;

        presentationButtonCreateGame.addButtonListener(this);
        WebsocketClientHelper.addListener(this);

    }

    @Override
    public void whenNotifiedByComponant(EComponantBasicEvent typeEvent) {
        if (typeEvent == EComponantBasicEvent.BUTTON_PRESSED) {
            WebsocketClientHelper.sendMessageToServer(EMessageType.CREATE_GAME, "");
        }

    }

    @Override
    public void whenReceiveWebsocketMessage(WebsocketMessage message) {
        if (message.getType() == EMessageType.UPDATE_LIST_GAMES) {
            logger.info("message recu pour create button: " + message.getContenu());
            GameManagerForJson gameManagerForJson = GameManagerForJson.fromJson(message.getContenu());

            boolean gameAlreadyCreated = iHaveCreateGame(gameManagerForJson);

            setEnable(!gameAlreadyCreated);
            /*
             * for (ShownGameForJson shownGameForJson : listGameManagerForJsons) { String
             * pseudoHost = shownGameForJson.pseudoHost; logger.info("ajout new game");
             * 
             * }
             */

        }
    }

    private boolean iHaveCreateGame(GameManagerForJson gameManagerForJson) {

        List<ShownGameForJson> listShownGameForJsons = gameManagerForJson.listJsonGames;
        for (ShownGameForJson shownGameForJson : listShownGameForJsons) {
            if (shownGameForJson.pseudoHost.equals(WebsocketClientHelper.getPseudo())) {
                logger.info("oups jai deja cree une partie");
                return true;

            }
        }
        return false;
    }

    private void setEnable(boolean enable) {
        presentationButtonCreateGame.setEnable(enable);
    }

}
