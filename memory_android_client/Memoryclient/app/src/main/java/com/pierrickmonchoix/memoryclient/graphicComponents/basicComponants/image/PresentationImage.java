package com.pierrickmonchoix.memoryclient.graphicComponents.basicComponants.image;

import com.pierrickmonchoix.memoryclient.graphicComponents.superclasses.EChildEvent;
import com.pierrickmonchoix.memoryclient.graphicComponents.superclasses.PresentationNotifier;

public class PresentationImage extends PresentationNotifier {

    private String pathImage;


    public PresentationImage(String path) {
        super(EChildEvent.IMAGE_CLICKED);
        pathImage = path;
    }

    public void setUpPath(String path){
        pathImage = path;
        updateVue();
    }

    public void onClick(){
        notifyParent();
    }

    public String getPathImage() {
        return pathImage;
    }



    




    
}
