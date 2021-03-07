package com.pierrickmonchoix.memoryclient;

import android.content.Context;

public class ContextHelper {
    private static Context context;

    public static Context getContext() {
        return context;
    }

    public static void setContext(Context context) {
        ContextHelper.context = context;
    }
}
