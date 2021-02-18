package com.pierrickmonchoix.memoryclient.graphicComponents.basicComponants.image;

import com.pierrickmonchoix.memoryclient.graphicComponents.IVue;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class VueImage extends ImageView implements IVue{

    private PresentationImage presentationImage;

    private Image image;
    


    public VueImage(PresentationImage presentationImage) {
        super();
        this.presentationImage = presentationImage;

        image = new Image(this.getClass().getResourceAsStream("/vide.png"));
        

        setPickOnBounds(true);
		setFitWidth(100);
		setFitWidth(100);
		setOnMouseClicked((MouseEvent e) -> {
			System.out.println("Clicked!"); // change functionality
			presentationImage.onClick();
		});

        update();
    }

    @Override
    public void update() {
        image = new Image(this.getClass().getResourceAsStream(presentationImage.getPathImage()));
        setImage(image);
    }
    
    
}
