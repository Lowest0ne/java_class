
import java.io.*;

class Power
{
  public static void main( String[] args )
  throws IOException
  {
    byte bArray[] = new byte[10];
    byte cArray[] = new byte[10];
    char ans;

    try
    {
      do
      {
        System.out.print("Please enter a number: ");
        System.in.read( bArray );

        System.out.print("Please enter an exponent: ");
        System.in.read( cArray );

        String bArr = new String( bArray );
        String cArr = new String( cArray );

        int x = Integer.parseInt( bArr.trim() );
        int y = Integer.parseInt( cArr.trim() );

        long number = power( x, y );

        System.out.println( x + " raised to the power of " + y + " is "+number);

        System.out.print( "Go again (Y/N)? ");

        ans = (char)System.in.read();
        System.in.skip(2);

      } while ( Character.toUpperCase(ans) != 'N' );

    } catch ( NumberFormatException NFE )
    {
      System.out.println("You did not enter a number--goodbye!");
    }
  }

  private static long power( long num, long exp )
  {
    if ( exp == 0 )
      return 1;
    else if ( exp == 1 )
      return num;
    else
      return num + power( num, exp - 1 );
  }
}
