package com.pierrickmonchoix.memoryclient.graphicComponents.elaborateComponants.card;

import java.util.logging.Logger;

import com.pierrickmonchoix.memoryclient.graphicComponents.basicComponants.image.PresentationImage;
import com.pierrickmonchoix.memoryclient.graphicComponents.basicComponants.image.VueImage;
import com.pierrickmonchoix.memoryclient.graphicComponents.superclasses.EChildEvent;
import com.pierrickmonchoix.memoryclient.graphicComponents.superclasses.IChildenListener;
import com.pierrickmonchoix.memoryclient.graphicComponents.superclasses.PresentationNotifier;

public class PresentationCard extends PresentationNotifier implements IChildenListener {

    private final PresentationImage presentationImage;

    private final String pathCardImage; // on us epas de update vue pour ca
    private final String pathMystereImage = "/mystere.png";

    private final int x;
    private final int y;

    private static Logger logger = Logger.getLogger(PresentationImage.class.getName());

    public PresentationCard(String pathCardImage, int x, int y , boolean revealed) {
        super(EChildEvent.DRAW_CARD);


        this.pathCardImage = pathCardImage;
        this.x = x;
        this.y = y;

        presentationImage = new PresentationImage(pathMystereImage);
        VueImage vueImage = new VueImage(presentationImage);
        presentationImage.setVue(vueImage);

        setReveal(revealed);

        listenAllChildren();

    }

    @Override
    public void listenAllChildren() {
        presentationImage.attributeParentListener(this);

    }

    @Override
    public void whenNotifiedByChild(EChildEvent typeEvent) {
        if(typeEvent == EChildEvent.IMAGE_CLICKED){
            notifyParent();
        }
        else{
            logger.info("mon mes enfants m'ont mal notifié");
        }
    }


    // GETTERS des presentations for vue

    public PresentationImage getPresentationImage() {
        return this.presentationImage;
    }

    // SETTER

    public void setPathImage(String pathImage) {
        presentationImage.setUpPath(pathImage);
    }

    public void setReveal(boolean reveal) {
        if (reveal) {
            if (pathCardImage != null) {
                presentationImage.setUpPath(pathCardImage);
            }
            else{
                logger.warning("la path de l'image n'as pas ete initialisée");
            }
        } else {
            presentationImage.setUpPath(pathMystereImage);
        }
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }




    
}
