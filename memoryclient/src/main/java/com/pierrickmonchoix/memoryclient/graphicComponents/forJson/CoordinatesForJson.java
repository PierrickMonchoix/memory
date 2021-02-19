package com.pierrickmonchoix.memoryclient.graphicComponents.forJson;

import com.google.gson.Gson;

public class CoordinatesForJson {

    public static Gson gson = new Gson();

    public int x;
    public int y;

    public static CoordinatesForJson fromJson(String string){
        return gson.fromJson(string, CoordinatesForJson.class);
    }

    public String toJson(){
        return gson.toJson(this);
    }

}
