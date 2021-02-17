package com.pierrickmonchoix.memoryserver.websocket.websocketMessage;

/**
 * les types de messages que peucent s'echanger le serveur et les clients
 * cette classe est aussi connue par les clients
 */
public enum EMessageType {
    /**
     * client > server :
     * j'essaie de me connecter avec ce pseudo (contenu)
     * 
     * server > client :
     * validation ou non de ce pseudo
     * 
     */
    SIGN_IN,



    /**
     * client > server :
     * j'essaie de me connecter pour la premiere fois avec ce pseudo (contenu)
     * 
     * server > client :
     * validation ou non de ce pseudo
     * 
     */
    SIGN_UP,

    /**
     * server > client :
     * demande de tirage de premiere la carte
     * 
     * client > server :
     * resluat de la premiere carte
     * 
     */
    DRAW_FIRST_CARD,

    /**
     * server > client :
     * demande de tirage de seconde la carte
     * 
     * client > server :
     * resluat de la seconde carte
     * 
     */
    DRAW_SECOND_CARD,

    /**
     * server > client :
     * on montre les cartes reveles au client
     * 
     * client > server :
     * le client confirme qu'il a eu le temps de voir les cartes
     * 
     */
    SHOW_CARD,



    /**
     * 
     * 
     */
    DRAW_FAILURE,

    /**
     * 
     * 
     */
    DRAW_SUCCESS,

    /**
     * 
     * 
     */
    WINNER;

    



}
