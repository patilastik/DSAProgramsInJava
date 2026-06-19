// Date started :- 18/06/26

class EmptyQueueException extends RuntimeException{
   @Override
   public String toString() {
       return ("Queue is empty !");
   }
}

class Node{

    int item; // by default it stores 0
    Node next; // by default it contains null

    public Node(int data) // Constructor
     {
        item = data;
     }
}

public class Queue {

    private Node last; // by default it contains null

    public Queue(){} // 0 args constructor

    public void Enqueue(int data)
     {
        Node node = new Node(data); // Craeated a new node and inserted data into it
        if(last==null) // Empty list
         node.next = node; // Last node is the first node
        else // Non empty list
         {
            node.next = last.next; // next of the new node will point to the first node
            last.next = node; // Attach a node to the end of ths list
         }
        last = node; 
    }

    public boolean Dequeue()
     {
        boolean response = false;
        if(last!=null) // Non empty list
         {
            if(last.next==last) // Only one node is there 
             last = null;
            else // At-least 2 nodes are there 
             last.next = last.next.next; // i.e making 2nd node as a first node
            response = true;
         }
        else // Empty linked list
         System.out.println("Queue is empty !");
        return (response);
     }

    public void display() // Display the linked list 
     {
        if(last!=null) // Non empty list
         {
           Node temp = last.next; // Currently points to the first node
           do{
             System.out.print(temp.item+" -> ");
             temp = temp.next; // Move on next node
             }while(temp!=last.next);
           System.out.println(); // To create a new line after displaying the list
         } 
        else // empty list
         System.out.println("Queue is empty !");
     }

     public int getFront()
      {
         try{
            if(last!=null) // Non empty list
             return (last.next.item);
            throw new EmptyQueueException();
         }
         catch(EmptyQueueException e)
          {
            System.out.println(e);
            return (-1);
          }
      }

     public int totalElements()
      {
         int total = 0;
         if(last!=null) // Non empty queue
          {
            Node temp = last.next; // Currently points to the first node
           do{
             total++;
             temp = temp.next; // Move on next node
             }while(temp!=last.next);
          }
         return (total);
      }

     public int getRear()
      {
         try{
            if(last!=null) // Non empty list
             return (last.item);
            throw new EmptyQueueException();
         }
         catch(EmptyQueueException e)
          {
            System.out.println(e);
            return (-1);
          }
      }

     public void emptyQueue() // Alternative to destructor
      {
         if(last!=null) // If queue is not empty
          {
            last.next = null; // No one is pointing to 1st node hence it will be deleted and serially all nodes will be deleted except last node
            last = null; // This will delete the last node 
         }
      }

    public Queue(Queue ref) // Copy constructor
     {
       if(ref.last!=null) // Another list is non empty
        {
          Node temp1 = ref.last.next; // Currently points to the 1st node of another list
          Node node = new Node(temp1.item);
          node.next = node; // First node is the last node
          last = node; // Attached the 1st node
          temp1 = temp1.next; // Move on next node
          while(temp1!=ref.last.next) // Traverse the another linked list and copy node values from there
           {
             node = new Node(temp1.item); // Create a new node
             node.next = last.next;  // new node's next points to first node
             last.next = node; // Attach new node
             last = node; // Make the newly added node as the last node
             temp1 = temp1.next; // Move on next node of another list
           }
        }
     }

    public void copy(Queue ref) // Alternative to overloaded assignment operator
     {
       if(this!=ref) // Both are different object
        {
          if(last!=null) // If current linked list is not empty - make it empty
           emptyQueue();
          if(ref.last!=null) // If another list is non empty
           {
             Node temp1 = ref.last.next; // Currently points to the 1st node of another list
             Node node = new Node(temp1.item);
             node.next = node; // First node is the last node
             last = node; // Attached the 1st node
             temp1 = temp1.next; // Move on next node
             while(temp1!=ref.last.next) // Traverse the another linked list and copy node values from there
              {
                node = new Node(temp1.item); // Create a new node
                node.next = last.next;  // new node's next points to first node
                last.next = node; // Attach new node
                last = node; // Make the newly added node as the last node
                temp1 = temp1.next; // Move on next node of another list
              }
           }
        }
     }


    public static void main(String[] args) {
        Queue queue = new Queue();

        queue.Enqueue(10);
        queue.Enqueue(20);
        queue.Enqueue(30);

        System.out.println(queue.getRear());
    }
}

