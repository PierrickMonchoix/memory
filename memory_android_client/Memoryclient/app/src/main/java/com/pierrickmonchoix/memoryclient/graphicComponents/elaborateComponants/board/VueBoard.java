package com.pierrickmonchoix.memoryclient.graphicComponents.elaborateComponants.board;

import android.util.Log;
import android.widget.GridLayout;
import android.widget.RelativeLayout;

import java.util.List;
import java.util.logging.Logger;

import com.pierrickmonchoix.memoryclient.ContextHelper;
import com.pierrickmonchoix.memoryclient.graphicComponents.elaborateComponants.card.PresentationCard;
import com.pierrickmonchoix.memoryclient.graphicComponents.elaborateComponants.card.VueCard;
import com.pierrickmonchoix.memoryclient.graphicComponents.superclasses.IVue;




public class VueBoard extends RelativeLayout implements IVue {

    private static Logger logger = Logger.getLogger(VueBoard.class.getName());

    private final PresentationBoard presentationBoard;

    public VueBoard(PresentationBoard presentationBoard) {
        super(ContextHelper.getContext());
        this.presentationBoard = presentationBoard;

        updateFromPresentation();
    }

    @Override
    public void updateFromPresentation() {
        rebuildVues();
    }

    public void rebuildVues(){
        Log.i("rebuildVues" , "start" );
        removeAllViews();

        List<PresentationCard> listPresentationCards = presentationBoard.getListPresentationCards();

        for (PresentationCard presentationCard : listPresentationCards) {
            VueCard vueCard = (VueCard) presentationCard.getVue();
            
            int x = presentationCard.getX();
            int y = presentationCard.getY();

            RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(200,200);

            int trueX = 250*x;
            int trueY = 250*y;
            params.setMargins(trueX, trueY, 0, 0);

            vueCard.setLayoutParams(params);

            // on ne met pas reavlead ni pathCard car ne concernet pas palcement / delete /create

            logger.info("ajout image coord : " + x +" , "+ y);

            Log.i("rebuildVues" , "add card to coord : " + Integer.toString(x) + " " + Integer.toString(y) );

            addView(vueCard);  // x = column , y = row
        }
    }

}
