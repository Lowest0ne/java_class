public class LinkedStack
{
  private LinkedList list;

  // constructor
  public LinkedStack()
  {
    this.list = new LinkedList();
  }

  // push item onto stack
  public void push( int value )
  {
    this.list.insertFirst( value );
  }

  // pop an item from the stack
  public int pop()
  {
    return this.list.deleteFirst().value;
  }

  // check if empty
  public boolean isEmpty()
  {
    return this.list.isEmpty();
  }
}
