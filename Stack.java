// Start Date :- 19/06/26

class EmptyStackException extends RuntimeException{
   @Override
   public String toString() {
       return ("Stack is empty !");
   }
}

class Node{

    public int item; // by default it stores 0
    public Node next; // by default it contains null

    public Node(int data) // Constructor
     {
        item = data;
     }
}

public class  Stack{

    private Node head; // by default it contains null

    public Stack(){} // 0 args constructor
    
    public void push(int data) // Inserts a new node at the position 1
     {
        Node node = new Node(data); // Craeated a new node and inserted data into it
        node.next = head;
        head = node;
     }

    public int pop() // Deletes the first element of the stack
     {
        int data;
        try{
            if(head!=null) // Non empty stack
             {
                data = head.item;
                head = head.next;
             }
            else // Empty linked stack
             throw new EmptyStackException();
        }
        catch(EmptyStackException e){
            System.out.println(e);
            data = -1;
        }
        return (data);
     }
    
    public int peek() // returns the top element of the stack
     {
        try{
         if(head!=null)
          return (head.item);
         else 
          throw new EmptyStackException();
        }
        catch(EmptyStackException e){
            System.out.println(e);
            return (-1);
        }
     }

    public void display()
     {
        if(head!=null) // Non empty stack
         {
           Node temp = head;
           while(temp!=null) 
           {
             System.out.print(temp.item+" -> ");
             temp = temp.next; // Move on next node
           }
           System.out.println(); // To create a new line after displaying the stack
         } 
        else // empty stack
         System.out.println("Stack is empty !");
     }
    
    public void reverse()
     {
        if(head!=null)
         {
            Stack temp = new Stack(); // Created a new stack
            while(head!=null)
             {
                temp.push(peek());
                pop(); // Delete the top element from the current stack 
             }
            head = temp.head;
         }
     }

    public Stack(Stack ref) // Copy constructor
     {
       if(ref.head!=null) // Another stack is non empty
        {
          Node temp1 = ref.head; // Currently points to the 1st node of another stack
          Node node = new Node(temp1.item);
          head = node; // Attached the 1st node
          Node temp2 = head; // Currently points to first node of current stack
          temp1 = temp1.next; // Move on next node
          while(temp1!=null) // Traverse the another linked stack and copy node values from there
           {
             node = new Node(temp1.item); // Create a new node
             temp2.next = node; // Attach new node 
             temp1 = temp1.next; // Move on next node of another stack
             temp2 = temp2.next; // Move on newly attached last node of current stack
           }
        }
     }

    public void copy(Stack ref) // Alternative to overloaded assignment operator
     {
       if(this!=ref) // Both are different object
        {
          head = null; // if current stack has nodes then, they will be removed by garbage collector
          if(ref.head!=null) // Ifa nother stack is non empty
           {
             Node temp1 = ref.head; // Currently points to the 1st node of another stack
             Node node = new Node(temp1.item);
             head = node; // Attached the 1st node
             Node temp2 = head; // Currently points to first node of current stack
             temp1 = temp1.next; // Move on next node
             while(temp1!=null) // Traverse the another linked stack and copy node values from there
              {
                node = new Node(temp1.item); // Create a new node
                temp2.next = node; // Attach new node 
                temp1 = temp1.next; // Move on next node of another stack
                temp2 = temp2.next; // Move on newly attached last node of current stack
              }
           }
        }
     }
    
    public void emptyStack()
     {
        head = null; // All the nodes will be removed by garbage collector
     }

    public static void main(String[] args) {

        Stack stack = new Stack();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.display();
        stack.reverse();
        stack.display();
        
    }
}
