/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sjsu.delcastillo.cs146.project2;

/**
 *
 * * @author Kiyeon
 * Kyle Del Castillo
 * CS 146 - Data Structures
 * Project 2 - Red Black Trees
 * 
 */

public class RBNode 
{
    RBNode left; //Left child
    RBNode right; //Right child
    Comparable data; //Current item
    int color; //Color for RBTrees
   
    //Constructor
    public RBNode(Comparable value)
    {
        this(value, null, null);
    }
    
    public RBNode(Comparable value, RBNode leftChild, RBNode rightChild)
    {
        left = leftChild;
        right = rightChild;
        data = value;
        color = 1;
    }
    
}
