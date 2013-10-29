class LinkedStackApp
{
  private LinkedStack stack;

  public LinkedStackApp()
  {
    this.stack = new LinkedStack();
  }

  public void push( int value )
  {
    this.stack.push( value );
    System.out.println("Pushed: " + value );
  }

  public void pop()
  {
    int value = this.stack.pop();
    System.out.println("Popped: " + value );
  }

  public boolean isEmpty()
  {
    return this.stack.isEmpty();
  }

  public static void main( String [] args )
  {
    LinkedStackApp app = new LinkedStackApp();
    for ( int i = 0 ; i < 10; i++ )
      app.push( (int)(Math.random() * 50 ) );

    while (!app.isEmpty()) app.pop();
  }
}
