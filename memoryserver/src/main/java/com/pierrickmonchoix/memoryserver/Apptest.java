package com.pierrickmonchoix.memoryserver;

import java.util.logging.Logger;

import com.pierrickmonchoix.memoryserver.business.GameManagerForJson;
import com.pierrickmonchoix.memoryserver.business.GamesManager;
import com.pierrickmonchoix.memoryserver.business.Player;
import com.pierrickmonchoix.memoryserver.business.PlayersManager;
import com.pierrickmonchoix.memoryserver.business.game.Game;

public class Apptest {
    private static Logger logger = Logger.getLogger(Apptest.class.getName());

    public static void main(String[] args) {


       
/* 
        PlayersManager.getInstance().addNewPlayerWithPseudo("jack");
        PlayersManager.getInstance().addNewPlayerWithPseudo("queen");
        PlayersManager.getInstance().addNewPlayerWithPseudo("king");
        PlayersManager.getInstance().addNewPlayerWithPseudo("luffy");
        PlayersManager.getInstance().addNewPlayerWithPseudo("sanji");
        PlayersManager.getInstance().addNewPlayerWithPseudo("zoro");

        GamesManager.getInstance().createGameOfHostPlayerPseudo("jack");
        GamesManager.getInstance().createGameOfHostPlayerPseudo("queen");

        GamesManager.getInstance().addPlayerToGame("jack" , "luffy");
      //  GamesManager.addPlayerToGame("jack", "zoro");


        System.out.println("la GamesManager: \n" + GamesManager.getInstance().getJson() );


 */


        // FactoryDao.resetDatabase();

        //WebsocketServerHelper.launchWebsocketServer();

        /*
         * logger.info("debut apptest");
         * 
         * 
         * 
         * FactoryDao.createPersonne(new Personne("pubelle"));
         * 
         * FactoryDao.resetDatabase();
         * 
         * FactoryDao.createPersonne(new Personne("yolooo"));
         * FactoryDao.resetDatabase();
         * 
         * FactoryDao.createPersonne(new Personne("yo 1"));
         * FactoryDao.createPersonne(new Personne("yo 2")); //
         * FactoryDao.createPersonne(new Personne("mikaso"));
         * logger.info(FactoryDao.getAllPersonne().toString());
         * 
         * 
         * System.out.println( FactoryDao.isExisting(new Personne("yo 2")) );
         * System.out.println( FactoryDao.isExisting(new Personne("mikasa")) );
         * System.out.println( FactoryDao.isExisting(new Personne("armin")) );
         * System.out.println( FactoryDao.isExisting(new Personne("jolijesu")) );
         */

    }

}
