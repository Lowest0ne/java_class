public class SortedList
{
  // member variables
  private Link head;

  // constructor
  public SortedList()
  {
    this.head = null;
  }

  // check if empty
  public boolean isEmpty()
  {
    return this.head == null;
  }

  // insertion
  public void insert( int value )
  {
    Link new_link = new Link( value );
    Link previous = null;
    Link current  = this.head;

    while ( current != null && value > current.value )
    {
      previous = current;
      current  = current.next;
    }

    if ( previous == null )
    {
      new_link.next = this.head;
      this.head = new_link;
    }
    else
    {
      previous.next = new_link;
      new_link.next = current;
    }
  }

  // remove firt link
  public Link pop()
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



