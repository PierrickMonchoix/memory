package com.pierrickmonchoix.memoryclient.websocket.websocketMessage;

/**
 * les types de messages que peucent s'echanger le serveur et les clients cette
 * classe est aussi connue par les clients
 */
public enum EMessageType {
    /**
     * client > server : j'essaie de me connecter avec ce pseudo (contenu)
     * 
     * server > client : validation ou non de ce pseudo
     * 
     */
    SIGN_IN,

    /**
     * client > server : j'essaie de me connecter pour la premiere fois avec ce
     * pseudo (contenu)
     * 
     * server > client : validation ou non de ce pseudo
     * 
     */
    SIGN_UP,

    /**
     * server > client : demande de tirage de premiere la carte
     * 
     * client > server : rien
     * 
     */
    DRAW_FIRST_CARD,

    /**
     * server > client : demande de tirage de seconde la carte
     * 
     * client > server : rien
     * 
     */
    DRAW_SECOND_CARD,

    /**
     * 
     * 
     * client > server : j'ai tiré une carte,
     * débrouille toi pour savoir si 1ere ou 2 eme
     * 
     * 
     */
    DRAW_CARD,

    

    /**
     * server > client : on montre les cartes reveles au client
     * 
     * client > server : le client confirme qu'il a eu le temps de voir les cartes
     * 
     */
    SHOW_CARD,

    /**
     * server > client : tu a echoué pour le tirage de la paire
     */
    DRAW_FAILURE,

    /**
     * server > client : tu as reussi pour le tirage de la paire
     */
    DRAW_SUCCESS,

    /**
     * server > client : tu as gagné
     * 
     */
    WINNER,

    /**
     * server > client : met a jour ta liste de parties a partir de ce que je
     * t'envoie
     * 
     */
    UPDATE_LIST_GAMES,

    /**
     * client > server je veux cree une game
     */
    CREATE_GAME,

    /**
     * 
     * client > server
     *  je veux joindre une game
     * 
     * 
     * 
     */
    JOIN_GAME

    ;

}
