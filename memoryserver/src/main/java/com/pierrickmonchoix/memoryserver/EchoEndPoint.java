package com.pierrickmonchoix.memoryserver;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.websocket.OnMessage;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/echo")
public class EchoEndPoint {
  @OnMessage
  public String echo(String message) {
    System.out.println(message);
    return ThreadSafeFormatter.getDateFormatter().format(new Date()) + " "
      +  message;
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