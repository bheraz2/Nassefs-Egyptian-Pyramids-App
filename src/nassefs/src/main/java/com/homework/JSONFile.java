package com.homework;

import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.io.FileNotFoundException;

public class JSONFile {

  // read a json file and return an array
  public static JSONArray readArray(String fileName) {
    //
    // read the birthday.json file and iterate over it
    //

    // JSON parser object to parse read file
    JSONParser jsonParser = new JSONParser();

    JSONArray data = null;

    try (FileReader reader = new FileReader(fileName)) {
      Object obj = jsonParser.parse(reader);
      if (obj instanceof JSON Array){
         data = (JSONArray) obj;
      }else{
        System.out.println("Error: The file does not contain a JSON Array");
      }
      
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    } catch (ParseException e) {
      e.printStackTrace();
    }

    return data;
  }
}
