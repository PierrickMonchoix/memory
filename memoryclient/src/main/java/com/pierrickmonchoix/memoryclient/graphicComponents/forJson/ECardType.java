package com.pierrickmonchoix.memoryclient.graphicComponents.forJson;

import java.util.logging.Logger;

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

    public static String toImagePath(ECardType type){
        switch (type) {
            case UN:
                return "/un.png";
            case DEUX:
                return "/deux.png";
            case TROIS:
                return "/trois.png";
            case QUATRE:
                return "/quatre.png";
            case CINQ:
                return "/cinq.png";
            case SIX:
                return "/six.png";
            default:
                logger.warning("erreur de syntaxe");
                return null;
        }
    }


}
