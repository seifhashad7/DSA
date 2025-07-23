import java.util.ArrayList;

public class PQueue {
    ArrayList<Integer> arr;

    PQueue(ArrayList<Integer> a)
    {
        arr = a;
    }

    //Heapify
    public void heapify(ArrayList<Integer> arr, int root)
    {
        int largest = root;
        int left = 2*root + 1;
        int right = 2*root + 2;

        if(left < arr.size() && arr.get(left) > arr.get(root))      largest = left;
        if(right < arr.size() && arr.get(right) > arr.get(root))    largest = right;

        if(root != largest)
        {
            //Swap between the new largest (right or left) and root
            int temp = arr.get(largest);
            arr.set(largest, arr.get(root));
            arr.set(root, temp); 

            heapify(arr, largest);
        }
    }

    //Enqueue
    public void enqueue(ArrayList<Integer> arr, int ele)
    {
        arr.add(ele);
        
        if(arr.size() != 0)
        {
            for(int i = arr.size()/2 - 1; i >= 0; i--)
            {
                heapify(arr, i);
            }
        }
    }

    public void dequeue(ArrayList<Integer> arr, int num)
    {
        int i = 0;
        
        //Getting the target element
        for(i = 0; i < arr.size(); i++)
        {
            if(num == arr.get(i))
            {
                break;
            }
        }
        
        //Swap between num and the last element
        int temp = arr.get(i);
        arr.set(i, arr.get(arr.size()-1));
        arr.set(arr.size()-1, temp);

        //Remove the last element
        arr.remove(arr.size()-1);

        //heapify it
        for(int j= arr.size()/2 - 1; j >= 0; j--)
        {
            heapify(arr, j);
        }
    }

    public void printQueue(ArrayList<Integer> arr)
    {
        System.out.println(arr);
    }

    public static void main(String[] args)
    {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(15);
        arr.add(20);
        arr.add(90);
        arr.add(3);
        arr.add(77);
        
        PQueue pq = new PQueue(arr);
        pq.dequeue(arr, 90);
        pq.printQueue(arr);
    } 
}
