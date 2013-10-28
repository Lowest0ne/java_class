class SortedListApp
{
  public static void insert( SortedList list, int value )
  {
    list.insert( value );
    System.out.println("Inserted: " + value );
  }

  public static void remove( SortedList list )
  {
    Link removed = list.pop();
    System.out.print("Removed: ");
    removed.display();
  }

  public static void display( SortedList list )
  {
    System.out.println("Displaying List");
    list.display();
  }


  public static void main( String [] args )
  {

    SortedList list = new SortedList();

    int [] numbers = new int[10];
    for ( int i = 0; i < numbers.length; i++)
    {
      numbers[i] = (int)(Math.random() * 50);
      insert( list, numbers[i] );
    }

    display( list );

    for ( int i = 0; i < numbers.length / 2; i++)
      remove( list );

    display( list );
  }
}


