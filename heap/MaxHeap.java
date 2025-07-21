import java.util.ArrayList;

public class MaxHeap implements Heap {
    private ArrayList<Integer> array;

    public MaxHeap()
    {
        array = new ArrayList<>();
    }

    public void heapify(int i)
    {
        int size = array.size();
        int largest = i;
        int leftChild = 2*i + 1;
        int rightChild = 2*i +2;

        //if left/right node is bigger than the largest node, update the largest
        if((leftChild < size)  && (array.get(leftChild)  > array.get(largest)))   largest = leftChild;
        if((rightChild < size) && (array.get(rightChild) > array.get(largest)))   largest = rightChild;

        //if the root node is not the largest node, keep recursing until the array is heapified.
        if(largest != i)
        {
            //Swap between largest and i
            swap(largest, i);
            heapify(largest);
        }
    }

    //Insertion using heapify, less efficient O(n)
    public void insert(int newNum)
    {
        //Insertion in the last element in the array
        array.add(newNum);

        //heapify
        for(int i = (array.size() / 2) - 1; i >= 0; i--)
        {
            heapify(i);
        }
    }


    //Insertion using bubble-up / sift-up O(log(n))
    public void insertNode(int newNum)
    {
        //Insertion in the last element in the array
        array.add(newNum);

        int current = array.size() - 1;
        //Bubble up
        while(current > 0 && array.get(current) > array.get(parent(current)))
        {
            swap(current, parent(current)); //Swap values
            current = parent(current);      //update indexes
        }
    }

    public void deleteNode(int num)
    {
        int size = array.size();

        int i;
        //Getting the index of the num from the array
        for(i = 0; i < size; i++)
        {
            if(array.get(i) == num) break;
        }

        //Make it the last element in the heap then remove it.
        swap(i, size-1);
        array.remove(size - 1);

        //Heapify the heap
        for(int j = (size / 2) - 1; j >= 0 ; j--)
        {
            heapify(j);
        }
    }

    public void display()
    {
        System.out.println(array);
    }

    private void swap(int i, int j)
    {
        int temp = array.get(i); //temp=i
        array.set(i, array.get(j)); //i=j
        array.set(j, temp); //j=temp
    }

    private int parent(int i)
    {
        return ((i - 1) / 2);
    }
}
