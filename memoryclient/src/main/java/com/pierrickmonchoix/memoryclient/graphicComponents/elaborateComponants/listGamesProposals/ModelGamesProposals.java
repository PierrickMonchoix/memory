package com.pierrickmonchoix.memoryclient.graphicComponents.elaborateComponants.listGamesProposals;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import com.pierrickmonchoix.memoryclient.graphicComponents.elaborateComponants.gameProposal.ModelGameProposal;
import com.pierrickmonchoix.memoryclient.graphicComponents.elaborateComponants.gameProposal.PresentationGameProposal;
import com.pierrickmonchoix.memoryclient.graphicComponents.forJson.GameManagerForJson;
import com.pierrickmonchoix.memoryclient.graphicComponents.forJson.ShownGameForJson;
import com.pierrickmonchoix.memoryclient.websocket.IWebsocketListener;
import com.pierrickmonchoix.memoryclient.websocket.WebsocketClientHelper;
import com.pierrickmonchoix.memoryclient.websocket.websocketMessage.EMessageType;
import com.pierrickmonchoix.memoryclient.websocket.websocketMessage.WebsocketMessage;

public class ModelGamesProposals implements IWebsocketListener {

    private static Logger logger = Logger.getLogger(ModelGamesProposals.class.getName());

    private final PresentationGamesProposals presentationGamesProposals;

    private List<ModelGameProposal> listModelGameProposals;

    public ModelGamesProposals(PresentationGamesProposals presentationGamesProposals) {
        this.presentationGamesProposals = presentationGamesProposals;

        listModelGameProposals = new ArrayList<ModelGameProposal>();

        WebsocketClientHelper.addListener(this);
    }

    @Override
    public void whenReceiveWebsocketMessage(WebsocketMessage message) {
        if (message.getType() == EMessageType.UPDATE_LIST_GAMES) {
            logger.info("msg recu par ws");
            logger.info("message recu pour games proposals: " + message.getContenu());
            GameManagerForJson gameManagerForJson = GameManagerForJson.fromJson(message.getContenu());
            updateList(gameManagerForJson);
            /*
             * for (ShownGameForJson shownGameForJson : listGameManagerForJsons) { String
             * pseudoHost = shownGameForJson.pseudoHost; logger.info("ajout new game");
             * 
             * }
             */

        }
    }

    /**
     * 
     * permet d'upadate le composant avec une liste des parties provenant du server
     */
    public void updateList(GameManagerForJson gameManagerForJson) {
        List<PresentationGameProposal> listPresentationsGameProposal = presentationGamesProposals
                .getListPresentationsGameProposal();
        listPresentationsGameProposal.clear(); // clear la liste des presentations

        clearModelList(); // clear la liste des modeles

        List<ShownGameForJson> listGameManagerForJsons = gameManagerForJson.listJsonGames;
        for (ShownGameForJson shownGameForJson : listGameManagerForJsons) {
            if (!shownGameForJson.started) {

                String numberPlayer = shownGameForJson.numberPlayer + "/" + shownGameForJson.maxPlayer;

                // ajout d'une presentation
                PresentationGameProposal presentationGameProposal = new PresentationGameProposal(
                        shownGameForJson.pseudoHost, numberPlayer);
                listPresentationsGameProposal.add(presentationGameProposal);
                

                // ajout d'un modele
                ModelGameProposal modelGameProposal = new ModelGameProposal(presentationGameProposal);
                listModelGameProposals.add(modelGameProposal);
            }
        }
        presentationGamesProposals.updateVue();
        for (PresentationGameProposal presentationGameProposal : listPresentationsGameProposal) {
            updatePresentationIfImInGame(presentationGameProposal, gameManagerForJson);
        }
        
        
    }

    private void clearModelList() {
        for (ModelGameProposal modelGameProposal : listModelGameProposals) {
            modelGameProposal.unActive();
        }
        listModelGameProposals.clear();
    }

    private void updatePresentationIfImInGame(PresentationGameProposal presentationGameProposal , GameManagerForJson gameManagerForJson){
        boolean imInGame = imInGame(gameManagerForJson);
        presentationGameProposal.setAnableButton( ! imInGame);
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
