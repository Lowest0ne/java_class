public class Link
{
  // member variables
  public int value;
  public Link next;

  // constructor
  public Link( int value )
  {
    this.value = value;
    this.next = null;
  }

  // print to console
  public void display()
  {
    System.out.println( this + " " + this.next + " " + this.value );
  }
}
