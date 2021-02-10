package com.pierrickmonchoix.memoryserver;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.websocket.OnMessage;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import org.apache.log4j.Logger;

@ServerEndpoint("/echo")
public class EchoEndPoint {

  private static Logger logger = Logger.getLogger(EchoEndPoint.class);




  @OnMessage
  public void echo(String message, Session session) {
    System.out.println(message);
    try{
    session.getBasicRemote().sendText("msg bien recu par le server : " + message);
    }
    catch(Exception e){
      logger.error("echo");
      logger.error(e);
    }
    /* return ThreadSafeFormatter.getDateFormatter().format(new Date()) + " "
      +  message; */
  }
}

class ThreadSafeFormatter {
  private static final ThreadLocal<SimpleDateFormat> formatter = 
    new ThreadLocal<SimpleDateFormat>() {
    @Override
    protected SimpleDateFormat initialValue() {
      return new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
    }
  };

  public static DateFormat getDateFormatter() {
    return formatter.get();
  }
}