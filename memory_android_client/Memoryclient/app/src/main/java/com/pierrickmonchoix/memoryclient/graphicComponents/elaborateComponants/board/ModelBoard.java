package com.pierrickmonchoix.memoryclient.graphicComponents.elaborateComponants.board;

import java.util.logging.Logger;

import com.pierrickmonchoix.memoryclient.graphicComponents.forJson.GameForJson;
import com.pierrickmonchoix.memoryclient.graphicComponents.forJson.PlayerForJson;
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
        WebsocketClientHelper.getInstance().addListener(this);

    }

    @Override
    public void whenReceiveWebsocketMessage(WebsocketMessage websocketMessage) {
        if ((websocketMessage.getType() == EMessageType.DRAW_FIRST_CARD)
                || (websocketMessage.getType() == EMessageType.DRAW_SECOND_CARD)
                || (websocketMessage.getType() == EMessageType.SHOW_CARD)) {
            logger.info("ah je dois m'update");
            GameForJson gameForJson = GameForJson.fromJson(websocketMessage.getContenu());
            presentationBoard.setUpAll(gameForJson);

            String actualPlayerPseudo = gameForJson.actualPlayer.pseudo;
            String monPseudo = WebsocketClientHelper.getInstance().getPseudo();

            if ((websocketMessage.getType() == EMessageType.SHOW_CARD) && actualPlayerPseudo.equals(monPseudo)) {
                waitAndSendToServerCardsSeen();
            }
        }
    }

    private void waitAndSendToServerCardsSeen() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            // gestion de l'erreur
        }

        WebsocketClientHelper.getInstance().sendMessageToServer(EMessageType.SHOW_CARD, "");
    }

}
