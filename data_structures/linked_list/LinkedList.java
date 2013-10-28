/*******************************************************************************
 * LINKED LIST
 ******************************************************************************/
public class LinkedList
{
  private Link head;

  // contstructor
  public LinkedList()
  {
    this.head = null;
  }

  // get first link in list
  public Link getHead()
  {
    return this.head;
  }

  // set first to new link
  public void setHead( Link head )
  {
    this.head = head;
  }

  // check if list is empty
  public boolean isEmpty()
  {
    return this.head == null;
  }

  // get an iterator to the list
  public ListIterator getIterator()
  {
    return new ListIterator( this );
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
