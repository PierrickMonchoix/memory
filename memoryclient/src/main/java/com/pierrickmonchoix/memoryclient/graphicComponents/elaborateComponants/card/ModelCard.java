package com.pierrickmonchoix.memoryclient.graphicComponents.elaborateComponants.card;

import java.util.logging.Logger;

import com.pierrickmonchoix.memoryclient.graphicComponents.forJson.CoordinatesForJson;
import com.pierrickmonchoix.memoryclient.graphicComponents.superclasses.EChildEvent;
import com.pierrickmonchoix.memoryclient.graphicComponents.superclasses.IChildenListener;
import com.pierrickmonchoix.memoryclient.websocket.WebsocketClientHelper;
import com.pierrickmonchoix.memoryclient.websocket.websocketMessage.EMessageType;

public class ModelCard implements IChildenListener {

    private static Logger logger = Logger.getLogger(ModelCard.class.getName());

    private PresentationCard presentationCard;

    public ModelCard(PresentationCard presentationCard) {
        this.presentationCard = presentationCard;
        listenAllChildren();
    }

    @Override
    public void listenAllChildren() {
        presentationCard.attributeParentListener(this);

    }

    @Override
    public void whenNotifiedByChild(EChildEvent typeEvent) {
        if(typeEvent == EChildEvent.DRAW_CARD){
            CoordinatesForJson coordinatesForJson = new CoordinatesForJson();
            coordinatesForJson.x = presentationCard.getX();
            coordinatesForJson.y = presentationCard.getY();
            String jsonCoordinates = coordinatesForJson.toJson();
            WebsocketClientHelper.getInstance().sendMessageToServer(EMessageType.DRAW_CARD, jsonCoordinates);
        }
        else{
            logger.info("jai ete mal notifie par mes mon enfant");
        }

    }

    
}
