package com.pierrickmonchoix.memoryclient.graphicComponents.basicComponants.image;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.widget.AppCompatImageView;

import java.util.logging.Logger;

import com.pierrickmonchoix.memoryclient.ContextHelper;
import com.pierrickmonchoix.memoryclient.graphicComponents.superclasses.IVue;


public class VueImage extends AppCompatImageView implements IVue{

    private static Logger logger = Logger.getLogger(ImageView.class.getName());

    private PresentationImage presentationImage;

    private Context context;


    public VueImage(PresentationImage presentationImage) {
        super(ContextHelper.getContext());
        this.presentationImage = presentationImage;

        this.context = ContextHelper.getContext();

        setMaxWidth(100);
        setMaxHeight(250);


        setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                System.out.println("Clicked!"); // change functionality
                presentationImage.onClick();
            }
        });

        updateFromPresentation();
    }

    @Override
    public void updateFromPresentation() {
        String pathImage = presentationImage.getPathImage();
        int drawableId = this.getResources().getIdentifier(pathImage, "drawable", context.getPackageName());
        setImageResource(drawableId);
    }
    
    
}
