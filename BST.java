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
   public void inorder()
    {
       if(root!=null) // Non empty tree
        in(root);
       else // Empty tree
        System.out.print("Tree is empty !");
       System.out.println(); // Create a new line
    }
   private void in(Node temp)
    {
       if(temp!=null)
        {
           pre(temp.left);
           System.out.print(temp.item+" ");
           pre(temp.right);
        }
    }
   public void postorder()
    {
       if(root!=null) // Non empty tree
        post(root);
       else // Empty tree
        System.out.print("Tree is empty !");
       System.out.println(); // Create a new line
    }
   private void post(Node temp)
    {
       if(temp!=null)
        {
           pre(temp.left);
           pre(temp.right);
           System.out.print(temp.item+" ");
        }
    }
   public int totalNodes()
    {
       return (total(root));
    }
   private int total(Node temp) 
    {  int sum = 0;
       if(temp!=null)
        {
           sum++;
           sum += total(temp.left);
           sum += total(temp.right);
        }
       return (sum);
    }
   
   public boolean delete(int data) // Leaf node case is handled in this method itself
    {
      boolean isDelete = false;
      if(root!=null) // Non empty tree
       {
         if(root.item==data) // root node case
          {
            if(root.left==null && root.right==null) // Only root node is remains in the tree
             root = null;
            else // More than 1 nodes are present
             deleteNonLeaf(root,root);
            isDelete =  true;
          }
         else  // Finding the node to delete
          {
            Node temp1 = root;
            Node temp2 = root;
    
            while(true) // Used to found the node which we want to delete 
            {
              if(data<temp2.item) // If the data is less than the comparing node's data
               {
                 if(temp2.left!=null) // node exists on left side of temp2
                  {
                    temp1 = temp2; // Child becomes parent
                    temp2 = temp2.left; // Move temp2 to left child
                  }
                 else // node doesn't exists on left side of temp2
                   break;
               }
              else if(data>temp2.item)
               {
                 if(temp2.right!=null) // node exists on right side of temp2
                  {
                    temp1 = temp2; // Child becomes parent
                    temp2 = temp2.right; // Move temp2 to right child
                  }
                 else 
                   break;
               }
              else // When the node containing the data found
               {
                 if(temp2.left==null && temp2.right==null) // Leaf node case
                  {
                    if(temp2.item<temp1.item) // Leaf node is on left to it's parent
                     temp1.left = null;
                    else // Leaf node is on right to it's parent
                     temp1.right = null;
                  }
                 else // Non root and non leaf node case
                  {
                    deleteNonLeaf(temp1,temp2);
                  }
                 isDelete = true;
                 break;
               }
            } // while loop ends here
          } // else block ends here
       }
      return (isDelete);
    } // Method ends here

   private void deleteNonLeaf(Node temp1,Node temp2) // Will handle root node and non leaf node case
    {
      if(temp2.left!=null && temp2.right==null) // Having only left child no right child
       {
         if(temp1==temp2) // root node case
          root = root.left;
         else // non root node case
          {
            // Deciding whether the left child of the node which we want to delete will be left or right to the parent
            if(temp2.item<temp1.item) // parent and child are in left subtree or parent is root and child is left node
             temp1.left = temp2.left;
            else // // parent and child are in right subtree or parent is root and child is right node
             temp1.right = temp2.left;
          }
       }
      else if(temp2.left==null && temp2.right!=null) // Having only right child no left child
       {
         if(temp1==temp2) // root node case
          root = root.right;
         else // Non root node case
          {
            // Deciding whether the right child of the node which we want to delete will be left or right to the parent
            if(temp2.item>temp1.item) // parent and child are in right subtree or parent is root and child is right node
             temp1.right = temp2.right;
            else // parent and child are in left subtree or parent is root and child is left node
             temp1.left = temp2.right;
          }
       }
      else // Having both the childs
       {
         Node temp = temp2.left; // Points to the left child of the node which we want to delete
         if(temp.right==null) // Left node of the node which we want to delete don't have right subtree
          {
            temp.right = temp2.right; // Right subtree of nod which we want to delete now will become right subtree of left child of node which we want to delete
            if(temp1!=temp2) // Non root node case
             temp1.left = temp;
            else // root node case
             root = temp;
          }
         else 
          {
            while(temp.right!=null && temp.right.right!=null) // Traverse upto the parent of the rightmost node of left subtree of the node which we want to delete
             temp = temp.right; // Move on right node
            temp2.item = temp.right.item;
            temp.right = null;
         } 
       }
    }
   public static void main(String[] args) {
       
       BST bst = new BST();
       bst.insert(100);
       bst.insert(110);
       bst.preorder();
       System.out.println(bst.delete(100));
       bst.preorder();
   }
}
