package com.pierrickmonchoix.memoryclient.graphicComponents.basicComponants.image;

import java.util.logging.Logger;

import com.pierrickmonchoix.memoryclient.graphicComponents.superclasses.IVue;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class VueImage extends ImageView implements IVue{

    private static Logger logger = Logger.getLogger(ImageView.class.getName());

    private PresentationImage presentationImage;

    private Image image;
    


    public VueImage(PresentationImage presentationImage) {
        super();
        this.presentationImage = presentationImage;

        image = new Image(this.getClass().getResourceAsStream("/croix.png"));
        

        setPickOnBounds(true);
		setFitWidth(100);
		setFitHeight(250);
		setOnMouseClicked((MouseEvent e) -> {
			System.out.println("Clicked!"); // change functionality
			presentationImage.onClick();
		});

        updateFromPresentation();
    }

    @Override
    public void updateFromPresentation() {
        logger.info("");
        image = new Image(this.getClass().getResourceAsStream(presentationImage.getPathImage()));
        setImage(image);
    }
    
    
}
