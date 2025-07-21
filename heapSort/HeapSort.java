import java.util.ArrayList;

public class HeapSort {
    
    private ArrayList<Integer> array;

    HeapSort(ArrayList<Integer> arr)
    {
        array = arr; 
    }

    public void sort()
    {
        int n = array.size();
        // Build max heap
        for (int i = n / 2 - 1; i >= 0; i--)
        {
            heapify(i, n);
        }

        // Heap sort
        for (int i = n - 1; i > 0; i--)
        {
            swap(0, i);
            // Heapify root element for reduced heap
            heapify(0, i);
        }
    }

    private void heapify(int root, int heapSize)
    {
        int largest = root;
        int l = 2 * root + 1;
        int r = 2 * root + 2;

        if (l < heapSize && array.get(l) > array.get(largest)) largest = l;
        if (r < heapSize && array.get(r) > array.get(largest)) largest = r;

        if (root != largest)
        {
            // Swap the values of the largest and the root
            swap(root, largest);
            // Heapify the affected subtree
            heapify(largest, heapSize);
        }
    }

    private void swap(int x, int y)
    {
        int temp = array.get(x);
        array.set(x, array.get(y));
        array.set(y, temp);
    }

    public void display()
    {
        System.out.println(array);
    }

    public static void main(String[] args)
    {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(17);
        arr.add(13);
        arr.add(15);
        arr.add(9);
        arr.add(70);

        HeapSort heap = new HeapSort(arr);
        heap.sort();
        heap.display();
    }
}