// Date started :- 06/06/26
// Date finished :- 06/06/26

public class StaticArray {

    // Member variables

    private int tv,size; // defualt value 0 get stores automatically 
    private int []arr = null;

    // Member functions

    public StaticArray(){} // 0 args constructor

    public StaticArray(int size) // Constructor
     {
        this.size = size; // store the size value
        arr = new int[size]; // create an array of that respective size
     }
    
    public void display() // display values inside of a array on a screen
     {
        if(tv!=0)
         {
            System.out.print("[ ");
            for(int i=0;i<tv;i++)
             System.out.print(arr[i]+" ");
            System.out.print("]");
         }
        else 
         System.out.println("Empty Array !");
        System.out.println();
     }
    
    public void insertAtEnd(int data) // Inserts a new element after last filled block
     {
        if(tv<size) // There is a space to add a new element
         {
            arr[tv] = data;
            tv++;
         }
        else // array is full
         System.out.println("Array is Full !");
     }

    public boolean insertAtFirst(int data) // Inserts a new element at index 0
     {
        boolean response = false;
        if(tv<size) // Array is not full
         {
            if(tv!=0) // Array is not empty - perform shifting of elements
             {
               for(int i=tv;i>0;i--)
                arr[i] = arr[i-1];
             }
            arr[0] = data;
            tv++;
            response =  true;
         }
        else 
         System.out.println("Array is Full !");
        return (response);
     }

    public boolean insertAt(int index, int data)
     {
        boolean response = false;
        if(index>=0 && index<=tv)  // Valid index
         {
             if(tv<size) // Array is not full
              {
                 if(tv!=0) // Array is not empty - perform shifting of elements
                  {
                    for(int i=tv;i>index;i--)
                     arr[i] = arr[i-1];
                  }
                 arr[index] = data;
                 tv++;
                 response =  true;
              }
             else 
              System.out.println("Array is Full !");
         }
        else 
         System.out.println("Invalid index !");
        return (response);
     }

    public boolean deleteLast() // deletes the last stored value of a array
     {
        return (deleteAtIndex(tv-1));
     }

    public boolean deleteFirst()
     {
        return (deleteAtIndex(0));
     }
    
    public boolean deleteAtIndex(int index)
     {
        boolean response = false;
        if(index>=0 && index<=tv)  // Valid index
         {
            if(tv!=0) // non empty array
             {
                for(int i=index;i<tv-1;i++)
                 arr[i] = arr[i+1];
                tv--;
                response = true;
             }
            else 
             System.out.println("Empty array !");
         }
        else // Invalid index
         System.out.println("Invalid index !");
        
        return (response);
     }

    // returns -1 => Data is not present in an array
    // return any other value => Index of that data
    public int search(int data) // Search an element in a array 
     {
        int response = -1;
        if(tv!=0) // Non empty array
         {
           for(int i=0;i<tv;i++)
            {
               if(arr[i]==data)
                {
                   response = i;
                   break;
                }
            }
           if(response==-1) // Value not found
            System.out.println("Value is not present in the array !\n");
         }
        else 
         System.out.println("Empty array !");
        return (response);
     }

    public boolean remove(int data) // removes the provided value from the array(if presents)
     {
        boolean response = false;
        if(tv!=0) // Non empty array
         {
           int index = search(data);
           if(index!=-1) // Value is presnet in the array
            {
             deleteAtIndex(index);
             response = true;
            }
         }
        else 
         System.out.println("Empty array !");
        return (response);
     }

     
     public boolean isEmpty() // checks whether array is empty or not 
     {
         return (tv==0);
        }
        
        public boolean isFull() // checks whether array is full or not
        {
            return (tv==size);
        }
    
    public int actualValues() // returns the total number of actual values stores
    {
        return (tv);
    }
    
    public int emptyBlocks() // returns the total number of empty blocks where values can be stored
    {
        return (size-tv);
    }
    
    public StaticArray(StaticArray ref) // Copy constructor
     {
        tv = ref.tv;
        size = ref.size;
        arr = new int[size];
        if(ref.tv!=0) // Another array is not empty
         {
          for(int i=0;i<ref.tv;i++)
           arr[i] = ref.arr[i];
         }
     }


    public void copy(StaticArray ref) // Alternative to overloaded assignment operator
     {
         if(this!=ref) // Both are different objects
         {
           tv = ref.tv;
           size = ref.size;
           arr = new int[size]; // old array will automatically cleaned by garbage collctor
           if(ref.tv!=0) // Another array is not empty
            {
              for(int i=0;i<ref.tv;i++)
               arr[i] = ref.arr[i];
            }
         }
     }
    
    public static void main(String[] args) 
    {
        StaticArray arr = new StaticArray(5);
       arr.insertAtEnd(10);
       arr.insertAtEnd(20);
       arr.insertAtEnd(30);
       StaticArray arr2 = new StaticArray(arr);
       arr.deleteFirst();
       arr2.display();
     } 
} // class ends here