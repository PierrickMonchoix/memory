package com.pierrickmonchoix.memoryserver.business;

import java.util.logging.Logger;

import com.pierrickmonchoix.memoryserver.dao.FactoryDao;
import com.pierrickmonchoix.memoryserver.websocket.WebsocketServerHelper;
import com.pierrickmonchoix.memoryserver.websocket.websocketServer.WebsocketServerLauncher;


public class App {
    private static Logger logger = Logger.getLogger(App.class.getName());

    public static void main(String[] args) {

        //FactoryDao.resetDatabase();



        WebsocketServerHelper.launchWebsocketServer();


/*         logger.info("debut apptest");

        

        FactoryDao.createPersonne(new Personne("pubelle"));

        FactoryDao.resetDatabase();

        FactoryDao.createPersonne(new Personne("yolooo"));
        FactoryDao.resetDatabase();

        FactoryDao.createPersonne(new Personne("yo 1"));
        FactoryDao.createPersonne(new Personne("yo 2"));
     //   FactoryDao.createPersonne(new Personne("mikaso")); 
        logger.info(FactoryDao.getAllPersonne().toString());
        
 
        System.out.println( FactoryDao.isExisting(new Personne("yo 2")) );
        System.out.println( FactoryDao.isExisting(new Personne("mikasa")) );
        System.out.println( FactoryDao.isExisting(new Personne("armin")) );
        System.out.println( FactoryDao.isExisting(new Personne("jolijesu")) );  */ 
 
    }
    
}
