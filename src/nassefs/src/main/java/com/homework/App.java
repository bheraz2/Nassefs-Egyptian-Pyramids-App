package com.homework;

import java.util.*;
import org.json.simple.*;

public class App 
{
    private HashMap<Integer, Pharaoh> pharaohMap;
    private HashMap<Integer, Pyramid> pyramidMap;
    public static void main( String[] args )
    {
       App app = new App();
    app.start();
    }

    public App() {
        //Initialize the HashMaps
        pharaohMap = new HashMap<>();
        pyramidMap = new HashMap<>();

        // read egyptian pharaohs
        String pharaohFile ="/Users/bryanheraz/Documents/GitHub/Nassefs-Egyptian-Pyramids-App/src/main/java/com/test/lava/homework/pharaoh.json";
        JSONArray pharaohJSONArray = JSONFile.readArray(pharaohFile);
    
        // create and intialize the pharaoh array
        initializePharaoh(pharaohJSONArray);
    
        // read pyramids
        String pyramidFile = "/Users/bryanheraz/Documents/GitHub/Nassefs-Egyptian-Pyramids-App/src/main/java/com/test/lava/homework/pyramid.json";
        JSONArray pyramidJSONArray = JSONFile.readArray(pyramidFile);
    
        // create and initialize the pyramid array
        initializePyramid(pyramidJSONArray);
    
      }

    private void initializePyramid(JSONArray pyramidJSONArray) {
    }

    private void initializePharaoh(JSONArray pharaohJSONArray) {
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
            displaySpecificPharaoh(scan);
            break;
          case '3':
            printAllPyramids();
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
        for (Pharaoh pharaoh : pharaohMap.values()) {
          System.out.println("----------------------------------------------------------");
          pharaoh.print();
          System.out.println("----------------------------------------------------------");
      
        }
      }

      private void printAllPyramids(){
         for(Pyramid pyramid : pyramidMap.values()){
            System.out.println("----------------------------------------------------------");
            pyramid.print();
            System.out.println("----------------------------------------------------------"); 
         }
      }

      //To check if specific pharaoh ID exists in the map
      private void displaySpecificPharaoh(Scanner scan){
        System.out.println("Enter the ID of the Pharaoh: ");
        int pharaohID = scan.nextInt();

        if (pharaohMap.containsKey(pharaohID)){
            Pharaoh specificPharaoh = pharaohMap.get(pharaohID);
            System.out.println("----------------------------------------------------------");
            specificPharaoh.print();
            System.out.println("----------------------------------------------------------");
        }else{
            System.out.println("Pharaoh with ID" + pharaohID + "not found.");
        }
      }

         private void displaySpecificPyramid(Scanner scan){
            System.out.println("Enter the ID of the pyramid: ");
            int pyramidID = scan.nextInt();

            if(pyramidMap.containsKey(pyramidID)){
                Pyramid specificPyramid = pyramidMap.get(pyramidID);
                System.out.println("----------------------------------------------------------");
                specificPyramid.print();
                 System.out.println("----------------------------------------------------------");

            }else{
                System.out.println("Pyramid with ID" + pyramidID + "not found.");
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
