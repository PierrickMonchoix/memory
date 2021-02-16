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
    FIRST_CARD,

    /**
     * server > client :
     * demande de tirage de seconde la carte
     * 
     * client > server :
     * resluat de la seconde carte
     * 
     */
    SECOND_CARD,

    /**
     * server > client :
     * le client a trouve une paire
     * 
     * client > server :
     * ?
     * 
     */
    PAIR_FOUND;




}
