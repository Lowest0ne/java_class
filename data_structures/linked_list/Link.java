/*******************************************************************************
 * LINK
 ******************************************************************************/
public class Link
{
  public double value;
  public Link next;

  // constructor
  public Link( double value )
  {
    this.value = value;
    this.next = null;
  }

  // display
  public void display()
  {
    System.out.println( this + " " + this.next + ": " + this.value );
  }
}
