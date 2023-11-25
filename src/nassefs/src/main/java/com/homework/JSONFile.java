package com.homework;

import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JSONFile {

  // read a json file and return an array
  public static JSONArray readArray(String fileName) {
    // JSON parser object to parse read file
    JSONParser jsonParser = new JSONParser();

    JSONArray data = null;

    try (FileReader reader = new FileReader(fileName)) {
      Object obj = jsonParser.parse(reader);

      if (obj instanceof JSONArray) {
        data = (JSONArray) obj;
      } else {
        System.out.println("Error: The file does not contain a JSON Array");
      }

    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    } catch (ParseException e) {
      e.printStackTrace();
      System.out.println("Error parsing JSON: " + e.getMessage());
    }

    return data;
  }
}


