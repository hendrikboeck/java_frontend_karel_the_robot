package com.github.hendrikboeck.karel;

import org.json.simple.JSONObject;

public abstract class Karel {

  private static void atexit() {
    var pipe = Pipe.getInstance();
    var cid = pipe.getCID();

    pipe.send(PCommand.create(cid, "close", null));
    var result = PCommand.verify(cid, pipe.recv()).get("result");
    
    PCommand.checkOnError(result);
    pipe.close();
  }

  public static void loadWorld(String name) {
    var pipe = Pipe.getInstance();
    var cid = pipe.getCID();
    var mapArgs = new JSONObject();
    mapArgs.put("map", name);

    pipe.send(PCommand.create(cid, "loadWorld", mapArgs));
    var result = PCommand.verify(cid, pipe.recv()).get("result");
    
    PCommand.checkOnError(result);

    Runtime.getRuntime().addShutdownHook(new Thread() {
      public void run() {
        Karel.atexit();
      }
    });
  }

  public static void move() {
    var pipe = Pipe.getInstance();
    var cid = pipe.getCID();

    pipe.send(PCommand.create(cid, "move", null));
    var result = PCommand.verify(cid, pipe.recv()).get("result");

    PCommand.checkOnError(result);
  }

  public static void turnLeft() {
    var pipe = Pipe.getInstance();
    var cid = pipe.getCID();

    pipe.send(PCommand.create(cid, "turnLeft", null));
    var result = PCommand.verify(cid, pipe.recv()).get("result");

    PCommand.checkOnError(result);
  }

  public static void pickBeeper() {
    var pipe = Pipe.getInstance();
    var cid = pipe.getCID();

    pipe.send(PCommand.create(cid, "pickBeeper", null));
    var result = PCommand.verify(cid, pipe.recv()).get("result");

    PCommand.checkOnError(result);
  }

  public void putBeeper() {
  }

  public boolean frontIsClear() {
    var pipe = Pipe.getInstance();
    var cid = pipe.getCID();

    pipe.send(PCommand.create(cid, "frontIsClear", null));
    var result = PCommand.verify(cid, pipe.recv()).get("result");

    PCommand.checkOnError(result);

    return ((Boolean)result).booleanValue();
  }

  public boolean frontIsBlocked() {
    return !frontIsClear();
  }

  public boolean rightIsClear() {
    var pipe = Pipe.getInstance();
    var cid = pipe.getCID();

    pipe.send(PCommand.create(cid, "rightIsClear", null));
    var result = PCommand.verify(cid, pipe.recv()).get("result");

    PCommand.checkOnError(result);

    return ((Boolean)result).booleanValue();
  }

  public boolean rightIsBlocked() {
    return !rightIsClear();
  }

  public boolean leftIsClear() {
    var pipe = Pipe.getInstance();
    var cid = pipe.getCID();

    pipe.send(PCommand.create(cid, "leftIsClear", null));
    var result = PCommand.verify(cid, pipe.recv()).get("result");

    PCommand.checkOnError(result);

    return ((Boolean)result).booleanValue();
  }

  public boolean leftIsBlocked() {
    return !leftIsClear();
  }

  public boolean beeperInBag() {
    var pipe = Pipe.getInstance();
    var cid = pipe.getCID();

    pipe.send(PCommand.create(cid, "beeperInBag", null));
    var result = PCommand.verify(cid, pipe.recv()).get("result");

    PCommand.checkOnError(result);

    return ((Boolean)result).booleanValue();
  }

  public boolean noBeeperInBag() {
    return !beeperInBag();
  }

  public boolean beeperPresent() {
    var pipe = Pipe.getInstance();
    var cid = pipe.getCID();

    pipe.send(PCommand.create(cid, "beeperPresent", null));
    var result = PCommand.verify(cid, pipe.recv()).get("result");

    PCommand.checkOnError(result);

    return ((Boolean)result).booleanValue();
  }

  public boolean noBeeperPresent() {
    return !beeperPresent();
  }

  public boolean facingNorth() {
    var pipe = Pipe.getInstance();
    var cid = pipe.getCID();

    pipe.send(PCommand.create(cid, "facingNorth", null));
    var result = PCommand.verify(cid, pipe.recv()).get("result");

    PCommand.checkOnError(result);

    return ((Boolean)result).booleanValue();
  }

  public boolean notFacingNorth() {
    return !facingNorth();
  }

  public boolean facingEast() {
    var pipe = Pipe.getInstance();
    var cid = pipe.getCID();

    pipe.send(PCommand.create(cid, "facingEast", null));
    var result = PCommand.verify(cid, pipe.recv()).get("result");

    PCommand.checkOnError(result);

    return ((Boolean)result).booleanValue();
  }

  public boolean notFacingEast() {
    return !facingEast();
  }

  public boolean facingSouth() {
    var pipe = Pipe.getInstance();
    var cid = pipe.getCID();

    pipe.send(PCommand.create(cid, "facingSouth", null));
    var result = PCommand.verify(cid, pipe.recv()).get("result");

    PCommand.checkOnError(result);

    return ((Boolean)result).booleanValue();
  }

  public boolean notFacingSouth() {
    return !facingSouth();
  }

  public boolean facingWest() {
    var pipe = Pipe.getInstance();
    var cid = pipe.getCID();

    pipe.send(PCommand.create(cid, "facingWest", null));
    var result = PCommand.verify(cid, pipe.recv()).get("result");

    PCommand.checkOnError(result);

    return ((Boolean)result).booleanValue();
  }

  public boolean notFacingWest() {
    return !facingWest();
  }

}
