package com.pierrickmonchoix.memoryclient;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;

/**
 * Hello world!
 *
 */
public class RestClient implements Runnable {

    private static Logger logger = Logger.getLogger(RestClient.class);

    private static final String REST_URI = "http://localhost:9992/rest/hello";

    public static void main(String[] args) {
        logger.info("reception de la requete REST");

        // creation d'un nouveau client REST
        Client client = ClientBuilder.newClient();

        // affichage de tous les canaux disponibles (par une requete REST)
        Message rep = client.target(REST_URI).path("meteo").request(MediaType.APPLICATION_JSON).get(Message.class);
        System.out.println(rep);
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub

        logger.info("reception de la requete REST");
        
        // creation d'un nouveau client REST
        Client client = ClientBuilder.newClient();

        // affichage de tous les canaux disponibles (par une requete REST)
        Message rep = client.target(REST_URI).path("meteo").request(MediaType.APPLICATION_JSON).get(Message.class);
        System.out.println(rep);

    }
}
