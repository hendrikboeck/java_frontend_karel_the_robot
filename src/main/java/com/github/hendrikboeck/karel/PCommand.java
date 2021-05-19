package com.github.hendrikboeck.karel;

import java.io.StringWriter;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public abstract class PCommand {

  public static String create(int cid, String funcName, JSONObject args) {
    if(args == null) args = new JSONObject();

    var json = new JSONObject();
    json.put("id", cid);
    json.put("function", funcName);
    json.put("args", args);
    
    try {
      var out = new StringWriter();
      json.writeJSONString(out);
      return out.toString();
    } catch (IOException e) {
      System.err.println("PCommand-Error: " + e);
      System.exit(1);
    }
    return null;
  }

  public static JSONObject verify(int cid, String jsonString) {
    try{
      var parser = new JSONParser();
      var json = (JSONObject) parser.parse(jsonString);

      var recvCID = (Long)json.get("id");
      if (cid != recvCID) {
        System.err.println("Pipe-Error: expected CID " + cid + ", but received CID " + recvCID);
        System.exit(1);
      }

      return json;
    } catch (ParseException e) {
      System.err.println("PCommand-Error: ParseError: " + e);
      System.exit(1);
    }
    return null;
  }

  public static void checkOnError(Object obj) {
    if (obj instanceof String) {
      System.err.println("PBE-Error: " + (String)obj);
      System.exit(1);
    }
  }

}