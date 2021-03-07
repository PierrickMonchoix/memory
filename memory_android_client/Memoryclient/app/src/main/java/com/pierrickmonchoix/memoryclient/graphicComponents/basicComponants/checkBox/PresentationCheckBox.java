package com.pierrickmonchoix.memoryclient.graphicComponents.basicComponants.checkBox;

import com.pierrickmonchoix.memoryclient.graphicComponents.superclasses.EChildEvent;
import com.pierrickmonchoix.memoryclient.graphicComponents.superclasses.PresentationNotifier;



public class PresentationCheckBox extends PresentationNotifier {


    private final String text;
    private final boolean defaultCheck;




    public PresentationCheckBox(String text , boolean defaultCheck ) {
        super(EChildEvent.CHECK_BOX_CHECKED);
        this.text = text;
        this.defaultCheck = defaultCheck;


    }

    public String getText() {
        return text;
    }

    public boolean isDefaultChecked() {
        return defaultCheck;
    }

    public boolean isChecked(){
        VueCheckBox vueCheckBox = (VueCheckBox)vue;
        return vueCheckBox.isCheckedInput();
    }



    public void alertChecked(){
        notifyParent();
    }






    



    
    
}
