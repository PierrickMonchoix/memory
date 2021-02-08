package com.pierrickmonchoix.memoryclient;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;

/**
 * Hello world!
 *
 */
public class RestClient 
{

    private static final String REST_URI = "http://localhost:9992/rest/hello";

    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
        		// creation d'un nouveau client REST
		Client client = ClientBuilder.newClient();
		
		// affichage de tous les canaux disponibles (par une requete REST)
		Message rep = client.target(REST_URI).path("meteo").request(MediaType.APPLICATION_JSON).get(Message.class);
		System.out.println(rep);  
		


 



    }
}
