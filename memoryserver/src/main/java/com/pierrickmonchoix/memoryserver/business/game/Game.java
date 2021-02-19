package com.pierrickmonchoix.memoryserver.business.game;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import com.google.gson.Gson;
import com.pierrickmonchoix.memoryserver.business.Player;
import com.pierrickmonchoix.memoryserver.business.PlayersManager;
import com.pierrickmonchoix.memoryserver.business.game.elementsJeu.Board;
import com.pierrickmonchoix.memoryserver.business.game.gameEngine.GameEngine;

public class Game {
    private static Logger logger = Logger.getLogger(Game.class.getName());

    private final Player hostPlayer;

    private Board board;
    private List<Player> listPlayers;
    private static final int maxPlayer = 3;
    private Player actualPlayer;

    private Player winner;

    private GameEngine gameEngine;

    private boolean started;

    private static Gson gson = new Gson();

    /**
     * quand on appuie sur le bouton creer partie (pas lancée!)
     */
    public Game(Player hostPlayer) {
        started = false;
        listPlayers = new ArrayList<Player>();
        this.hostPlayer = hostPlayer;
        listPlayers.add(hostPlayer);
    }

    // AJOUT D'UN JOUEUR QUI PEUT FAIRE START LA GAME
    private void start() {
        started = true;
        logger.info("La partie de " + hostPlayer.getPseudo() + " commence!");
/* //TOCHANGE
        board = new Board();
        setActualPlayer(listPlayers.get(0));
         logger.info("La partie de " + hostPlayer.getPseudo() + " ressemble a ca : \n" + toJson());
        gameEngine = new GameEngine(this);
        gameEngine.start();  */
    }

    // PUBLIC AJOUT D'UN JOUEUR
    public void addPlayer(String pseudo) {
        Player player = PlayersManager.getInstance().getPlayerFromPseudo(pseudo);
        addPlayer(player);
    }

    private void addPlayer(Player player) {
        if (listPlayers.size() < maxPlayer) {
            player.setPoints(0);
            listPlayers.add(player);
            if (listPlayers.size() == maxPlayer) {
                start();
            }
        } else {
            logger.warning("nombre de joueur max attein dans la game de  : " + hostPlayer.getPseudo());
        }

    }

    // GETTER ET SETTER FOR GSON
    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public List<Player> getListPlayers() {
        return listPlayers;
    }

    public void setListPlayers(List<Player> listPlayers) {
        this.listPlayers = listPlayers;
    }

    public int getMaxPlayer() {
        return maxPlayer;
    }

    public Player getActualPlayer() {
        return this.actualPlayer;
    }

    public void setActualPlayer(Player actualPlayer) {
        this.actualPlayer = actualPlayer;
    }

    public Player getWinner() {
        return this.winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public Player getHostPlayer() {
        return this.hostPlayer;
    }
    public boolean isStarted() {
        return started;
    }

    public void setStarted(boolean started) {
        this.started = started;
    }

    

    // GSON FUNCTIONS
    public static Game fromJson(String string) {
        return gson.fromJson(string, Game.class);
    }

    public String toJson() {
        return gson.toJson(this);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((hostPlayer == null) ? 0 : hostPlayer.hashCode());
        return result;
    }

    // CHECK HOSTPLAYER
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Game other = (Game) obj;
        if (hostPlayer == null) {
            if (other.hostPlayer != null)
                return false;
        } else if (!hostPlayer.equals(other.hostPlayer))
            return false;
        return true;
    }



}
