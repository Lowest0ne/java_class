public class LinkedList
{
  // member variables
  private Link head;

  // constructor
  public LinkedList()
  {
    this.head = null;
  }

  // check if empty
  public boolean isEmpty()
  {
    return this.head == null;
  }

  // insertion
  public void insertFirst( int value )
  {
    this.head = new Link( value, this.head );
  }

  // remove firt link
  public Link deleteFirst()
  {
    if ( this.isEmpty() ) return null;
    Link temp = this.head;
    this.head = this.head.next;
    return temp;
  }

  // display the list
  public void display()
  {
    Link current = this.head;
    while ( current != null )
    {
      current.display();
      current = current.next;
    }
  }
}
