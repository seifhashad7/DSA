public class BinarySearch {
    //Naive algorithm
    public static int searchIterative(int[] arr, int key)
    {
        int left = 0;
        int right = arr.length - 1;

        while(left <= right)
        {
            int mid = (left + right) / 2;
            if(arr[mid] == key)
            {
                return mid;
            }
            else if(key < arr[mid])
            {
                right = mid - 1;
            }
            else
            {
                left = mid + 1;
            }
        }
        return -1;
    }

    //Divide and Conquer algorithm
    public static int searchRecursive(int[] arr, int key, int left, int right)
    {
        if(left <= right)
        {
            int mid = (left + right) / 2;

            if(arr[mid] == key) return mid;

            if(key < arr[mid])  return searchRecursive(arr, key, left, mid - 1);

            return searchRecursive(arr, key, mid + 1, right);
        }

        return -1;
    }
    
    public static void main(String[] args)
    {
        int[] arr = {3, 7, 9, 15, 22, 50};
        int i = searchIterative(arr, 22); 
        System.out.println("Found in: " + i);
        int j = searchRecursive(arr, 22, 0, arr.length);
        System.out.println("Found in: " + j);
    }
}
