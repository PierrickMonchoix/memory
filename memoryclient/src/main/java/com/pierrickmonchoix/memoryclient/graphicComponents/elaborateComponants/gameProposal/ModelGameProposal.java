package com.pierrickmonchoix.memoryclient.graphicComponents.elaborateComponants.gameProposal;

import java.util.logging.Logger;

import com.pierrickmonchoix.memoryclient.graphicComponents.superclasses.EChildEvent;
import com.pierrickmonchoix.memoryclient.graphicComponents.superclasses.IChildenListener;
import com.pierrickmonchoix.memoryclient.websocket.WebsocketClientHelper;
import com.pierrickmonchoix.memoryclient.websocket.websocketMessage.EMessageType;

public class ModelGameProposal implements IChildenListener {


    private static Logger logger = Logger.getLogger(ModelGameProposal.class.getName());

    final PresentationGameProposal presentationGameProposal;

    public ModelGameProposal(PresentationGameProposal presentationGameProposal) {
        this.presentationGameProposal = presentationGameProposal;

        listenAllChildren();
    }

    @Override
    public void listenAllChildren() {
        presentationGameProposal.attributeParentListener(this);

    }

    @Override
    public void whenNotifiedByChild(EChildEvent typeEvent) {
        if (typeEvent == EChildEvent.ASK_FOR_JOIN_GAME) {

            WebsocketClientHelper.sendMessageToServer(EMessageType.JOIN_GAME,
                    presentationGameProposal.getPseudoPlayer());
        }
        else{
            logger.warning("mon mes childs ne m'ont pas bien notifiées");
        }

    }

}
