/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sjsu.delcastillo.cs146.project2;

/**
 *
 * @author Kiyeon
 * Kyle Del Castillo
 * CS 146 - Data Structures
 * Project 2 - Red Black Trees
 */

import java.io.File;
import java.util.Scanner;

public class RBTreesMain 
{
    public static void main(String[] args) 
    {
        Scanner input = null;
 
        RedBlackTrees rbTrees = new RedBlackTrees(""); //Initiate object
                  
        System.out.println("------***Red Black Trees***------");
        
        //Open file
        try //File exists
        {
            input = new Scanner(new File("SimplifiedDictionary.txt"));
            System.out.println("File has been opened.");
        }
        catch(Exception e) //File does not exist
        {
            System.out.println("File does not exist.");
        }
        
        //While file has an input
        userInterface(rbTrees,input);
      
        input.close(); //Close the input file
        System.out.println("System has been terminated");
    }
    
    public static void userInterface(RedBlackTrees trees, Scanner in)
    {
        Scanner userChoice = new Scanner(System.in); //User command
      
        long startTime; //Variable for start time
        long endTime; //Variable for end time
        long totalTime; //Variable for the total time of the program function
        
        System.out.println("\nPlease enter the corresponding number for the command.");
        System.out.println("Commands: \n");
        
        System.out.println("1. Add dictionary data");
        System.out.println("2. Search for data");
        System.out.println("3. Empty tree");
        System.out.println("4. Check tree");
        System.out.println("5. Pre-order traverse");
        System.out.println("6. In-order traverse");
        System.out.println("7. Post-order traverse");
        System.out.println("-1. End program");
        
        Comparable object = null; //Item tot add inside the tree
        Comparable lookupObject = null; //Item for lookup inside the tree
        
        System.out.print("\nChoice: ");
        int choice = userChoice.nextInt(); //Obtain command from user
        System.out.println();
        
        while(choice != -1) //While the choice command is not -1, keep looping till -1 terminates the program
        {
            switch(choice)
            {
                case 1: //Adding to tree
                    System.out.println("Adding dictionary to the tree.\n");
                    startTime = System.currentTimeMillis(); //Time the addition of data inside the tree
                    
                    while(in.hasNext()) //While the file has input 
                    {
                        object = in.nextLine(); //Get next input
                        trees.addNode(object); //Add input to the node
                    
                        System.out.println(object + " has been added");
                    }
                    endTime   = System.currentTimeMillis();
                    totalTime = endTime - startTime;
                    
                    System.out.println("\nThe total time of the insertion from the text file is: " + totalTime + " milliseconds");
                    break;
                case 2: //Case for searching from another text file
                    
                    System.out.println("Accessing file...");
                    try //Try to open the lookup file
                    {
                        
                        Scanner userLookup = new Scanner(new File("lookUp.txt"));
                        System.out.println("File has been accessed.");
                        System.out.println("--------------------------------------------------------------");
                        //Time the lookup inside the tree   
                        startTime = System.currentTimeMillis(); 
                        
                        while(userLookup.hasNext())
                        {
                            lookupObject = userLookup.next().toLowerCase();
                            System.out.println("Searching for " + lookupObject + " inside the tree.");
                            System.out.println("Item found: " + trees.searchNode(lookupObject));
                    
                        }
                        
                        endTime   = System.currentTimeMillis();
                        totalTime = endTime - startTime;
                        System.out.println("\nThe lookup time is: " + totalTime + " milliseconds");
                        System.out.println("--------------------------------------------------------------");
                        
                    }
                    catch(Exception e) //Print error message
                    {
                        System.out.println("File not found.");
                    }
        
                    break;
                case 3: //Empties the tree
                    System.out.println("Emptying tree...");
                    trees.clear(); //Empty tree
                    System.out.println("Tree is now empty");
                    break;
                case 4: //Check if the tree is empty
                    System.out.println("Checking tree status...");
                    System.out.println("Tree is empty: " + trees.isEmpty());
                    break;
                case 5: //Traverse in pre-order
                    System.out.println("Traversing in Pre-order format: ");
                    trees.preorder();
                    break;
                case 6: //Traverse in in-order
                    System.out.println("Traversing in In-order format: ");
                    trees.inorder();
                    break;
                case 7: //Traverse in post-order
                    System.out.println("Traversing in Post-order format: ");
                    trees.postorder();
                    break;
                default: //Prints error message when user inputs different command choice
                    System.out.println("Invalid command input. Please choose from 1 to 7. -1 to terminate");
                    break;
            } //End switch
            
            System.out.println("\n**********************************************************************************");
            System.out.println("Commands: \n");
            System.out.println("1. Add dictionary data");
            System.out.println("2. Search for data");
            System.out.println("3. Empty tree");
            System.out.println("4. Check tree");
            System.out.println("5. Pre-order traverse");
            System.out.println("6. In-order traverse");
            System.out.println("7. Post-order traverse");
            System.out.println("-1. End program");
            
            System.out.print("\nChoice: ");
            choice = userChoice.nextInt(); //Obtain next choice
            System.out.println();
            
        } //End while
        
    } //End userInterface
                
}
