package com.homework;

import java.util.Scanner;
import java.util.*;
import org.json.simple.*;

public class App 
{
    protected Pharaoh[] pharaohArray;
    protected Pyramid[] pyramidArray;
    public static void main( String[] args )
    {
       App app = new App();
    app.start();
    }

    public App() {
        // read egyptian pharaohs
        String pharaohFile =
          "/Users/jerom/Documents/GitHub/class-java/egyptian-pyramids/demo/src/main/java/com/egyptianExample/pharaoh.json";
        JSONArray pharaohJSONArray = JSONFile.readArray(pharaohFile);
    
        // create and intialize the pharaoh array
        initializePharaoh(pharaohJSONArray);
    
        // read pyramids
        String pyramidFile =
          "/Users/jerom/Documents/GitHub/class-java/egyptian-pyramids/demo/src/main/java/com/egyptian/pyramid.json";
        JSONArray pyramidJSONArray = JSONFile.readArray(pyramidFile);
    
        // create and initialize the pyramid array
        initializePyramid(pyramidJSONArray);
    
      }

    public void start(){
        Scanner scan = new Scanner(System.in);
        char command = '_';

        while (command != 'q'){
            printMenu();
            System.out.println("Enter a command: ");
            command = menuGetCommand(scan);
            executeCommand(scan, command);

        }
    }
    
    //Displays the Menu
    public static void printMenu(){
       System.out.println("----------------------------------------------------------");
       System.out.println("Nassef's Egyptian Pyramids App");
       System.out.println("----------------------------------------------------------");
       System.out.println("Command\tDescription");
       System.out.println("-------\t----------------------------------");
       printMenuCommand('1',"List of all pharaohs");
       printMenuCommand('2',"Display a specific Egyptian pharaoh");
       printMenuCommand('3',"List of all pyramids");
       printMenuCommand('4',"Display a specific pyramid");
       printMenuCommand('5',"Displays a list of requested pyramids");
       printMenuCommand('q',"Quit");

    }

    public static void printMenuCommand(Character command, String desc){
        System.out.printf("%s\t%s\n",command, desc);
    }

    private Boolean executeCommand(Scanner scan, Character command) {
        Boolean success = true;
        
        switch (command) {
          case '1':
            printAllPharaoh();
            break;
          case '2':
            break;
          case '3':
            break;
          case '4':
            break;
          case '5':
            break;
          case 'q':
            System.out.println("Thank you for using Nassef's Egyptian Pyramid App!");
            break;
          default:
            System.out.println("ERROR: Unknown commmand");
            success = false;
        }
    
        return success;
      }

      private void printAllPharaoh() {
        for (int i = 0; i < pharaohArray.length; i++) {
          printMenuLine();
          pharaohArray[i].print();
          printMenuLine();
        }
      }

      private static Character menuGetCommand(Scanner scan) {
        Character command = '_';
    
        String rawInput = scan.nextLine();
    
        if (rawInput.length() > 0) {
          rawInput = rawInput.toLowerCase();
          command = rawInput.charAt(0);
        }
    
        return command;
      }

}
