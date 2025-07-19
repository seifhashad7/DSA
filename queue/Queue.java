public class Queue {
    private int front, rear;
    private int[] arr;
    private int size;
    private int maxSize;

    Queue(int maxSize)
    {
        this.maxSize = maxSize;
        arr = new int[maxSize];
        front = -1;
        rear = -1;
        size = 0;
    }

    public boolean isEmpty()
    {
        return (front == -1); //or size == 0
    }

    public boolean isFull()
    {
        return (rear == maxSize - 1); //or size == maxSize
    }

    public void enqueue(int data)
    {
        if(isFull())  throw new RuntimeException("Queue is full");
        //Insert first element 
        if(isEmpty()) front = 0;
        arr[++rear] = data;
        size++;
    }

    public int dequeue()
    {
        if(isEmpty()) throw new RuntimeException("Queue is empty, Nothing to dequeue");
        int element = arr[front];
        if(front >= rear) front = rear = -1;
        else front++;
        size--;
        return element;
    }

    @Override
    public String toString()
    {
        if(isEmpty()) throw new RuntimeException("Queue is empty!!");
        StringBuilder sb = new StringBuilder();
        for(int it = front; it < rear; it++)
        {
            sb.append(arr[it] + ", ");   
        }
        sb.append(arr[rear]);
        return sb.toString();
    }
}
