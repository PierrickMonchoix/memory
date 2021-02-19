package com.pierrickmonchoix.memoryclient.graphicComponents.elaborateComponants.buttonCreateGame;

import java.util.List;
import java.util.logging.Logger;

import com.pierrickmonchoix.memoryclient.graphicComponents.forJson.GameManagerForJson;
import com.pierrickmonchoix.memoryclient.graphicComponents.forJson.ShownGameForJson;
import com.pierrickmonchoix.memoryclient.graphicComponents.superclasses.EChildEvent;
import com.pierrickmonchoix.memoryclient.graphicComponents.superclasses.IChildenListener;
import com.pierrickmonchoix.memoryclient.websocket.IWebsocketListener;
import com.pierrickmonchoix.memoryclient.websocket.WebsocketClientHelper;
import com.pierrickmonchoix.memoryclient.websocket.websocketMessage.EMessageType;
import com.pierrickmonchoix.memoryclient.websocket.websocketMessage.WebsocketMessage;

public class ModeleButtonCreateGame implements IChildenListener, IWebsocketListener {

    private final PresentationButtonCreateGame presentationButtonCreateGame;

    private static Logger logger = Logger.getLogger(ModeleButtonCreateGame.class.getName());

    public ModeleButtonCreateGame(PresentationButtonCreateGame presentationButtonCreateGame) {
        this.presentationButtonCreateGame = presentationButtonCreateGame;

        
        
        listenWebsocketHelper();
        listenAllChildren();
    }

    @Override
    public void listenWebsocketHelper() {
        WebsocketClientHelper.addListener(this);
    }

    @Override
    public void listenAllChildren() {
        presentationButtonCreateGame.attributeParentListener(this);

    }

    @Override
    public void whenNotifiedByChild(EChildEvent typeEvent) {
        if (typeEvent == EChildEvent.ASK_FOR_CREATE_GAME) {
            WebsocketClientHelper.sendMessageToServer(EMessageType.CREATE_GAME, "");
        }
        else{
            logger.warning("mon chiled ne m'as pas bien notifié");
        }
    }



    @Override
    public void whenReceiveWebsocketMessage(WebsocketMessage message) {
        if (message.getType() == EMessageType.UPDATE_LIST_GAMES) {
            logger.info("message recu pour create button: " + message.getContenu());
            GameManagerForJson gameManagerForJson = GameManagerForJson.fromJson(message.getContenu());

            boolean imInGame = imInGame(gameManagerForJson);

            // le bouton doit etre enable ou non selon si je suis inscrit dans une partie ou non
            presentationButtonCreateGame.setEnable( ! imInGame);

        }
    }


    private boolean imInGame(GameManagerForJson gameManagerForJson){
        String monPseudo = WebsocketClientHelper.getPseudo();
        List<ShownGameForJson> listShownGameForJsons = gameManagerForJson.listJsonGames;
        for (ShownGameForJson shownGameForJson : listShownGameForJsons) {
            List<String> listJoueursInGame = shownGameForJson.listPlayer;
            for (String pseudoInGame : listJoueursInGame) {
                if(pseudoInGame.equals(monPseudo)){
                    return true;
                }
            }
        }
        return false;
    }






}
