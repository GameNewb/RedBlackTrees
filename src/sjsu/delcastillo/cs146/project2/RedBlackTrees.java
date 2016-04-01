/*
 * To change this license root, choose License Headers in Project Properties.
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

public class RedBlackTrees
{ 
    private RBNode root; //Root node
    private RBNode currentNode; //Current node of the pointer
    private RBNode parent; //Parent of the current node
    private RBNode grandParent; //Grand parent of the current node
    private RBNode greatParent; //Great grand parent of the current node
    private static RBNode nullNode = new RBNode(null); //Initiate node
    
    //Initialize left and right
    static 
    {
        nullNode.left = nullNode;
        nullNode.right = nullNode;
    }
    
    //Values for color: Black = 1; Red = 0
    static final int BLACK = 1;    
    static final int RED   = 0;
 
    //Constructor
    public RedBlackTrees(Comparable value)
    {
        root = new RBNode(value); //Root now has a value based on user input
        root.left = nullNode; //Initiate new object for left
        root.right = nullNode; //Initiate new object for right
    }
     
    //Function to add nodes into the tree
    public void addNode(Comparable item )
    {
        currentNode = parent = grandParent = root; 
        nullNode.data = item; //New item to add
        
        //Adjust and balance the tree, moving the nodes around
        while (!currentNode.data.equals(item)) //While the current node does not equal the node to be added
        {
            greatParent = grandParent; //Grandparent is now a great grand parent
            grandParent = parent; //Parent is now a grandparent
            parent = currentNode; //Current node becomes a parent
            
            if(item.compareTo(currentNode.data) < 0) //If the item to be added is less than the currentNode(now parent), add node to the left
            {
                currentNode = currentNode.left; //currentNode becomes the left child
            }
            else //Otherwise add to the right
            {
                currentNode = currentNode.right; //currentNode becomes the right child
            }
            
            //If there's two red children, fix the tree            
            if (currentNode.left.color == RED && currentNode.right.color == RED)
            {
                fixTree( item ); //Call fixTree function
            }
        }
        
         
        //If it's already in the tree, stop adding
        if (currentNode != nullNode)
        {
            return;
        }
        
        currentNode = new RBNode(item, nullNode, nullNode);
        
        //Attach to the tree/parent
        if (item.compareTo(parent.data) < 0) //If the current node is less than parent, make left child
        {
            parent.left = currentNode;
        }
        else //If the current node is greater than parent, make right child
        {    
            parent.right = currentNode;        
        }
        
        fixTree( item ); //Re-color and rotate tree
    }
    
    //Get the sibling of the corresponding node
    private RBNode getSibling(RBNode node)
    {
        if(root == null || parent == null)
        {
            return null;
        }
        
        if(parent.left == node)
        {
            return parent.right;
        }
        else if(parent.right == node)
        {
            return parent.left;
        }
        else
        {
            return null;
        }
    }
    
    //Returns the aunt of the node
    private RBNode getAunt(RBNode node)
    {
        if(node == null)
        {
            return null;
        }
        
        if(node.left != null && node.left == parent)
        {
            return node.right;
        }
        else if(node.right != null && node.right == parent)
        {
            return node.left;
        }
        else
        {
            return null;
        }
    }
    
    //Returns the grandparent of the node
    private RBNode getGrandParent(RBNode node)
    {
        if(parent == null)
        {
            return null;
        }
        
        return grandParent;
    }
     
    //Re-color and rotate the tree to represent Red-Black-Trees
    private void fixTree(Comparable item)
    {
        //Change and set colors
        currentNode.color = RED;
        currentNode.left.color = BLACK;
        currentNode.right.color = BLACK;
 
        if (parent.color == RED)   
        {
            grandParent.color = RED;
            if ((item.compareTo(grandParent.data) < 0) != (item.compareTo(parent.data) < 0))
            {
                parent = rotate(item, grandParent );  //Rotation of the tree
            }
             
            currentNode = rotate(item, greatParent );
            currentNode.color = BLACK;
        }
        //Change root color to black
        root.right.color = BLACK; 
    }  
     
    //Rotate the tree
    private RBNode rotate(Comparable item, RBNode parent)
    {
        if(item.compareTo(parent.data) < 0) 
        {
            if(item.compareTo(parent.left.data) < 0) //Left-left rotation
            {
                parent.left = rotateLeft(parent.left);
                return parent.left;
            }
            else //Left-right rotation
            {
                parent.left = rotateRight(parent.left);
                return parent.left;
            }
        }
        else
        {
            if(item.compareTo(parent.right.data) < 0) //Right-left rotation
            {
                parent.right = rotateLeft(parent.right);
                return parent.right;
            }
            else //Right-right rotation
            {
                return parent.right = rotateRight(parent.right);
            }
        }
    } //End rotate
     
    //Rotation with left child
    private RBNode rotateLeft(RBNode rNode)
    {
        RBNode tempChild = rNode.left;
        rNode.left = tempChild.right;
        tempChild.right = rNode;
        return tempChild;
    }
    
    //Rotation with right child
    private RBNode rotateRight(RBNode tempChild)
    {
        RBNode rNode = tempChild.right;
        tempChild.right = rNode.left;
        rNode.left = tempChild;
        return rNode;
    }
     
    //Searches for the corresponding node in the tree
    public boolean searchNode(Comparable item)
    {
        nullNode.data = item;
        currentNode = root.right;
        boolean found = false;
        
        for(;;) //For all items in the tree
        {
            if( item.compareTo(currentNode.data) < 0) //If the comparison returns -1, traverse to the left of the tree
            {
                currentNode = currentNode.left;
            }
            else if( item.compareTo(currentNode.data) > 0) //Otherwise traverse to the right
            {
                currentNode = currentNode.right;
            }
            else if(currentNode != nullNode)
            {
                found = true;
                return found;
            }
            else
            {
                return found;
            }
        }
    }
     
     
    //In-order traversal
    public void inorder()
    {
         inorder(root.right);
    }
    
    private void inorder(RBNode node)
    {
        if (node != nullNode)
        {
            inorder(node.left);
            char color = 'B';
            
            if (node.color == 0)
            {
                color = 'R';
            }
            System.out.print(node.data +"("+color+") ");
            inorder(node.right);
            
        }
    }
     
    //Pre-order traversal
    public void preorder()
    {
         preorder(root.right);
    }
    
    private void preorder(RBNode node)
    {
        if (node != nullNode)
        {
            char color = 'B';
            if (node.color == 0)
            {
                color = 'R';
            }
            
            System.out.print(node.data +"("+color+") ");
            preorder(node.left);             
            preorder(node.right);
        }  
    }
    
    //Post-order traversal 
    public void postorder()
    {
        postorder(root.right);
    }
    
    private void postorder(RBNode node)
    {
        if (node != nullNode)
        {
            postorder(node.left);             
            postorder(node.right);
            char color = 'B';
            
            if (node.color == 0)
            {
                color = 'R';
            }
            
            System.out.print(node.data +"("+color+") ");
        }
    }     
     
    //Print the tree based on how it was inputted
    public void printTree()
    {
        if(isEmpty())
        {
            System.out.println("The tree is empty.");
        }
        else
        {             
            printTree(root.right);
        }
    }
     
    private void printTree( RBNode item )
    {
        if( item != nullNode )
        {
            System.out.println(item.data );
            printTree(item.left);
            printTree(item.right);
        }
    }
    
     
    //Check whether the tree is empty or not
    public boolean isEmpty()
    {
        return root.right == nullNode;
    }
     
    //Reset and empties the tree
    public void clear()
    {
        root.right = nullNode;
    }
    
    // add this in your class  
    public static interface Visitor
    {
      	/**
    //     This method is called at each node.
    //     @param n the visited node
    //  	 */
        void visit(RBNode n);
    }
 
  
    public void preOrderVisit(Visitor v)
    {
        preOrderVisit(root, v);
    }
 
 
    private static void preOrderVisit(RBNode n, Visitor v)
    {
     	if (n == null) return;
     	v.visit(n);
     	preOrderVisit(n.left, v);
     	preOrderVisit(n.right, v);
    }
}