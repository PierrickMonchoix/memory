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


       

        PlayersManager.addNewPlayerWithPseudo("jack");
        PlayersManager.addNewPlayerWithPseudo("queen");
        PlayersManager.addNewPlayerWithPseudo("king");
        PlayersManager.addNewPlayerWithPseudo("luffy");
        PlayersManager.addNewPlayerWithPseudo("sanji");
        PlayersManager.addNewPlayerWithPseudo("zoro");

        GamesManager.createGameOfHostPlayerPseudo("jack");
        GamesManager.createGameOfHostPlayerPseudo("queen");

        GamesManager.addPlayerToGame("jack" , "luffy");
      //  GamesManager.addPlayerToGame("jack", "zoro");


        System.out.println("la GamesManager: \n" + GamesManager.getJson() );





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
