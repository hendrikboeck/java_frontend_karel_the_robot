package com.github.hendrikboeck.karel;

import java.io.*;
import java.net.Socket;

public class TCPClient {

  private static final int MAX_PACKET_SIZE = 65535;
  private Socket sock;

  public TCPClient() {
    sock = null;
  }

  public void connect(String ip, int port) {
    try {
      sock = new Socket(ip, port);
    } catch (IOException e) {
      System.err.println("ERROR: could not create socket: " + e.toString());
      System.exit(1);
    }
  }

  public void send(String data) {
    try {
      var writer = new PrintWriter(new OutputStreamWriter(sock.getOutputStream()));
      writer.print(data);
      writer.flush();
    } catch (IOException e) {
      System.err.println("ERROR: could not send to server: " + e.toString());
      System.exit(1);
    }
  }

  public String recv() {
    try {
      var reader = new BufferedReader(new InputStreamReader(sock.getInputStream()));
      var buff = new char[MAX_PACKET_SIZE];
      var numRecvBytes = reader.read(buff, 0, MAX_PACKET_SIZE);
      return new String(buff, 0, numRecvBytes);
    } catch (IOException e) {
      System.err.println("ERROR: could not recv from server: " + e.toString());
      System.exit(1);
    }
    return null;
  }

  public void close() {
    try {
      sock.close();
    } catch (IOException e) {
      System.err.println("ERROR: could not close socket: " + e.toString());
    }
  }

}
