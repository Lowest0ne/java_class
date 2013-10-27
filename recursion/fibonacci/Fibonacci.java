
class Fibonacci
{
  public void print()
  {
    // print the first ten fibonacci numbers
    for ( int counter = 0; counter <= 10; counter++ )
      System.out.printf("%s %d\n", "counter= ", fibonacci( counter ) );

    // print the 20th, 30th, and 35th fibonacci numbers
    System.out.printf( "%s %d\n", "fibonacci(20) = ", fibonacci( 20 ));
    System.out.printf( "%s %d\n", "fibonacci(20) = ", fibonacci( 30 ));
    System.out.printf( "%s %d\n", "fibonacci(20) = ", fibonacci( 35 ));
  }

  private long fibonacci( long number )
  {
    if ( number == 0 || number == 1 )
      return number;
    else
      return fibonacci( number - 1 )  + fibonacci( number - 2 );
  }

  public static void main( String [] args )
  {
    Fibonacci myFib = new Fibonacci();
    myFib.print();
  }
}
