package com.pierrickmonchoix.memoryclient.graphicComponents.basicComponants.button;

public enum EButtonColorForView {

    VERT;

    public static String getString(EButtonColorForView type) {
        switch (type) {
            case VERT:
                return "#3F7";
            default:
                return null;
        }
    }
}
