package com.homework;

  import java.util.*;

  import org.json.simple.JSONArray;
  import org.json.simple.JSONObject;





  public class App 
  {
      private HashMap<Integer, Pharaoh> pharaohMap;
      private HashMap<Integer, Pyramid> pyramidMap;
      private Map<String, String> hieroglyphicMap;

      protected Pharaoh[] pharaohArray;
      protected Pyramid[] pyramidArray;
      public static void main( String[] args )
      {
        App app = new App();
      app.start();
      }

      public App() {
          //Initialize the HashMaps
          pharaohMap = new HashMap<>();
          pyramidMap = new HashMap<>();
          hieroglyphicMap = new LinkedHashMap<>();

          // read egyptian pharaohs
          String pharaohFile ="/Users/bryanheraz/Documents/GitHub/Nassefs-Egyptian-Pyramids-App/src/nassefs/src/main/java/com/homework/pharaoh.json";
          JSONArray pharaohJSONArray = JSONFile.readArray(pharaohFile);
          
      
          // create and intialize the pharaoh array
          initializePharaoh(pharaohJSONArray);
      
          // read pyramids
          String pyramidFile = "/Users/bryanheraz/Documents/GitHub/Nassefs-Egyptian-Pyramids-App/src/nassefs/src/main/java/com/homework/pyramid.json";
          JSONArray pyramidJSONArray = JSONFile.readArray(pyramidFile);
      
          // create and initialize the pyramid array
          initializePyramid(pyramidJSONArray);
      
        }

        
        private void initializePharaoh(JSONArray pharaohJSONArray) {
          if (pharaohJSONArray == null) {
              System.out.println("Error: The pharaohJSONArray is null");
              return;
          }
      
          pharaohArray = new Pharaoh[pharaohJSONArray.size()];
      
          for (Object pharaohObj : pharaohJSONArray) {
              if (pharaohObj instanceof JSONObject) {
                  JSONObject pharaohJson = (JSONObject) pharaohObj;
      
                  Integer id = Integer.parseInt(pharaohJson.get("id").toString());
                  String name = pharaohJson.get("name").toString();
                  String begin = pharaohJson.get("begin").toString();
                  String end = pharaohJson.get("end").toString();
                  Integer contribution = Integer.parseInt(pharaohJson.get("contribution").toString());
                  String hieroglyphic = pharaohJson.get("hieroglyphic").toString();
      
                  // Populate the hieroglyphicMap with hieroglyphic as key and name as value
                  hieroglyphicMap.put(hieroglyphic, name);
      
                  Pharaoh pharaoh = new Pharaoh(id, name, begin, end, contribution, hieroglyphic);
                  pharaohMap.put(id, pharaoh);
              }
          }
      }
      
      
      

          // initialize the pyramid array
          private void initializePyramid(JSONArray pyramidJSONArray) {
            // create array and hash map
            pyramidArray = new Pyramid[pyramidJSONArray.size()];
        
            // initalize the array
            for (int i = 0; i < pyramidJSONArray.size(); i++) {
                // get the object
                JSONObject o = (JSONObject) pyramidJSONArray.get(i);
        
                // parse the json object
                Integer id = Integer.parseInt(o.get("id").toString()); 
                String name = o.get("name").toString();
                JSONArray contributorsJSONArray = (JSONArray) o.get("contributors");
                
                // Move the declaration outside the loop
                String[] contributors = new String[contributorsJSONArray.size()];
                
                for (int j = 0; j < contributorsJSONArray.size(); j++) {
                    String c = contributorsJSONArray.get(j).toString();
                    contributors[j] = c;
                }
        
                // add a new pyramid to array
                Pyramid p = new Pyramid(id, name, contributors);
                pyramidArray[i] = p;

                // add the pyramid to the map
                pyramidMap.put(id, p);
              }
        }
        

      public void start(){
          Scanner scan = new Scanner(System.in);
          char command = '_';

          while (command != 'q'){
              printMenu();
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
        System.out.println("-------\t-------------------------------------------------");
        printMenuCommand('1',"List of all pharaohs");
        printMenuCommand('2',"Display a specific Egyptian pharaoh");
        printMenuCommand('3',"List of all pyramids");
        printMenuCommand('4',"Display a specific pyramid");
        printMenuCommand('5',"Displays a list of requested pyramids");
        printMenuCommand('q',"Quit");
        System.out.println("-------\t-------------------------------------------------");
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
              int pyramidId = getUserInputForPyramidId(); 
              printPyramidContributions(pyramidId);
              break;
            case '5':
                displayRequestedPyramids();
                
              break;
            case 'q':
              System.out.println("Thank you for using Nassef's Egyptian Pyramid App!");
              break;
            default:
            if(!Character.isLetter(command) || command == 'q'){
              System.out.println("Error: Unknown Commamnd");
            }
            
              success = false;
          }
      
          return success;
        }

        

        // Method to get pyramid ID from the user
        private int getUserInputForPyramidId() {
          Scanner scanner = new Scanner(System.in);
          System.out.print("Enter the Pyramid ID: ");
          while (!scanner.hasNextInt()) {
              System.out.println("That's not a valid number. Please enter a valid Pyramid ID:");
              scanner.next(); // Consume the non-integer input
          }
          
          int pyramidID = scanner.nextInt();
          
          // Check if the pyramid ID is not already in the set
          if (!requestedPyramidIDs.contains(pyramidID)) {
              requestedPyramidIDs.add(pyramidID);
          }
      
          return pyramidID;
      }


    private void printPyramidContributions(int pyramidId) {
      Pyramid pyramid = pyramidMap.get(pyramidId);
      if (pyramid == null) {
          System.out.println("Pyramid with ID " + pyramidId + " not found.");
          return;
      }
  
      int totalContribution = 0;
      System.out.println("Contributions for Pyramid '" + pyramid.getName() + "':");
  
      for (String contributor : pyramid.getContributors()) {
          for (Pharaoh pharaoh : pharaohMap.values()) {
              if (pharaoh.getHieroglyphic().equals(contributor)) {
                  int contribution = pharaoh.getContribution();
                  System.out.println(pharaoh.getName() + ": " + contribution + " gold coins");
                  totalContribution += contribution;
                  break; // Break since we found the matching pharaoh
              }
          }
      }
  
      System.out.println("Total Contribution for this Pyramid: " + totalContribution + " gold coins");
  }
  
      

        //prints the list of all pharaohs
        private void printAllPharaoh() {
          for (Pharaoh pharaoh : pharaohMap.values()) {
            System.out.println("----------------------------------------------------------");
            pharaoh.print();
            System.out.println("----------------------------------------------------------");
        
          }
        }

        //print the list fo all pyramids
        private void printAllPyramids() {
          for (Pyramid pyramid : pyramidMap.values()) {
              System.out.println("----------------------------------------------------------");
              pyramid.print(hieroglyphicMap);
              System.out.println("----------------------------------------------------------");
          }
      }
        

        //display a spcecific Pharaoh that was requested from the user
        private void displaySpecificPharaoh(Scanner scan){
          System.out.println("Enter the ID of the Pharaoh: ");
          try{
          int pharaohID = scan.nextInt();

          if (pharaohMap.containsKey(pharaohID)){
              Pharaoh specificPharaoh = pharaohMap.get(pharaohID);
              System.out.println("----------------------------------------------------------");
              specificPharaoh.print();
              System.out.println("----------------------------------------------------------");
              scan.nextLine();

              
          }else{
              System.out.println("Pharaoh with ID" + pharaohID + "not found.");
          }
        }catch (InputMismatchException e) {
          System.out.println("Error: Invalid input. Please enter a valid integer ID.");
          scan.nextLine(); // Consume the invalid input
        }
      }



        private Set<Integer> requestedPyramidIDs = new HashSet<>();

          // Other methods...
      
          // Display all requested pyramids
          private void displayRequestedPyramids() {
            System.out.println("----------------------------------------------------------");
        
            // Check if there are any requested pyramids
            if (requestedPyramidIDs.isEmpty()) {
                System.out.println("No requested pyramids found.");
            } else {
                System.out.println("List of Requested Pyramids:");
                for (Integer pyramidID : requestedPyramidIDs) {
                    if (pyramidMap.containsKey(pyramidID)) {
                        Pyramid requestedPyramid = pyramidMap.get(pyramidID);
                        requestedPyramid.print(hieroglyphicMap);
                        System.out.println("----------------------------------------------------------");
                    } else {
                        System.out.println("Pyramid with ID " + pyramidID + " not found.");
                    }
                }
            }
        }
        
        


        private static Character menuGetCommand(Scanner scan) {
          Character command = '_';
      
          System.out.print("Enter a command: ");
          String rawInput = scan.nextLine().trim();
      
          if (rawInput.length() > 0) {
            rawInput = rawInput.toLowerCase();
            command = rawInput.charAt(0);
          }
          
          
          
      
          return command;
        }

  }
