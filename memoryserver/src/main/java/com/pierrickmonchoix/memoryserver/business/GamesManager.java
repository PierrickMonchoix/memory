package com.pierrickmonchoix.memoryserver.business;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import com.pierrickmonchoix.memoryserver.business.game.Game;
import com.pierrickmonchoix.memoryserver.websocket.IWebsocketListener;
import com.pierrickmonchoix.memoryserver.websocket.WebsocketServerHelper;
import com.pierrickmonchoix.memoryserver.websocket.websocketMessage.EMessageType;
import com.pierrickmonchoix.memoryserver.websocket.websocketMessage.WebsocketMessage;

public class GamesManager implements IWebsocketListener {

    private static Logger logger = Logger.getLogger(GamesManager.class.getName());

    private final List<Game> listGames = new ArrayList<Game>();



    private static GamesManager instance;

    private GamesManager(){
        WebsocketServerHelper.addListener(this);
    }


    public static GamesManager getInstance() {
        if(instance == null){
            instance = new GamesManager();
        }
        return instance;
    }

    public void createGameOfHostPlayerPseudo(String pseudo) {
        Player hostPlayer = PlayersManager.getInstance().getPlayerFromPseudo(pseudo);
        createGameOfHostPlayer(hostPlayer);
    }

    private  void createGameOfHostPlayer(Player hostPlayer) {
        Game newGame = new Game(hostPlayer);
        listGames.add(newGame);
    }

    // APPELE PAR LES GAME ENGINE
    public void removeGame(Game game) {
        listGames.remove(game);
    }

    public void removeGameOfHostPseudo(String pseudo){
        listGames.removeIf(g -> (g.getHostPlayer().getPseudo().equals(pseudo) ));
    }


    public void addPlayerToGame(String hostPlayerPseudo, String playerPseudo) {
        Game game = getGameOfHost(hostPlayerPseudo);
        game.addPlayer(playerPseudo);
    }

    private Game getGameOfHost(String hostPlayerPseudo) {
        for (Game game : listGames) {
            if (game.getHostPlayer().getPseudo().equals(hostPlayerPseudo)) { // pseudo des hostPlayers
                return game;
            }
        }
        logger.warning("pas de partie avec ce joueur trouvée...");
        return null;
    }

    public List<Game> getListGames() {
        return listGames;
    }

    public String getJson() {
        GameManagerForJson gameManagerForJson = new GameManagerForJson();
        return gameManagerForJson.toJson();
    }

    @Override
    public void whenReceiveWebsocketMessage(WebsocketMessage message) {
        if(message.getType() == EMessageType.CREATE_GAME){
            logger.info("le client : " + message.getPseudo() + " me demande de creer une partie");
            createGameOfHostPlayerPseudo(message.getPseudo());
            sendMessgeToUpdateListGamesToEveryPlayer();
        }
    } //: every one

    public void sendMessgeToUpdateListGamesToEveryPlayer() {
        WebsocketMessage messageUpdateListGames = new WebsocketMessage();
        messageUpdateListGames.setType(EMessageType.UPDATE_LIST_GAMES);
        messageUpdateListGames.setContenu(getInstance().getJson());
        WebsocketServerHelper.sendMessageToEveryPlayer(messageUpdateListGames);
    }

}
