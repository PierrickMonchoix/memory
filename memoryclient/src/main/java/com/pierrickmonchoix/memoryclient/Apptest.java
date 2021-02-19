package com.pierrickmonchoix.memoryclient;

import java.util.logging.Logger;

public class Apptest {
    static String  card;

    private static Logger logger = Logger.getLogger(Apptest.class.getName());



    public static void main(String[] args) {
        
        logger.info(card);

        Presentation2 presentation = new Presentation2();
        System.out.println( presentation.vue.couleurShow);

    }

}
