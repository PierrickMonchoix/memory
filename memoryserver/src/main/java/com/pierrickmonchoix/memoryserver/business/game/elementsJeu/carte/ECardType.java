package com.pierrickmonchoix.memoryserver.business.game.elementsJeu.carte;

import java.util.logging.Logger;

/**
 * Valeur d'une carte
 */
public enum ECardType {

    UN, DEUX, TROIS, QUATRE, CINQ, SIX;

    private static Logger logger = Logger.getLogger(ECardType.class.getName());

    public static String getString(ECardType type) {
        switch (type) {
            case UN:
                return "UN";
            case DEUX:
                return "DEUX";
            case TROIS:
                return "TROIS";
            case QUATRE:
                return "QUATRE";
            case CINQ:
                return "CINQ";
            case SIX:
                return "SIX";
            default:
                logger.warning("erreur de syntaxe");
                return null;
        }
    }

    public static ECardType getType(String string) {
        if (string.equals("UN")) {
            return UN;
        } else if (string.equals("DEUX")) {
            return DEUX;
        } else if (string.equals("TROIS")) {
            return TROIS;
        } else if (string.equals("QUATRE")) {
            return QUATRE;
        } else if (string.equals("CINQ")) {
            return CINQ;
        } else if (string.equals("SIX")) {
            return SIX;
        }
        logger.warning("erreur de syntaxe");
        return null;

    }
}
