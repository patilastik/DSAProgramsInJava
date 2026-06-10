// Date started :- 10/06/26
// Date end :- 10/06/26

class Node{

    Node prev; // by default it contains null
    int item; // by default it stores 0
    Node next; // by default it contains null

    public Node(int data) // Constructor
     {
        item = data;
     }
}

public class CDLL {

    Node head; // by default it contains null

    public CDLL(){} // 0 args constructor

    public void insertAtEnd(int data)
     {
        Node node = new Node(data); // Craeated a new node and inserted data into it
        if(head==null) // Empty list
         {
            node.prev = node; // Conatain the address of last node i.e this node itself
            node.next = node; // Conatain the address of first node i.e this node itself
            head = node; // Attach the node as a first node
         }
        else // Non empty list
         {
            node.prev = head.prev; // new node's prev points to the current last node
            node.next = head; // new node's next points to the current first node
            head.prev.next = node; // Attach  new node as a last node
            head.prev = node; // first node's prev points to this new last node
         }
     }
    
    public void insertAtFirst(int data) // Inserts a new node at the position 1
     {
        Node node = new Node(data); // Craeated a new node and inserted data into it
        if(head==null) // Empty list
         {
            node.prev = node; // Conatain the address of last node i.e this node itself
            node.next = node; // Conatain the address of first node i.e this node itself
         }
        else // Non empty list
         {
             node.prev = head.prev; // new node's prev points to the current last node
             node.next = head; // new node's next points to the current first node
             head.prev.next = node; // last node's next points to the new node
             head.prev = node; // current first node's prev points to the new node
         }
        head = node; // Attach the node as a first node
     }
    
    public boolean insertAfter(int after,int data)
     {
        boolean response = false;
        if(head!=null) // Non empty list 
        {
            Node temp = search(after);
            if(temp!=null) // data is presnet in the list
             {
               Node node = new Node(data); // Craeated a new node and inserted data into it
               node.next = temp.next;
               node.prev = temp;
               temp.next.prev = node;
               temp.next = node;
               response = true;
             }
         }
        else if(head==null) // Empty linked list
         System.out.println("Linked list is empty !");
        return (response);
     }

    public Node search(int data)
     {
        Node response = null;
        if(head!=null) // Non empty list
         {
           Node temp = head; //  Currently points to the first node
           if(head.item==data)
             response = head;
           else 
           {
             temp = temp.next; // Move of next node as first node is already checked
             do{
                if(temp.item==data) // If node with provided data found (response will never be first node in this case)
                 {
                   response = temp;
                   break;
                 }
                temp = temp.next; // Move on next node
               }while(temp!=head); // Traverse the whole list
              if(temp==head) // Response we got is first node again means, the node with provided value doesn't exists in the list
               System.out.println("Value "+ data +" is not present in the list !");
           }
         }
        else 
         System.out.println("Linked list is empty !");
        return (response);
     }

    public boolean deleteFirst()
     {
        boolean response = false;
        if(head!=null) // Non empty list
         {
            if(head==head.next) // Only 1 node is present
             head = null;
            else // At-least two nodes are there 
             {
                head.next.prev = head.prev; // current 2nd node's prev points to last node
                head.prev.next = head.next; // last node's next now points to 2nd node
                head = head.next; // 2nd node becomes 1st node
             }
            response = true;
         }
        else // Empty linked list
         System.out.println("Linked list is empty !");
        return (response);
     }
    
    public boolean deleteLast()
     {
        boolean response = false;
        if(head!=null) // Non empty list
         {
            if(head==head.next) // Only one node is present
             head = null;
            else // At-least 2 nodes are present
             {
                head.prev.prev.next = head; // 2nd last node's next points to 1st node
                head.prev = head.prev.prev; // 1st nodes prev points to 2nd last node    
             }
            response = true;
         }
        else // Empty linked list
         System.out.println("Linked list is empty !");
        return (response);
     }

    public boolean delete(int data)
     {
        boolean response = false;
        if(head!=null) // Non empty linked list
         {
            if(head.item==data) // First node to be deleted 
             return (deleteFirst());
            else // data is not in first node - let's check for other nodes
             {
                Node temp = head.next; // as first node is already checked , starting from 2nd node (if exists)
                while(temp!=head) // breaks once we reach on last node
                 {  
                    if(temp.item==data) // From current node checking for the data in next node
                     {
                        temp.prev.next = temp.next; // Previous node's next points to the next node of the node which we want to delete
                        temp.next.prev = temp.prev; // prev of next node of the node which we want to delete points to the node whic is before of the node which we want to delete
                        response = true;
                        break;
                     }
                    temp = temp.next; // Move to next node
                 }
                if(response==false)
                 System.out.println("Value "+ data +" is not present in the list !");
             }
         }
        else // Empty linked list
         System.out.println("Linked list is empty !");
        return (response);
     }

    public void display()
     {
        if(head!=null) // Non empty list
         {
           Node temp = head;
           do{
              System.out.print(temp.item+" -> ");
              temp = temp.next; // Move on next node
            }while(temp!=head); // breaks once we again reach on first node
           System.out.println(); // To create a new line after displaying the list
         } 
        else // empty list
         System.out.println("Linked list is empty !");
     }

    public void emptyList()
     {
         if(head!=null) // Non empty list
         {
            head.prev.next = null; // last node's (or 1st node's, if only 1 node is there) next contains null 
            head = null; // no one is pointing to 1st node hence it will be removed and one by one all will be removed by garbage collector
         }
     }

    public CDLL(CDLL ref) // Copy constructor
     {
       if(ref.head!=null) // Another list is non empty
        {
          Node temp1 = ref.head; // Currently points to the 1st node of another list
          Node node = new Node(temp1.item);
          node.prev = node; // As 1st node is the last node
          node.next = node; // As 1st node is the last node
          head = node; // Attached the 1st node
          temp1 = temp1.next; // Move on next node
          while(temp1!=ref.head) // Traverse the another linked list and copy node values from there
           {
             insertAtEnd(temp1.item);
             temp1 = temp1.next;
           }
        }
     }

    public void copy(CDLL ref) // Alternative to overloaded assignment operator
     {
       if(this!=ref) // Both are different object
        {
          emptyList(); // Makes the current list empty, if current list is not empty 
          if(ref.head!=null) // If another list is non empty
           {
             Node temp1 = ref.head; // Currently points to the 1st node of another list
             Node node = new Node(temp1.item);
             node.prev = node; // As 1st node is the last node
             node.next = node; // As 1st node is the last node
             head = node; // Attached the 1st node
             temp1 = temp1.next; // Move on next node
             while(temp1!=ref.head) // Traverse the another linked list and copy node values from there
              {
                insertAtEnd(temp1.item);
                temp1 = temp1.next;
              }
           }
        }
     }

    public static void main(String[] args) {

        CDLL list = new CDLL();
        list.insertAtEnd(10);
        list.insertAtEnd(20);

        CDLL list2 = new CDLL(list);
        list2.insertAtEnd(100);
        list2.insertAtEnd(200);
        
        list2.copy(list);
        list2.display();
        
    }
}
