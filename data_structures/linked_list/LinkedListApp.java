/*******************************************************************************
 * LINKED LIST APPLICATION
 *
 * Add, remove, and show values in a linked list
 ******************************************************************************/

import java.io.*;

class LinkedListApp
{
  public static void main( String []args ) throws IOException
  {
    LinkedList list = new LinkedList();
    ListIterator iter = new ListIterator( list );

    double value;

    iter.insertAfter( 20 );
    iter.insertAfter( 40 );
    iter.insertAfter( 80 );
    iter.insertAfter( 60 );

    while( true )
    {
      System.out.print("Enter the first letter of show, reset, next, get," +
                       " before, after, delete: ");
      switch( getChar() )
      {
      case 's':
        if ( !list.isEmpty() )
        {
          list.display();
        }
        else
        {
          System.out.println("The list is empty");
        }
        break;
      case 'n':
        iter.next();
        break;
      case 'r':
        iter.reset();
        break;
      case 'g':
        if ( !list.isEmpty() )
        {
          value = iter.getCurrent().value;
          System.out.println("Returned: " + value );
        }
        else
        {
          System.out.println("The list is empty");
        }
        break;
      case 'a':
        System.out.print("Enter a value to insert: ");
        System.out.flush();
        value = getInt();
        iter.insertAfter( value );
        break;
      case 'b':
        System.out.print("Enter a value to insert: ");
        System.out.flush();
        value = getInt();
        iter.insertBefore( value );
        break;
      case 'd':
        if ( !list.isEmpty() )
        {
          value = iter.deleteCurrent();
          System.out.println("Deleted: " + value );
        }
        else
        {
          System.out.println("The list is empty");
        }
        break;
      case 'q':
        System.exit(0);
        break;
      default:
        System.out.println("I'm sorry dave, I can't do that.");
      }
    }
  }

  // Works with JDK 1.1.3...
  public static String getString() throws IOException
  {
    InputStreamReader isr = new InputStreamReader( System.in );
    BufferedReader br = new BufferedReader( isr );
    return br.readLine();
  }
  public static char getChar() throws IOException
  {
    return getString().charAt(0);
  }
  public static int getInt() throws IOException
  {
    return Integer.parseInt( getString() );
  }
}
