package com.pierrickmonchoix.memoryserver.business;

import java.util.logging.Logger;

import com.pierrickmonchoix.memoryserver.dao.FactoryDao;


public class App {
    private static Logger logger = Logger.getLogger(App.class.getName());

    public static void main(String[] args) {
        logger.info("debut apptest");
        FactoryDao.createPersonne(new Personne("pubelle"));
        
        FactoryDao.deletePersonne(new Personne("pubelle"));
        FactoryDao.createPersonne(new Personne("armin"));
     //   FactoryDao.createPersonne(new Personne("mikaso")); 
        logger.info(FactoryDao.getAllPersonne().toString());
        
 
        System.out.println( FactoryDao.isExisting(new Personne("eren")) );
        System.out.println( FactoryDao.isExisting(new Personne("mikasa")) );
        System.out.println( FactoryDao.isExisting(new Personne("armin")) );
        System.out.println( FactoryDao.isExisting(new Personne("jolijesu")) );  
 
    }
    
}
