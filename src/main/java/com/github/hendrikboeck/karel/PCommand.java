/******************************************************************************/
/* karel_the_robot_java_frontend                                              */
/* Copyright (C) 2021  Hendrik Boeck <hendrikboeck.dev@protonmail.com>        */
/*                                                                            */
/* This program is free software: you can redistribute it and/or modify       */
/* it under the terms of the GNU General Public License as published by       */
/* the Free Software Foundation, either version 3 of the License, or          */
/* (at your option) any later version.                                        */
/*                                                                            */
/* This program is distributed in the hope that it will be useful,            */
/* but WITHOUT ANY WARRANTY; without even the implied warranty of             */
/* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the              */
/* GNU General Public License for more details.                               */
/*                                                                            */
/* You should have received a copy of the GNU General Public License          */
/* along with this program.  If not, see <http://www.gnu.org/licenses/>.      */
/******************************************************************************/

package com.github.hendrikboeck.karel;

import java.io.StringWriter;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public abstract class PCommand {

  public static String create(int cid, String funcName, JSONObject args) {
    var pargs = (args == null) ? new JSONObject() : args;
    var json = new JSONObject();
    json.put("id", cid);
    json.put("function", funcName);
    json.put("args", pargs);
    
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