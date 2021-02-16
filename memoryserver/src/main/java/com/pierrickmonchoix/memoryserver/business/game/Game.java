package com.pierrickmonchoix.memoryserver.business.game;

import java.util.ArrayList;
import java.util.List;

import com.pierrickmonchoix.memoryserver.business.Player;
import com.pierrickmonchoix.memoryserver.business.PlayersManager;
import com.pierrickmonchoix.memoryserver.business.game.elementJeu.Board;

public class Game {
    private Board board;
    private List<Player> listPlayers;
    private final int maxPlayer = 3;

    /** 
    *quand on appuie sur le bouton creer partie (pas lancée!)
    */
    public Game() {
        listPlayers = new ArrayList<Player>();
    }

    public void addPlayer(Player player){
        listPlayers.add(player);
        if(listPlayers.size() == maxPlayer){
            startGame();
        }
    }

    public void addPlayer(String pseudo){
        Player player = PlayersManager.getPlayerFromPseudo(pseudo);
        addPlayer(player);
    }


    


    /**
     * quand il y a suffisement de joueurs
     */
    public void startGame(){
        board = new Board();
        //send msg to players
    }

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

    


}
