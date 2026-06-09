// Date started :- 09/06/26
// Date end :- 09/06/26
class Node{

    int item; // by default it stores 0
    Node next; // by default it contains null

    public Node(int data) // Constructor
     {
        item = data;
     }
}

public class CLL {

    Node last; // by default it contains null

    public CLL(){} // 0 args constructor

    public void insertAtEnd(int data)
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

    public void insertAtFirst(int data) // Inserts a new node at the position 1
     {
        Node node = new Node(data); // Craeated a new node and inserted data into it
        if(last==null) // Empty linked list
         {
            node.next = node;
            last = node;
         }
        else // Non empty list
         {
            node.next = last.next; // new node's next points to current first node 
            last.next = node; // new node becomes first node now 
         }
     }
    
    public boolean insertAfter(int after,int data)
     {
        boolean response = false;
        if(last!=null) // Non empty list
        {
            Node temp = search(after);
            if(temp!=null) // Data is present in the list 
             {
                Node node = new Node(data); // Craeated a new node and inserted data into it
                node.next = temp.next;
                temp.next = node;
                if(temp==last) // If the node after which new node is attached is the last node
                 last = node;
                response = true;
             }
         }
        else if(last==null) // Empty linked list
         System.out.println("Linked list is empty !");
        return (response);
     }

    public Node search(int data)
     {
        Node response = null;
        if(last!=null) // Non empty list
         {
           Node temp = last.next; //  Currently points to the first node
           if(temp.item==data) // If the data found in the first node
            response = temp;
           else
           {
            do{
              if(temp.item==data) // If node with provided data found
               {
                 response = temp;
                 break;
               }
              temp = temp.next; // Move on next node
              }while(temp!=last.next);
              if(temp==last.next) // Back to the first node - means data is not found in the linked list
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
        if(last!=null) // Non empty list
         {
            if(last.next==last) // Only one node is there 
             last = null;
            else // At-least 2 nodes are there 
             last.next = last.next.next; // i.e making 2nd node as a first node
            response = true;
         }
        else // Empty linked list
         System.out.println("Linked list is empty !");
        return (response);
     }
    
    public boolean deleteLast()
     {
        boolean response = false;
        if(last!=null) // Non empty list
         {
            if(last.next==last) // Only one node is present
             last = null;
            else // At-least 2 nodes are present
             {
                Node temp = last.next; // Currently points to the first node
                while(temp.next!=last) // breaks once we reach on 2nd last node
                 temp = temp.next; // Move on next node
                temp.next = last.next; // 2nd last node's next points to first node
                last = temp;  // Make the 2nd last node as the last node
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
        if(last!=null) // Non empty linked list
         {
            Node temp = last.next; // Currently points to the first node
            if(temp.item==data) // First node to be deleted
             return (deleteFirst());
            else // data is not in first node - let's check for other nodes
             {
                while(temp!=last) // breaks once we reach on last node
                 {
                    if(temp.next.item==data) // From current node checking for the data in next node
                     {
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
         System.out.println("Linked list is empty !");
     }

    public CLL(CLL ref) // Copy constructor
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

    public void copy(CLL ref) // Alternative to overloaded assignment operator
     {
       if(this!=ref) // Both are different object
        {
          if(last!=null) // If current linked list is not empty - make it empty
           emptyList();
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

    public void emptyList() // Alternative to destructor
     {
        last.next = null; // No one is pointing to 1st node hence it will be deleted and serially all nodes will be deleted except last node
        last = null; 
     }

    public static void main(String[] args) {
        CLL list = new CLL();
        
        list.insertAtEnd(10);
        list.insertAtEnd(20);
        
        CLL list2 = new CLL();
        list2.insertAtEnd(100);
        list2.insertAtEnd(200);
        list2.display();
        list2.copy(list);
        list2.display();

    }
}
