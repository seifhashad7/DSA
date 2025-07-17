/* SWC: Generic Dynamic array implementation
 * Author: Seif Hashad
 * Version: v0.1
 * Date: 17 Jul 2025
 */

@SuppressWarnings("unchecked")
public class Array<T> {
    private T[] arr;
    private int length; //length the user thinks it is
    private int capacity; //Actual array length

    //Default Constructor
    Array()
    {
        this(10);
    }

    //Paramatrized Constructor
    Array(int capacity)
    {
        if(capacity < 0) 
            throw new IllegalArgumentException("Illegal capacity: " + capacity);
        this.capacity = capacity;
        arr = (T[]) new Object[capacity];
    }

    public int size()
    {
        return length;
    }

    public boolean isEmpty()
    {
        return (size() == 0);
    }

    public T get(int index)
    {
        if(index < 0 || index >= length) 
            throw new IndexOutOfBoundsException();
        if(arr[index] == null)
            throw new NullPointerException("No value at index " + index);
        return arr[index];
    }

    public void set(T val, int index)
    {
        if(index < 0 || index >= length) 
            throw new IndexOutOfBoundsException();
        if(val == null)
            throw new NullPointerException("Cannot set null value at index " + index);
        arr[index] = val;
    }
    
    public void clear()
    {
        for(int it=0; it < length; it++) 
            arr[it] = null;
        length = 0;
    }

    public void add(T ele)
    {
        //We need to resize our static array
        if(length+1 >= capacity)
        {
            if(capacity == 0) capacity = 1;
            else capacity *= 2; //Double the size
            T[] newArray = (T[]) new Object[capacity];
            for(int it=0; it < length; it++) 
                newArray[it] = arr[it];
            arr = newArray;
        }

        arr[length++] = ele;
    }

    public T removeAt(int index)
    {
        //The logic is iterating over 2 arrays, and when to come to the target in one
        //of these arrs, then I'll skip it
        if(index < 0 || index >= length) 
            throw new IndexOutOfBoundsException();
        T data = arr[index];
        T[] newArr = (T[]) new Object[length-1];

        int i, j;
        for(i=0, j=0; i < length; i++, j++)
        {
            if(i == index)
                j--;
            else
                newArr[j] = arr[i];
        }

        arr = newArr;
        length--;
        return data;
    }

    public int indexOf(T ele)
    {
        for(int i = 0; i < length; i++)
        {
            if(arr[i] != null && arr[i].equals(ele))
            {
                return i;
            }
        }
        return -1;
    }

    public boolean remove(T ele)
    {
        int ind = indexOf(ele);
        if(ind == -1) return false;
        else 
        {
            removeAt(ind);
            return true;
        }
    }

    public boolean contains(T ele)
    {
        return (indexOf(ele) != -1);
    }


    //toString
    @Override
    public String toString()
    {
        if(length == 0) return "[]";
        StringBuilder sb = new StringBuilder(length).append("[");
        for(int it=0; it<length; it++) {
            sb.append(arr[it]);
            if(it < length-1) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
}
