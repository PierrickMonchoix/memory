package com.pierrickmonchoix.memoryclient.websocket.websocketMessage;

public enum EMessageType {
    /*
     * client > server :
     * j'essaie de me connecter avec ce pseudo (contenu)
     * 
     * server > client :
     * validation ou non de ce pseudo
     * 
     */
    SIGN_IN

    /*
     * client > server :
     * j'essaie de me connecter pour la premiere fois avec ce pseudo (contenu)
     * 
     * server > client :
     * validation ou non de ce pseudo
     * 
     */
    , SIGN_UP;
}
