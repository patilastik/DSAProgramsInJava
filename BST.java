// Start date:- 11/06/26

class Node{

    Node left; // by default it contains null
    int item; // by default it stores 0
    Node right; // by default it contains null

    public Node(int data) // Constructor
     {
        item = data;
     }
}

public class BST {

    private Node root; // by default it contains null

    public void insert(int data) // Inserts an element into the tree
     {
        Node node = new Node(data);
        if(root==null) // Empty tree
         root = node;
        else // Non empty tree
         {
            Node temp = root; // Currently points to the root node
            while(true)
             {
                if(data<temp.item) // data to be inserted is less than the data of the node comparing with
                 {
                    if(temp.left==null) // no node attach to left of the current node
                     {
                        temp.left = node; // Attach the node to the left of the current node
                        break; // Terminate from the loop
                     }
                    else // if any node is attached to the left to the current node
                     temp = temp.left;
                 }
                else // data>=temp.item i.e data to be inserted is greater than or equal to the data of the node comparing with
                 {
                    if(temp.right==null) // no node attach to right of the current node
                     {
                        temp.right = node; // Attach the node to the right of the current node
                        break; // Terminate from the loop
                     }
                    else // if any node is attached to the right to the current node
                     temp = temp.right;
                 }
             }
         }   
     } 

    public void preorder()
     {
        if(root!=null) // Non empty tree
         pre(root);
        else // Empty tree
         System.out.print("Tree is empty !");
        System.out.println(); // Create a new line
     }

    private void pre(Node temp)
     {
        if(temp!=null)
         {
            System.out.print(temp.item+" ");
            pre(temp.left);
            pre(temp.right);
         }
     }
    
    public static void main(String[] args) {
        
        BST bst = new BST();
        bst.insert(90);
        bst.insert(80);
        bst.insert(100);
        bst.preorder();


    }
}
