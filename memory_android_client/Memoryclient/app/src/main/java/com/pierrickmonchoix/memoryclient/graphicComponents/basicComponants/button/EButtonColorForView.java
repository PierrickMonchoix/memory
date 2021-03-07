package com.pierrickmonchoix.memoryclient.graphicComponents.basicComponants.button;

public enum EButtonColorForView {

    VERT;

    public static String getString(EButtonColorForView ecolor) {
        switch (ecolor) {
            case VERT:
                return "#33FF77";
            default:
                return null;
        }
    }
}
