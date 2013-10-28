/*******************************************************************************
 * LINKED LIST ITERATOR
 ******************************************************************************/
public class ListIterator
{
  private Link current;
  private Link previous;
  private LinkedList list;

  // constructor
  public ListIterator( LinkedList list )
  {
    this.list = list;
    this.reset();
  }

  // reset the list to the beginning
  public void reset()
  {
    this.current = this.list.getHead();
    previous = null;
  }

  // check if the iterator is at the end
  public boolean atEnd()
  {
    return current == null || current.next == null;
  }

  // get the next link in the list
  public void next()
  {
    this.previous = this.current;
    this.current = this.current.next;
  }

  // get the current link
  public Link getCurrent()
  {
    return this.current;
  }

  // insert a value after the current position
  public void insertAfter( double value )
  {
    Link new_link = new Link( value );

    if ( this.list.isEmpty() )
    {
      this.list.setHead( new_link );
      this.current = new_link;
    }
    else
    {
      new_link.next = current.next;
      this.current.next = new_link;
      this.next();
    }
  }

  // insert a value before the current position
  public void insertBefore( double value )
  {
    Link new_link = new Link( value );

    if ( this.previous == null )
    {
      new_link.next = this.list.getHead();
      this.list.setHead( new_link );
      this.reset();
    }
    else
    {
      new_link.next = this.previous.next;
      this.previous.next = new_link;
      this.current = new_link;
    }
  }

  // delete the current link
  public double deleteCurrent()
  {
    double value = this.current.value;
    if ( this.previous == null )
    {
      this.list.setHead( this.current.next );
      reset();
    }
    else
    {
      this.previous.next = this.current.next;
      if ( this.atEnd() )
      {
        this.reset();
      }
      else
      {
        this.current = this.current.next;
      }
    }
    return value;
  }
}
