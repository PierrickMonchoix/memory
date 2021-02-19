package com.pierrickmonchoix.memoryclient.graphicComponents.basicComponants.button;




import java.util.logging.Logger;

import com.pierrickmonchoix.memoryclient.graphicComponents.superclasses.EChildEvent;
import com.pierrickmonchoix.memoryclient.graphicComponents.superclasses.PresentationNotifier;

public class PresentationButton extends PresentationNotifier {

    private static Logger logger = Logger.getLogger(PresentationButton.class.getName());

    public String text;
    public String color;
    public boolean enable;

    public PresentationButton(String text) {
        super(EChildEvent.BUTTON_PRESSED);
        this.text = text;
        enable = true;
    }

    public String getText() {
        return text;
    }

    public void setUpText(String text) {
        this.text = text;
        updateVue();
    }

    public void alertPressed() {
        notifyParent();
    }

    public String getColor() {
        return color;
    }

    public void setUpColor(String color) {
        this.color = color;
        updateVue();
    }

    public boolean isEnable() {
        return this.enable;
    }

    public void setUpEnable(boolean enable) {
        logger.info("button vue : " + vue );
        this.enable = enable;
        updateVue();
    }








    





}
