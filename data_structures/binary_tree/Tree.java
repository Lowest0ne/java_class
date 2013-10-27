/*******************************************************************************
 * Tree.java
 * Demostrates a binary tree
 ******************************************************************************/
import java.io.*;
import java.util.*;
import java.lang.Integer;

/*******************************************************************************
 * Class Node
 *
 * Represents the branches of the tree
 ******************************************************************************/
class Node
{
  public double value; // the data we want to store
  public int      key; // the key to the data
  public Node    left; // the node's left child
  public Node   right; // the node's right child

  /*****************************************************************************
   * Constructor
   ****************************************************************************/
  public Node( int key, double value )
  {
    this.key   = key;
    this.value = value;
    this.left  = null;
    this.right = null;
  }
  /*****************************************************************************
   * Console Display
   ****************************************************************************/
  public void displayNode()
  {
    System.out.print( '{' );
    System.out.print( this.key );
    System.out.print( ", " );
    System.out.print( this.value );
    System.out.print( "} " );
  }
}
/*******************************************************************************
 * Class Tree
 *
 * Where the fun stuff happens
 ******************************************************************************/
class Tree
{
  private Node root;
  /*****************************************************************************
   * Constructor
   ****************************************************************************/
  public Tree()
  {
    this.root = null;
  }
  /*****************************************************************************
   * Find
   *
   * Find a node in a tree for a given key
   ****************************************************************************/
  public Node find( int key )
  {
    Node current = this.root;                                  // start at root

    while ( current != null && current.key != key )            // while no match
    {
      if ( key < current.key )                                 // go left?
        current = current.left;
      else                                                     // go right?
        current = current.right;
    }

    return current;                                            // return result
  }
  /*****************************************************************************
   * Insert
   *
   * Insert a new node into the tree
  ****************************************************************************/
  public void insert( int key, double value )
  {
    Node new_node = new Node( key, value );   // make a new node

    if ( this.root == null )                  // create root if it doesn't exist
    {
      this.root = new_node;
    }
    else                                      // otherwise,
    {
      Node current = this.root;
      Node parent;

      while (true)                            // look through the tree
      {
        parent = current;
        if ( key < current.key )              // check the left side
        {
          current = current.left;
          if ( current == null )
          {
            parent.left = new_node;
            return;
          }
        }
        else if ( key > current.key )        // check the right side
        {
          current = current.right;
          if ( current == null )
          {
            parent.right = new_node;
            return;
          }
        }                                    // note that duplicates
      }                                      // are not allowed
    }
  }
  /*****************************************************************************
   * Remove
   *
   * Remove a node from the tree with given key
   ****************************************************************************/
  public boolean remove( int key )
  {
    if ( this.root == null ) return false;
    Node   current = this.root;
    Node    parent = this.root;
    boolean isLeft = true;

    while ( current.key != key )          // search for node
    {
      parent = current;
      if ( key < current.key )            // look left
      {
        isLeft = true;
        current = current.left;
      }
      else                                // or look right
      {
        isLeft = false;
        current = current.right;
      }

      if ( current == null ) return false; // key not in tree

    }
      // actually do the deletion
      // make sure to accomadate for all of the variants
      if ( current.left == null && current.right == null )    // no child Nodes
      {
        if ( current == this.root )                   // if root, make it null
          root = null;
        else if ( isLeft )                            // otherwise,
          parent.left = null;                         // detatch from parent
        else
          parent.right = null;
      }
      else if ( current.right == null )                  // no right child
      {
        if ( current == this.root )
          root = current.left;
        else if ( isLeft )
          parent.left = current.left;
        else
          parent.right = current.left;
      }
      else if ( current.left == null )                   // no left child
      {
        if ( current == this.root )
          root = current.right;
        else if ( isLeft )
          parent.left = current.right;
        else
          parent.right = current.right;
      }
      else                                           // both children
      {
        // get successor node to delete
        Node successor = getSuccessor( current );

        // connect parent of current to successor instead
        if ( current == this.root )
          this.root = successor;
        else if ( isLeft )
          parent.left = successor;
        else
          parent.right = successor;

        // connect successor to current's left child
        successor.left = current.left;
      }


      return true;
    }
  /*****************************************************************************
   * GET SUCCESSOR
   *
   * Returns the next highest node after the given node
   ****************************************************************************/
  private Node getSuccessor( Node delNode )
  {
    Node parent    = delNode;
    Node successor = delNode;
    Node current   = delNode.right;

    while ( current != null )
    {
      parent = successor;
      successor = current;
      current = current.left;
    }

    if ( successor != delNode.right )
    {
      parent.left = successor.right;
      successor.right = delNode.right;
    }

    return successor;
  }
  /*****************************************************************************
   * TRAVERSE
   *
   * Traverse the tree
   ****************************************************************************/
   public void traverse( int traverseType )
   {
     switch ( traverseType )
     {
     case 1: System.out.println("Preorder Traversal:");
             preOrder( this.root );
             break;
     case 2: System.out.println("Inorder Traversal:");
             inOrder( this.root );
             break;
     case 3: System.out.println("Postorder Traversal:");
             postOrder( this.root );
             break;
    }
  }
 /******************************************************************************
  * PRE ORDER TRAVERSAL
   ****************************************************************************/
  private void preOrder( Node current )
  {
    if ( current != null )
    {
      current.displayNode();
      preOrder( current.left );
      preOrder( current.right );
    }
  }
  /*****************************************************************************
   * IN ORDER TRAVERSAL
   ****************************************************************************/
   private void inOrder( Node current )
   {
     if ( current != null )
     {
       inOrder( current.left );
       current.displayNode();
       inOrder( current.right );
     }
   }
  /*****************************************************************************
   * POST ORDER TRAVERSAL
   ****************************************************************************/
   private void postOrder( Node current )
   {
     if ( current != null )
     {
       inOrder( current.left );
       inOrder( current.right );
       current.displayNode();
     }
   }
  /*****************************************************************************
   * DISPLAY TREE
   *
   * Get the tree looking pretty for the console
   ****************************************************************************/
  public void displayTree()
  {
    Stack globalStack = new Stack();
    globalStack.push( this.root );
    int nBlanks = 32;
    boolean isRowEmpty = false;
    System.out.println(
    "........................................................................");
    while ( isRowEmpty == false )
    {
      Stack localStack = new Stack();
      isRowEmpty = true;

      for ( int i = 0 ; i < nBlanks; i++ )
        System.out.print(' ');

      while ( globalStack.isEmpty() == false )
      {
        Node temp = (Node)globalStack.pop();
        if ( temp != null )
        {
          System.out.print( temp.key );
          localStack.push( temp.left );
          localStack.push( temp.right );

          if ( temp.left != null || temp.right != null )
            isRowEmpty = false;
        }
        else
        {
          System.out.print("--");
          localStack.push( null );
          localStack.push( null );
        }

        for ( int j = 0; j < nBlanks * 2 - 2; j++ )
          System.out.print(' ');
      }

      System.out.println();
      nBlanks /= 2;

      while ( localStack.isEmpty() == false )
        globalStack.push( localStack.pop() );
    }
    System.out.println();
  }
}
/*******************************************************************************
 * MAIN ENTRY POINT
 ******************************************************************************/
