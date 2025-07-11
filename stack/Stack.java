public class Stack
{
    /*Stack attributes*/
    private int top;
    private int maxSize;
    private int[] arr;
    private int size;

    /*Stack Methods*/
    //Constructor
    public Stack(int stackSize)
    {
        top = -1;
        maxSize = stackSize;
        arr = new int[stackSize];
        size = 0;
    }

    public static boolean isEmpty(Stack s)
    {
        return (s.top == -1);    
    }

    public static boolean isFull(Stack s)
    {
        return (s.top == s.maxSize - 1);
    }

    public static void push(Stack s, int data)
    {
        if(!isFull(s))
        {
            s.arr[++s.top] = data;
            s.size++;
        }
    }

    public static int pop(Stack s)
    {
        int ele = s.arr[s.top--];
        s.size--;
        return ele;
    }

    public static void display(Stack s)
    {
        int i = 0;
        System.out.println("Elements: ");
        while(i != s.size)
        {
            System.out.print(s.arr[i] + " ");
            i++;
        }
        System.out.println();
    }
}