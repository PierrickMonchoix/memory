package com.pierrickmonchoix.memoryclient.graphicComponents.basicComponants.comboBox;


import android.content.Context;
import android.widget.ArrayAdapter;

import androidx.appcompat.widget.AppCompatSpinner;

import java.util.List;

import com.pierrickmonchoix.memoryclient.ContextHelper;
import com.pierrickmonchoix.memoryclient.graphicComponents.superclasses.IVue;


public class VueComboBox extends AppCompatSpinner implements IVue{

    private final PresentationComboBox presentationComboBox; 

    private Context context;

    public VueComboBox(PresentationComboBox presentationComboBox) {
        super(ContextHelper.getContext());
        this.presentationComboBox = presentationComboBox;

        this.context = ContextHelper.getContext();

        updateFromPresentation();
    }



    @Override
    public void updateFromPresentation() {

        List<String> listProposal = presentationComboBox.getListProposals();

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(context, android.R.layout.simple_spinner_item, listProposal);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        setAdapter(dataAdapter);

    }

    public String getChoice(){
        return getSelectedItem().toString();
    }


    
}
