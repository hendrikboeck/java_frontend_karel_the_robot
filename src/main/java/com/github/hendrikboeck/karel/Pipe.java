package com.github.hendrikboeck.karel;

public class Pipe {

  public static String HOST = "127.0.0.1";
  public static int PORT = 14480;

  private static Pipe instance;

  private int id;
  private TCPClient client;

  private Pipe() {
    id = 0;
    client = new TCPClient();
    client.connect(HOST, PORT);
  }

  public static Pipe getInstance() {
    if (instance == null) instance = new Pipe();
    return instance;
  }

  public void send(String data) {
    client.send(data);
  }

  public String recv() {
    return client.recv();
  }

  public void close() {
    client.close();
  }

  public int getCID() {
    return id++;
  }

  

}
