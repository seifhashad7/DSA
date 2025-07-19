public class cQueue {
    private int front, rear;
    private int[] arr;
    private int size;
    private int maxSize;

    cQueue(int maxSize)
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
        return ( ((rear == maxSize - 1) && (front == 0)) || (rear == front -1) ); //or size == maxSize
    }

    public void enqueue(int data)
    {
        if(isFull())  throw new RuntimeException("Queue is full");
        //Insert first element 
        if(isEmpty()) front = 0;
        //instead of only incremeting the rear by 1, mod it by maxSize
        rear = (rear + 1) % maxSize;
        arr[rear] = data;
        size++;
    }

    public int dequeue()
    {
        if(isEmpty()) throw new RuntimeException("Queue is empty, Nothing to dequeue");
        int element = arr[front];
        if(front == rear) front = rear = -1;
        else front = (front + 1) % maxSize; //instead of only incremeting the front by 1, mod it by maxSize
        size--;
        return element;
    }

    @Override
    public String toString()
    {
        if(isEmpty()) return "Queue is empty!!";
        StringBuilder sb = new StringBuilder();
        for(int it = front; it != rear; it = (it+1) % maxSize)
        {
            sb.append(arr[it] + ", ");   
        }
        sb.append(arr[rear]);
        return sb.toString();
    }
}
