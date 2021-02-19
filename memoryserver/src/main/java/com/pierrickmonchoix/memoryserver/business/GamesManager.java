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

    // PATTERN SINGLETON

    public static GamesManager getInstance() {
        if (instance == null) {
            instance = new GamesManager();
        }
        return instance;
    }

    private GamesManager() {
        WebsocketServerHelper.addListener(this);
    }

    // GESTION DE LA REQUETE CREATION DE GAME
    @Override
    public void whenReceiveWebsocketMessage(WebsocketMessage message) {
        switch (message.getType()) {
            case CREATE_GAME:
                logger.info("msg recu par ws");
                treatCreateGameMessage(message);
                break;
            case JOIN_GAME:
                logger.info("msg recu par ws");
                treatJoinGameMessage(message);
                break;
            default:
                break;
        }
    }

    private void treatJoinGameMessage(WebsocketMessage message) {
        logger.info("le client : " + message.getPseudo() + " me demande de joindre une partie");
        String hostPseudo = message.getContenu();
        String joinnerPseudo = message.getPseudo();
        if (isThereGameOf(hostPseudo)) {
            makeJoinnerEnterInHostGame(joinnerPseudo, hostPseudo);
            sendMessgeToUpdateListGamesToEveryPlayer();
        } else {
            logger.warning("cette partie n'existe pas : " + hostPseudo);
        }
    }

    private void treatCreateGameMessage(WebsocketMessage message) {
        logger.info("le client : " + message.getPseudo() + " me demande de creer une partie");
        if (!isThereGameOf(message.getPseudo())) {
            createGameOfHostPlayerPseudo(message.getPseudo());
            sendMessgeToUpdateListGamesToEveryPlayer();
        }
    }

    private void sendMessgeToUpdateListGamesToEveryPlayer() {
        WebsocketMessage messageUpdateListGames = new WebsocketMessage();
        messageUpdateListGames.setType(EMessageType.UPDATE_LIST_GAMES);
        messageUpdateListGames.setContenu(getInstance().getJson());
        WebsocketServerHelper.sendMessageToEveryPlayer(messageUpdateListGames);
    }

    private void createGameOfHostPlayerPseudo(String pseudo) {
        if (!isThereGameOf(pseudo)) {
            Player hostPlayer = PlayersManager.getInstance().getPlayerFromPseudo(pseudo);
            Game newGame = new Game(hostPlayer);
            listGames.add(newGame);
        } else { // on est pas sensé arriveer la, la secu s'est deja faite avant
            logger.warning("une partie avec cet host existe deja : " + pseudo);
        }
    }

    private void makeJoinnerEnterInHostGame(String joinnerPseudo, String hostPseudo) {
        if (isThereGameOf(hostPseudo)) {
            Game game = getGameOfHost(hostPseudo);
            game.addPlayer(joinnerPseudo);
        } else {
            logger.warning("aucune partie de ce nom n'exite : " + hostPseudo);
        }
    }

    private boolean isThereGameOf(String pseudo) {
        for (Game game : listGames) {
            if (game.getHostPlayer().getPseudo().equals(pseudo)) {
                return true;
            }
        }
        return false;
    }

    // APPELE PAR LES GAME ENGINE
    public void removeGame(Game game) {
        listGames.remove(game);
    }

    // APPELE PAR OnCLose session
    public void removeGameOfHostPseudo(String pseudo) {
        listGames.removeIf(g -> (g.getHostPlayer().getPseudo().equals(pseudo)));
    }

    // va bientot etre utilse
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

    // FOR JSON
    public List<Game> getListGames() {
        return listGames;
    }

    // UTILE POUR DES UPDATES LIST
    public String getJson() {
        GameManagerForJson gameManagerForJson = new GameManagerForJson();
        return gameManagerForJson.toJson();
    }

}
