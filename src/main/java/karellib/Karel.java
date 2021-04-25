package karellib;

public class Karel {

  private Pipe pipe;

  public Karel() {
    pipe = new Pipe();
  }

  public void loadWorld(String name) {
  }

  public void move() {
  }

  public void turnLeft() {
  }

  public void pickBeeper() {
  }

  public void putBeeper() {
  }

  public boolean frontIsClear() {
    return true;
  }

  public boolean frontIsBlocked() {
    return !frontIsClear();
  }

  public boolean rightIsClear() {
    return true;
  }

  public boolean rightIsBlocked() {
    return !rightIsClear();
  }

  public boolean leftIsClear() {
    return true;
  }

  public boolean leftIsBlocked() {
    return !leftIsClear();
  }

  public boolean beeperInBag() {
    return true;
  }

  public boolean noBeeperInBag() {
    return !beeperInBag();
  }

  public boolean beeperPresent() {
    // pipe.send("");
    // var result = pipe.recv();
    return true;
  }

  public boolean noBeeperPresent() {
    return !beeperPresent();
  }

  public boolean facingNorth() {
    return true;
  }

  public boolean notFacingNorth() {
    return !facingNorth();
  }

  public boolean facingEast() {
    return true;
  }

  public boolean notFacingEast() {
    return !facingEast();
  }

  public boolean facingSouth() {
    return true;
  }

  public boolean notFacingSouth() {
    return !facingSouth();
  }

}
