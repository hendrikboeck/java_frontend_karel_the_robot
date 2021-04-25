package karellib;

public class Pipe {

  private int id;
  private TCPClient client;

  public Pipe() {
    id = 0;
    client = new TCPClient();
    client.connect("127.0.0.1", 1234);
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

  public int getId() {
    return id++;
  }

  public static String createCommand(int id, String functionName, String args) {
    return "";
  }

}