class TreeApp
{
  public static void main( String [] args ) throws IOException
  {
    int value;
    Tree theTree = new Tree();

    theTree.insert( 50, 1.5 );
    theTree.insert( 25, 1.2 );
    theTree.insert( 75, 1.7 );
    theTree.insert( 12, 1.5 );
    theTree.insert( 37, 1.2 );
    theTree.insert( 43, 1.7 );
    theTree.insert( 30, 1.5 );
    theTree.insert( 33, 1.2 );
    theTree.insert( 87, 1.7 );
    theTree.insert( 93, 1.5 );
    theTree.insert( 97, 1.5 );

    while ( true )
    {
      putText("Enter first letter of ");
      putText("show, insert, find, delete, traverse, quit: ");
      int choice = getChar();
      switch (choice)
      {
      case 's':
        theTree.displayTree();
        break;
      case 'i':
        putText("Enter the value to insert: ");
        value = getInt();
        theTree.insert( value, value + 0.9);
        break;
      case 'f':
        putText("Enter the value to find");
        value = getInt();
        Node found = theTree.find( value );
        if ( found != null )
        {
          putText("Found: ");
          found.displayNode();
          putText("\n");
        }
        else
          putText("Could not find" + value + '\n');
        break;
      case 'd':
        putText("Enter value to delete: ");
        value = getInt();
        boolean deleted = theTree.remove( value );
        if ( deleted )
          putText("Deleted " + value + '\n');
        else
          putText("Could not delete " + value + '\n');
        break;
      case 't':
        putText("Enter type 1, 2, or 3: ");
        value = getInt();
        theTree.traverse( value );
        break;
      case 'q':
        System.exit(0);
        break;
      default:
        putText("Invalid entry\n");
      }
    }
  }
  /*****************************************************************************
   * PUT TEXT
   ****************************************************************************/
  public static void putText( String s )
  {
    System.out.print(s);
    System.out.flush();
  }
  /*****************************************************************************
   * GET STRING
   ****************************************************************************/
  public static String getString() throws IOException
  {
    InputStreamReader isr = new InputStreamReader( System.in );
    BufferedReader br = new BufferedReader( isr );
    String s = br.readLine();
    return s;
  }
  /*****************************************************************************
   * GET CHAR
   ****************************************************************************/
  public static char getChar() throws IOException
  {
    String s = getString();
    return s.charAt(0);
  }
  /*****************************************************************************
   * GET INT
   ****************************************************************************/
  public static int getInt() throws IOException
  {
    String s = getString();
    return Integer.parseInt( s );
  }
}
