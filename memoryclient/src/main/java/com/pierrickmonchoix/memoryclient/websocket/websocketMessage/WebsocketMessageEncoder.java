package com.pierrickmonchoix.memoryclient.websocket.websocketMessage;

import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

import com.google.gson.Gson;

public class WebsocketMessageEncoder implements Encoder.Text<WebsocketMessage>{

	private static Gson gson = new Gson();
	
	@Override
	public void init(EndpointConfig config) {
		
	}

	@Override
	public void destroy() {
		
	}

	/**
	 * Création d'un objet Json pour l'envoie
	 */
	@Override
	public String encode(WebsocketMessage mess) throws EncodeException {
		return gson.toJson(mess);		
	}

}
