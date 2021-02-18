package com.pierrickmonchoix.memoryclient.graphicComponents.elaborateComponants.card;

import java.util.logging.Logger;

import com.pierrickmonchoix.memoryclient.graphicComponents.Presentation;
import com.pierrickmonchoix.memoryclient.graphicComponents.basicComponants.IComponantListener;
import com.pierrickmonchoix.memoryclient.graphicComponents.basicComponants.image.PresentationImage;

public class PresentationCard extends Presentation{

    private final PresentationImage presentationImage;

    private String pathImage;
    private final String pathMystereImage = "/mystere";

    private final int x;
    private final int y;

    private static Logger logger = Logger.getLogger(PresentationImage.class.getName());


    public PresentationCard(int x, int y) {
        presentationImage = new PresentationImage(pathMystereImage);
        this.x = x;
        this.y = y;
    }

    public String getPathImage() {
        return this.pathImage;
    }

    public void setPathImage(String pathImage) {
        this.pathImage = pathImage;
    }

    public String getPathMystereImage() {
        return this.pathMystereImage;
    }


    public int getX() {
        return this.x;
    }


    public int getY() {
        return this.y;
    }




    public PresentationImage getPresentationImage() {
        return this.presentationImage;
    }


    public void setPath(String path){
        pathImage = path;
    }

    public void setReveal(boolean reveal){
        if(reveal){
            if(pathImage == null){
                logger.warning(("la path de l'image n'as pas ete initialisée"));
                presentationImage.setPath(pathImage);
            }
        }
        else{
            presentationImage.setPath(pathMystereImage);
        }
    }

    public void addImageListener(IComponantListener listener){
        presentationImage.addListener(listener);
    }






    
    
}
