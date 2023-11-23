package com.homework;

import java.util.Scanner;
import java.util.*;
import org.json.simple.*;

public class App 
{
    /*public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }*/

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
}
