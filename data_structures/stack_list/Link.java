/*******************************************************************************
 * LINK
 ******************************************************************************/
public class Link
{
  public int value;
  public Link next;

  // constructor
  public Link( int value, Link next )
  {
    this.value = value;
    this.next = next;
  }

  // display
  public void display()
  {
    System.out.println( this + " " + this.next + ": " + this.value );
  }
}
