/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sjsu.delcastillo.cs146.project2;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Kiyeon
 */
public class RedBlackTreesTest {
    
    public RedBlackTreesTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of addNode method, of class RedBlackTrees.
     */
    @Test
    public void testAddNode() 
    {
        System.out.println("\n**********************");
        System.out.println("addNode function");
        Comparable item = "Omega";
        RedBlackTrees instance = new RedBlackTrees("");
        
        instance.addNode(item);
        System.out.println(item + " has been added.");
        System.out.println("\n**********************");
    
    }

    /**
     * Test of searchNode method, of class RedBlackTrees.
     */
    @Test
    public void testSearchNode() 
    {
        System.out.println("\n**********************");
        System.out.println("searchNode function");
        Comparable item = "fire";
        RedBlackTrees instance = new RedBlackTrees("");
        instance.addNode("fire");
        instance.addNode("water");
        boolean expResult = true;
        boolean result = instance.searchNode(item);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        System.out.println("Found: " + result);
    }

    /**
     * Test of inorder method, of class RedBlackTrees.
     */
    @Test
    public void testInorder() 
    {
        System.out.println("\n**********************");
        System.out.println("Inorder function: ");
        RedBlackTrees instance = new RedBlackTrees("");
        instance.addNode("hello");
        instance.addNode("test");
        instance.addNode("apple");
        instance.inorder();
        System.out.println("\n**********************");
        
    }

    /**
     * Test of preorder method, of class RedBlackTrees.
     */
    @Test
    public void testPreorder() 
    {
        System.out.println("\n**********************");
        System.out.println("Preorder function:");
        RedBlackTrees instance = new RedBlackTrees("");
        instance.addNode("hello");
        instance.addNode("test");
        instance.addNode("apple");
        instance.preorder();
        System.out.println("\n**********************");
        
    }

    /**
     * Test of postorder method, of class RedBlackTrees.
     */
    @Test
    public void testPostorder() 
    {
        System.out.println("\n**********************");
        System.out.println("Postorder function:");
        RedBlackTrees instance = new RedBlackTrees("");
        instance.addNode("hello");
        instance.addNode("test");
        instance.addNode("apple");
        instance.postorder();
        System.out.println("\n**********************");
        
    }

    /**
     * Test of printTree method, of class RedBlackTrees.
     */
    @Test
    public void testPrintTree() 
    {
        System.out.println("\n**********************");
        System.out.println("printTree function");
        RedBlackTrees instance = new RedBlackTrees("");
        instance.addNode("hello");
        instance.addNode("test");
        instance.addNode("apple");
        instance.addNode("omega");
        instance.addNode("theta");
        instance.printTree();
        
    }

    /**
     * Test of isEmpty method, of class RedBlackTrees.
     */
    @Test
    public void testIsEmpty() 
    {
        System.out.println("\n**********************");
        System.out.println("isEmpty function");
        RedBlackTrees instance = new RedBlackTrees("");
        instance.addNode("hello");
        instance.addNode("test");
        instance.addNode("apple");
        
        boolean expResult = false;
        boolean result = instance.isEmpty();
        assertEquals(expResult, result);
        System.out.println("Tree is empty: " + result);
        System.out.println("\n**********************");
    
    }

    /**
     * Test of clear method, of class RedBlackTrees.
     */
    @Test
    public void testClear() 
    {
        System.out.println("\n**********************");
        System.out.println("Clear function");
        RedBlackTrees instance = new RedBlackTrees("");
        
        instance.addNode("hello");
        instance.addNode("test");
        instance.addNode("apple");
        System.out.println("Tree is empty: " + instance.isEmpty());
        
        instance.clear();
        System.out.println("Tree has been cleared");
        System.out.println("Tree is empty: " + instance.isEmpty());
        System.out.println("\n**********************");  
    }
    
    @Test
    public void test()
    {
        RedBlackTrees rbt = new RedBlackTrees("");
        rbt.addNode("D");
        rbt.addNode("B");
        rbt.addNode("A");
        rbt.addNode("C");
        rbt.addNode("F");
        rbt.addNode("E");
        rbt.addNode("H");
        rbt.addNode("G");
        rbt.addNode("I");
        rbt.addNode("J");
        assertEquals("DBACFEHGIJ", makeString(rbt));
        String str=     
"Color: 1, Key:D Parent: \n"+
"Color: 1, Key:B Parent: D\n"+
"Color: 1, Key:A Parent: B\n"+
"Color: 1, Key:C Parent: B\n"+
"Color: 1, Key:F Parent: D\n"+
"Color: 1, Key:E Parent: F\n"+
"Color: 0, Key:H Parent: F\n"+
"Color: 1, Key:G Parent: H\n"+
"Color: 1, Key:I Parent: H\n"+
"Color: 0, Key:J Parent: I\n";
        assertEquals(str, makeStringDetails(rbt));
            
    }
    
    public static String makeString(RedBlackTrees t)
    {
       abstract class MyVisitor implements RedBlackTrees.Visitor 
       {
          String result = "";
          public void visit(RedBlackTrees.RBNode n)
          {
             result = result + n.key;
          }
       }
       MyVisitor v = new MyVisitor() {

           @Override
           public void visit(RBNode n) {
               throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
           }
       };
       t.preOrderVisit(v);
       return v.result;
    }

    public static String makeStringDetails(RedBlackTrees t) {
    	{
    	       class MyVisitor implements RedBlackTrees.Visitor 
               {
    	          String result = "";
    	          public void visit(RedBlackTrees.RBNode n)
    	          {
    	        	  if(!(n.key).equals(""))
    	        		  result = result +"Color: "+n.color+", Key:"+n.key+" Parent: "+n.parent.key+"\n";
    	             
    	          }
    	       }
               
    	       MyVisitor v = new MyVisitor();
    	       t.preOrderVisit(v);
    	       return v.result;
    	 }
    }
    
}
