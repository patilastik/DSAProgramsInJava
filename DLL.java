// Date started :- 09/06/26
// Date end :- 09/06/26

class Node{

    Node prev; // by default it contains null
    int item; // by default it stores 0
    Node next; // by default it contains null

    public Node(int data) // Constructor
     {
        item = data;
     }
}

public class DLL {

    Node head; // by default it contains null

    public DLL(){} // 0 args constructor

    public void insertAtEnd(int data)
     {
        Node node = new Node(data); // Craeated a new node and inserted data into it
        if(head==null) // Empty list
         head = node;
        else // Non empty list
         {
            Node temp = head; // will initially point to first node
            while(temp.next!=null)  // breaks once we reach on last node
             temp = temp.next; // Move on next node
            node.prev = temp;
            temp.next = node; // Attach a node to the end of ths list
         }
     }

    public void insertAtFirst(int data) // Inserts a new node at the position 1
     {
        Node node = new Node(data); // Craeated a new node and inserted data into it
        if(head!=null) // Non empty list
         head.prev = node; // current first nodes's prev will point to newly created node
        node.next = head;
        head = node;
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
               if(temp.next!=null) // means temp is not the last node
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
           while(temp!=null) // Traverse the whole list
           {
             if(temp.item==data) // If node with provided data found
              {
                response = temp;
                break;
              }
             temp = temp.next; // Move on next node
            }
            if(temp==null) // If the node with provided value doesn't exists in the list
             System.out.println("Value "+ data +" is not present in the list !");
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
            head = head.next;
            if(head!=null) // List is still not empty
             head.prev = null;
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
            if(head.next==null) // Only one node is present
             head = null;
            else // At-least 2 nodes are present
             {
                Node temp = head; // Currently points to the first node
                while(temp.next.next!=null) // breaks once we reach on 2nd last node
                 temp = temp.next;
                temp.next = null;    
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
             {
               head = head.next;
               if(head!=null) // If list doens't becomes empty
                head.prev = null;
               response = true;
             }
            else // data is not in first node - let's check for other nodes
             {
                Node temp = head;
                while(temp.next!=null) // breaks once we reach on last node
                 {
                    if(temp.next.item==data) // From current node checking for the data in next node
                     {
                        if(temp.next.next!=null) // When node to be deleted is not the last node
                         temp.next.next.prev = temp;
                        temp.next = temp.next.next;
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
           while(temp!=null) 
           {
             System.out.print(temp.item+" -> ");
             temp = temp.next; // Move on next node
           }
           System.out.println(); // To create a new line after displaying the list
         } 
        else // empty list
         System.out.println("Linked list is empty !");
     }

    public DLL(DLL ref) // Copy constructor
     {
       if(ref.head!=null) // Another list is non empty
        {
          Node temp1 = ref.head; // Currently points to the 1st node of another list
          Node node = new Node(temp1.item);
          head = node; // Attached the 1st node
          Node temp2 = head; // Currently points to first node of current list
          temp1 = temp1.next; // Move on next node
          while(temp1!=null) // Traverse the another linked list and copy node values from there
           {
             node = new Node(temp1.item); // Create a new node
             node.prev = temp2; // Prev will point back to current last node
             temp2.next = node; // Attach new node 
             temp1 = temp1.next; // Move on next node of another list
             temp2 = temp2.next; // Move on newly attached last node of current list
           }
        }
     }

    public void copy(DLL ref) // Alternative to overloaded assignment operator
     {
       if(this!=ref) // Both are different object
        {
          head = null; // if current list has nodes then, they will be removed by garbage collector
          if(ref.head!=null) // Ifa nother list is non empty
           {
             Node temp1 = ref.head; // Currently points to the 1st node of another list
             Node node = new Node(temp1.item);
             head = node; // Attached the 1st node
             Node temp2 = head; // Currently points to first node of current list
             temp1 = temp1.next; // Move on next node
             while(temp1!=null) // Traverse the another linked list and copy node values from there
              {
                node = new Node(temp1.item); // Create a new node
                node.prev = temp2; // Prev will point back to current last node
                temp2.next = node; // Attach new node 
                temp1 = temp1.next; // Move on next node of another list
                temp2 = temp2.next; // Move on newly attached last node of current list
              }
           }
        }
     }

    public static void main(String[] args) {
        DLL list = new DLL();
        list.insertAfter(0, 0);
    }
}
