package com.github.hendrikboeck.karel;

import java.io.IOException;

import org.json.simple.JSONObject;

public abstract class Karel {

  private static Object executeCommand(String cmdName, JSONObject cmdArgs) {
    var pipe = Pipe.getInstance();
    var cid = pipe.getCID();

    pipe.send(PCommand.create(cid, cmdName, cmdArgs));
    var result = PCommand.verify(cid, pipe.recv()).get("result");
    
    PCommand.checkOnError(result);
    return result;
  }

  private static void atexit() {
    executeCommand("EOS", null);
    Pipe.getInstance().close();
  }

  public static void loadWorld(String name) {
    try {
      var os = System.getProperty("os.name").toLowerCase();
      var isWindows = os.contains("win");
      var pbeExe = isWindows ? "./pbe/run_karel_pbe.bat" : "./pbe/run_karel_pbe.sh";
      Runtime.getRuntime().exec(pbeExe);
    } catch (IOException e) {
      System.err.println("Karel: Could not spawn PBE-Process: " + e);
      System.exit(1);
    }

    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      System.err.println("Karel: Waiting on PBE-Process has been interrupted: " + e);
      System.exit(1);
    }

    var mapArgs = new JSONObject();
    mapArgs.put("map", name);

    executeCommand("loadWorld", mapArgs);

    Runtime.getRuntime().addShutdownHook(new Thread() {
      public void run() {
        Karel.atexit();
      }
    });
  }

  public static void move() {
    executeCommand("move", null);
  }

  public static void turnLeft() {
    executeCommand("turnLeft", null);
  }

  public static void pickBeeper() {
    executeCommand("pickBeeper", null);
  }

  public void putBeeper() {
    executeCommand("putBeeper", null);
  }

  public boolean frontIsClear() {
    var result = executeCommand("frontIsClear", null);
    return ((Boolean)result).booleanValue();
  }

  public boolean frontIsBlocked() {
    return !frontIsClear();
  }

  public boolean rightIsClear() {
    var result = executeCommand("rightIsClear", null);
    return ((Boolean)result).booleanValue();
  }

  public boolean rightIsBlocked() {
    return !rightIsClear();
  }

  public boolean leftIsClear() {
    var result = executeCommand("leftIsClear", null);
    return ((Boolean)result).booleanValue();
  }

  public boolean leftIsBlocked() {
    return !leftIsClear();
  }

  public boolean beeperInBag() {
    var result = executeCommand("beeperInBag", null);
    return ((Boolean)result).booleanValue();
  }

  public boolean noBeeperInBag() {
    return !beeperInBag();
  }

  public boolean beeperPresent() {
    var result = executeCommand("beeperPresent", null);
    return ((Boolean)result).booleanValue();
  }

  public boolean noBeeperPresent() {
    return !beeperPresent();
  }

  public boolean facingNorth() {
    var result = executeCommand("facingNorth", null);
    return ((Boolean)result).booleanValue();
  }

  public boolean notFacingNorth() {
    return !facingNorth();
  }

  public boolean facingEast() {
    var result = executeCommand("facingEast", null);
    return ((Boolean)result).booleanValue();
  }

  public boolean notFacingEast() {
    return !facingEast();
  }

  public boolean facingSouth() {
    var result = executeCommand("facingSouth", null);
    return ((Boolean)result).booleanValue();
  }

  public boolean notFacingSouth() {
    return !facingSouth();
  }

  public boolean facingWest() {
    var result = executeCommand("facingWest", null);
    return ((Boolean)result).booleanValue();
  }

  public boolean notFacingWest() {
    return !facingWest();
  }

}
