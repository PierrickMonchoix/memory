package com.pierrickmonchoix.memoryclient.graphicComponents.basicComponants.image;

import com.pierrickmonchoix.memoryclient.graphicComponents.basicComponants.EComponantBasicEvent;
import com.pierrickmonchoix.memoryclient.graphicComponents.basicComponants.PresentationNotifier;

public class PresentationImage extends PresentationNotifier {

    private String pathImage;


    public PresentationImage(String path) {
        super(EComponantBasicEvent.IMAGE_CLICKED);
        pathImage = path;
    }

    public void setPath(String path){
        pathImage = path;
        updateVue();
    }

    public void onClick(){
        notifyListeners();
    }

    public String getPathImage() {
        return pathImage;
    }



    




    
}
