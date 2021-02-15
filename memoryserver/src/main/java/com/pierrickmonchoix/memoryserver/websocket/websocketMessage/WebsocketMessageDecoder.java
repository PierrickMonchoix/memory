package com.pierrickmonchoix.memoryserver.websocket.websocketMessage;

import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;

import com.google.gson.Gson;

public class WebsocketMessageDecoder implements Decoder.Text<WebsocketMessage> {

    private static Gson gson = new Gson();

    @Override
    public void init(EndpointConfig config) {
    }

    @Override
    public void destroy() {
    }

    @Override
    public WebsocketMessage decode(String mess) throws DecodeException {
        return gson.fromJson(mess, WebsocketMessage.class);
    }

    @Override
    public boolean willDecode(String mess) {
        return true;
    }

}
